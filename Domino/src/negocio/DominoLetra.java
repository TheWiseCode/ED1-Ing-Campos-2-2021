package negocio;

/**
 *
 * @author WillyVargasMendez
 */
public class DominoLetra {

    private NodoLetra inicio, fin;

    public DominoLetra() {
        inicio = fin = null;
    }

    public void insertar(char a, char b) {
        if ((a >= 'a' && a <= 'z' || a >= 'A' && a <= 'Z')
                && (b >= 'a' && b <= 'z' || b >= 'A' && b <= 'Z')) {
            NodoLetra nuevo = new NodoLetra();
            nuevo.izq = a;
            nuevo.der = b;
            if (inicio == null) {
                inicio = fin = nuevo;
            } else {
                if (nuevo.der == inicio.izq) {
                    nuevo.enlace = inicio;
                    inicio = nuevo;
                } else if (nuevo.izq == inicio.izq) {
                    char aux = nuevo.izq;
                    nuevo.izq = nuevo.der;
                    nuevo.der = aux;
                    nuevo.enlace = inicio;
                    inicio = nuevo;
                } else {
                    if (nuevo.izq == fin.der) {
                        fin.enlace = nuevo;
                        fin = nuevo;
                    } else if (nuevo.der == fin.der) {
                        char aux = nuevo.izq;
                        nuevo.izq = nuevo.der;
                        nuevo.der = aux;
                        fin.enlace = nuevo;
                        fin = nuevo;
                    }
                }
            }
        }
    }

    public String toString() {
        NodoLetra aux = inicio;
        String s = "";
        while (aux != null) {
            s += "" + aux.izq + "," + aux.der + "\t";
            aux = aux.enlace;
        }
        return s;
    }

    public static void main(String[] args) {
        DominoLetra d = new DominoLetra();
//        d.insertar('a','b');
//        d.insertar('c','a');
//        d.insertar('c','r');
//        d.insertar('b','b');
//        d.insertar('x','b');
        d.insertar('a', 'a');
        d.insertar('a', 'a');
        d.insertar('a', 'a');
        d.insertar('a', 'a');
        d.insertar('a', 'a');
        System.out.println(d);
    }
}
