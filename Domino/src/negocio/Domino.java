package negocio;

/**
 *
 * @author WillyVargasMendez
 */
public class Domino {

    private Nodo inicio;

    public Domino() {
        inicio = null;
    }

    public void insertar(int a, int b) {
        if (a >= 1 && a <= 6 && b >= 1 && b <= 6) {
            Nodo nuevo = new Nodo();
            nuevo.izq = a;
            nuevo.der = b;
            if (inicio == null) {//esta vacio
                inicio = nuevo;
            } else {
                if (nuevo.der == inicio.izq) {
                    nuevo.enlace = inicio;
                    inicio = nuevo;
                } else if (nuevo.izq == inicio.izq) {
                    int aux = nuevo.izq;
                    nuevo.izq = nuevo.der;
                    nuevo.der = aux;
                    nuevo.enlace = inicio;
                    inicio = nuevo;
                } else {
                    Nodo fin = inicio;
                    while (fin.enlace != null) {
                        fin = fin.enlace;
                    }
                    if (nuevo.izq == fin.der) {
                        fin.enlace = nuevo;
                    } else if (nuevo.der == fin.der) {
                        int aux = nuevo.izq;
                        nuevo.izq = nuevo.der;
                        nuevo.der = aux;
                        fin.enlace = nuevo;
                    }
                }
            }
        }
    }

    public String toString() {
        Nodo aux = inicio;
        String s = "";
        while (aux != null) {
            s += aux.izq + "," + aux.der + "\t";
            aux = aux.enlace;
        }
        return s;
    }

    public static void main(String[] args) {
        Domino d = new Domino();
//        d.insertar(1, 5);
//        d.insertar(6, 1);
//        d.insertar(5, 3);
//        d.insertar(4, 3);
//        d.insertar(4, 7);
//        d.insertar(2, 2);
        d.insertar(1, 1);
        d.insertar(1, 1);
        d.insertar(1, 1);
        d.insertar(1, 1);
        d.insertar(1, 1);
        System.out.println(d);
    }
}
