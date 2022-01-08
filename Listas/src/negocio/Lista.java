package negocio;

/**
 *
 * @author WillyVargasMendez
 */
public class Lista {

    public int cant;
    public Nodo inicio;

    public Lista() {
        cant = 0;
        inicio = null;
    }

    public boolean vacia() {
        return cant == 0;
    }

    public void insertarInicio(int e) {
        Nodo a = new Nodo();
        a.dato = e;
        if (vacia()) {
            inicio = a;
        } else {
            a.enlace = inicio;
            inicio = a;
        }
        cant++;
    }

    public void insertarFinal(int e) {
        Nodo a = new Nodo();
        a.dato = e;
        if (vacia()) {
            inicio = a;
        } else {
            Nodo aux = inicio;
            while (aux.enlace != null) {
                aux = aux.enlace;
            }
            aux.enlace = a;
        }
        cant++;
    }

    public void insertar(int pos, int e) {
        if (pos < cant) {
            Nodo a = new Nodo();
            a.dato = e;
            int c = 0;
            Nodo aux = inicio;
            while (c < pos - 1) {
                aux = aux.enlace;
                c++;
            }
            Nodo sig = aux.enlace;
            aux.enlace = a;
            a.enlace = sig;
        }
    }

    public void insertarOrdenado(int num) {
        Nodo nuevo = new Nodo();
        nuevo.dato = num;
        if (cant == 0) {
            inicio = nuevo;
        } else {
            Nodo aux = inicio;
            Nodo ant = null;
            while (aux != null && aux.dato != num && aux.dato < num) {
                ant = aux;
                aux = aux.enlace;
            }
            if (aux != null && aux.dato == num) {
                System.err.println("Elemento ya insertado");
                return;
            }
            if (ant == null) {//inicio
                nuevo.enlace = inicio;
                inicio = nuevo;
            } else if (aux == null) {//fin
                ant.enlace = nuevo;
            } else {//medio
                ant.enlace = nuevo;
                nuevo.enlace = aux;
            }
        }
        cant++;
    }

    public void eliminar(int pos) {
        if (pos < cant) {
            if (pos == 0) {
                inicio = inicio.enlace;
            } else {
                Nodo aux = inicio;
                int c = 0;
                while (c < pos - 1) {
                    aux = aux.enlace;
                    c++;
                }
                aux.enlace = aux.enlace.enlace;
            }
            cant--;
        }
    }

    public void eliminarElemento(int num) {
        if (vacia()) {
            return;
        }
        Nodo aux = inicio;
        Nodo ant = null;
        while (aux != null && aux.dato != num) {
            ant = aux;
            aux = aux.enlace;
        }
        if (aux == null) {
            System.err.println("Elemento no encontrado");
            return;
        }
        if (ant == null) {
            inicio = inicio.enlace;
        } else {
            ant.enlace = aux.enlace;
        }
        cant--;
    }

    public void set(int pos, int ele) {
        if (pos < cant) {
            Nodo aux = inicio;
            int c = 0;
            while (c < pos) {
                aux = aux.enlace;
                c++;
            }
            aux.dato = ele;
        }
    }

    public int get(int pos) {
        if (pos < cant) {
            Nodo aux = inicio;
            int c = 0;
            while (c < pos) {
                aux = aux.enlace;
                c++;
            }
            return aux.dato;
        }
        return 0;
    }

    @Override
    public String toString() {
        Nodo aux = inicio;
        String s = "[";
        while (aux != null) {
            s += aux.dato;
            if (aux.enlace != null) {
                s += ",";
            }
            aux = aux.enlace;
        }
        return s + "]";
    }

    public void intercalar() {
        if (this.cant > 1) {
            Nodo aux, ant;
            if(this.cant % 2 == 0){
                aux = inicio;
                ant = null;
            }else{
                ant = inicio;
                aux = ant.enlace;
            }
            while (aux != null) {
                Nodo sig = aux.enlace;
                aux.enlace = sig.enlace;
                sig.enlace = aux;
                if (inicio == aux) {
                    inicio = sig;
                }else{
                   ant.enlace = sig; 
                }
                ant = aux;
                aux = aux.enlace;
            }
        }
    }

    public static void main(String[] args) {
        Lista l = new Lista();
        l.insertarOrdenado(1);
        l.insertarOrdenado(2);
        l.insertarOrdenado(3);
        l.insertarOrdenado(4);
        l.insertarOrdenado(5);
        System.out.println(l.toString());
        l.intercalar();
        System.out.println(l.toString());
        l.intercalar();
        System.out.println(l.toString());
    }
}
