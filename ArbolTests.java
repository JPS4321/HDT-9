import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class ArbolTests {
    @Test
    void Buscar() {
        AVLTree test1 = new AVLTree();
        test1.insert("hello","hola");
        Assertions.assertEquals("hola",test1.search("hello"));
    }
    @Test
    void Insertar() {
        AVLTree test1 = new AVLTree();
        test1.insert("dos","two");
        Assertions.assertEquals("two",test1.search("dos"));
    }



}
