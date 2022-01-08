package negocio;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author WillyVargasMendez
 */
public class Nodo {
    public int dato;
    public Nodo enlace;
    
    public Nodo(){
        dato = 0;
        enlace = null;
    }
    
    public static void main(String[] args) {
        Nodo a = new Nodo();
        Nodo b = new Nodo();
        a.enlace = b;
        System.out.println(a.toString());
        System.out.println(b.toString());
        System.out.println(a.enlace.toString());
    }
}
