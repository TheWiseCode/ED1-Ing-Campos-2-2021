package negocio;
/**
 *
 * @author pc
 */
public class Nodo {

    private int Dato;
    private Nodo Enlace;

    public Nodo(int Dato) {
        this.Dato = Dato;
        this.Enlace = null;
    }

    public Nodo() {
        this.Enlace = null;
    }

    public void setDato(int Dato) {
        this.Dato = Dato;
    }

    public void setEnlace(Nodo Enlace) {
        this.Enlace = Enlace;
    }

    public int getDato() {
        return Dato;
    }

    public Nodo getEnlace() {
        return Enlace;
    }

    @Override
    public String toString() {
        String S = "";
        S = S + Dato;
        return (S);
    }

}
