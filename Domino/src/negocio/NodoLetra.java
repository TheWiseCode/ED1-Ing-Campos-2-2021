package negocio;

/**
 *
 * @author WillyVargasMendez
 */
public class NodoLetra {
    public char izq, der;
    public NodoLetra enlace;
    
    public NodoLetra(){
        izq = der = 0;
        enlace = null;
    }
}
