package negocio;

/**
 *
 * @author WillyVargasMendez
 */
public class Nodo {
    public int izq, der;
    public Nodo enlace;
    
    public Nodo(){
        izq = der = 0;
        enlace = null;
    }
}
