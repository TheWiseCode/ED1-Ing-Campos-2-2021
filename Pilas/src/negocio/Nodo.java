package negocio;

/**
 *
 * @author willy
 */
public class Nodo {
    public int dato;
    public Nodo sig; 
    
    public Nodo(){
        sig = null;
    }

    public int getDato() {
        return dato;
    }

    public void setDato(int dato) {
        this.dato = dato;
    }

    public Nodo getSig() {
        return sig;
    }

    public void setSig(Nodo sig) {
        this.sig = sig;
    }
    
    
}
