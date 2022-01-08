package negocio1;


/**
 *
 * @author willy
 * @param <Tipo>
 */
public class Nodo<Tipo> {
    private Tipo dato;
    private Nodo ant;
    private Nodo sig; 
    
    public Nodo(){
        sig = null;
        ant = null;
    }

    public Tipo getDato() {
        return dato;
    }

    public void setDato(Tipo dato) {
        this.dato = dato;
    }

    public Nodo getSig() {
        return sig;
    }

    public void setSig(Nodo sig) {
        this.sig = sig;
    }
    
    public Nodo getAnt() {
        return ant;
    }

    public void setAnt(Nodo ant) {
        this.ant = ant;
    }
}
