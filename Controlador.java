import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Controlador {
    Tree<String, String> Arbol;
    Scanner sc = new Scanner(System.in);  // Create a Scanner object
    String Resp;
    String dir = "C:\\Users\\Usuario\\Desktop\\Universidad\\Tercer Semestre\\Datos Compu\\HDT-9\\src\\Palabras.txt";
    String texto = "C:\\Users\\Usuario\\Desktop\\Universidad\\Tercer Semestre\\Datos Compu\\HDT-9\\src\\text.txt";

    String builder = "";



    public void Iniciar() {
        System.out.println("Elija el tipo de arbol que desea usar: 1. AVL, 2. RBT,3. HashMap");
        Resp = sc.nextLine();
        Resp = Resp.toLowerCase();
         Arbol= TreeFactory.createTree(Resp);
        Reader read = new Reader();
        read.Leer(dir);
        for (int i = 0; i <= read.lineas.size()-1; i++) {
            String[] arr = read.lineas.get(i).split("-");
            Arbol.insert(arr[1].toLowerCase(), arr[0].toLowerCase());
        }
        read.lineas.removeAll(read.lineas);
        read.Leer(texto);
        for (int e = 0; e <= read.lineas.size()-1; e++) {
            String palabra = read.lineas.get(e);
            String[] Oracion_Dividida = palabra.split(" ");
            for(int u = 0; u <= Oracion_Dividida.length-1;u++) {
                String temporal = traducir(Oracion_Dividida[u]);
                builder = builder + " " + temporal;
            }
        }
        System.out.println(builder);
    }


    public String traducir(String palabra) {
        String traduccion = null;
        if(Arbol.search(palabra) != null) {
            traduccion = Arbol.search(palabra);
        }
        else {
            traduccion = "*"+palabra+"*";
        }
        return traduccion;
        }
}
