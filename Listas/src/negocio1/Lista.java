package negocio1;

import java.io.Serializable;

/**
 *
 * @author willy
 * @param <Tipo>
 */
public class Lista<Tipo extends Comparable<Tipo>> implements Serializable {

    private Nodo<Tipo> inicio;
    private Nodo<Tipo> fin;
    private int cant;

    public Lista() {
        inicio = null;
        fin = null;
        cant = 0;
    }

    public boolean vacia() {
        return cant == 0;
    }

    public void insertar(Tipo num) {
        Nodo<Tipo> nuevo = new Nodo<>();
        nuevo.setDato(num);
        if (cant == 0) {
            inicio = nuevo;
            fin = nuevo;
        } else {
            Nodo<Tipo> aux = inicio; 
            while (aux != null && 
                    aux.getDato().compareTo(num) != 0 && 
                    aux.getDato().compareTo(num) == - 1) {
                aux = aux.getSig();
            }
            if (aux != null && aux.getDato().compareTo(num) == 0) {
                System.err.println("Elemento ya insertado");
                return;
            }
            if (aux == inicio) {//inicio
                nuevo.setSig(inicio);
                inicio.setAnt(nuevo);
                inicio = nuevo;
            } else if (aux == null) {//fin
                fin.setSig(nuevo);
                nuevo.setAnt(fin);
                fin = nuevo;
            } else {//medio
                Nodo<Tipo> ante = aux.getAnt();
                ante.setSig(nuevo);
                aux.setAnt(nuevo);
                nuevo.setSig(aux);
                nuevo.setAnt(ante);
            }
        }
        cant++;
    }

    public void eliminar(Tipo num) {
        if (vacia()) {
            return;
        }
        Nodo<Tipo> aux = inicio;
        while (aux != null && aux.getDato().compareTo(num) != 0) {
            aux = aux.getSig();
        }
        if (aux == null) {
            System.err.println("Elemento no encontrado");
            return;
        }
        if (inicio == fin) {
            inicio = null;
            fin = null;
        } else {
            if (aux == inicio) {
                Nodo<Tipo> sigi = inicio.getSig();
                inicio.setSig(null);
                inicio = sigi;
                inicio.setAnt(null);
            } else if (aux == fin) {
                Nodo<Tipo> ante = fin.getAnt();
                fin.setAnt(null);
                fin = ante;
                fin.setSig(null);
            } else {
                Nodo<Tipo> ante = aux.getAnt();
                Nodo<Tipo> sigi = aux.getSig();
                ante.setSig(sigi);
                sigi.setAnt(ante);
                aux.setAnt(null);
                aux.setSig(null);
            }
        }
        cant--;
    }

    public Tipo get(int pos) {
        int cont = 1;
        Nodo<Tipo> aux = inicio;
        while (aux != null) {
            if (pos == cont) {
                return aux.getDato();
            }
            aux = aux.getSig();
        }
        return null;
    }

    @Override
    public String toString() {
        String s = "[";
        Nodo aux = inicio;
        while (aux != null) {
            s = s + aux.getDato();
            if (aux.getSig() != null) {
                s = s + ",";
            }
            aux = aux.getSig();
        }
        return s + "]";
    }

    public static void main(String[] args) {
        Lista<Estudiante> l = new Lista<>();
        l.insertar(new Estudiante(10, "Z"));
        l.insertar(new Estudiante(20, "X"));
        l.insertar(new Estudiante(15, "Y"));
        //l.insertar(4);
        System.out.println(l.toString());
        /*l.eliminar("b");
        //l.eliminar(7);
        //l.eliminar(1);
        //l.eliminar(4);
        System.out.println(l.toString());
        l.eliminar("f");
        System.out.println(l.toString());
        l.eliminar("a");
        System.out.println(l.toString());
        l.insertar("w");
        l.insertar("x");
        l.insertar("a");
        l.insertar("Z");
        System.out.println(l.toString());*/
    }

}
