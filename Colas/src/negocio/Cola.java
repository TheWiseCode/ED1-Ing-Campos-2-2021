package negocio;

/**
 *
 * @author pc
 */
public class Cola {

    private Nodo frente;
    private Nodo atras;
    private int cant;

    public Cola() {
        frente = atras = null;
        cant = 0;
    }

    public boolean vacia() {
        return frente == null;
    }

    public void encolar(int ele) {
        Nodo aux = new Nodo(ele);
        if (vacia()) {
            frente = atras = aux;
        } else {
            atras.setEnlace(aux);
            atras = aux;
        }
        cant++;
    }

    public int decolar() {
        if (!vacia()) {
            int ele = frente.getDato();
            if (frente == atras) {
                frente = atras = null;
            } else {
                frente = frente.getEnlace();
            }
            cant--;
            return ele;
        } else {
            System.out.println("Cola Vacia");
            return -1;
        }
    }

    public int getFrente() {
        if (!vacia()) {
            return frente.getDato();
        } else {
            System.out.println("Error Cola Vacia");
            return -1;
        }
    }

    public int size() {
        return cant;
    }

    @Override
    public String toString() {
        String s = "[";
        Nodo aux = frente;
        while (aux != null) {
            s += aux.getDato();
            aux = aux.getEnlace();
            if (aux != null) {
                s += ",";
            }
        }
        return s + "]";
    }

    public int longitud() {
        return cant;
    }

    public void eliminarRepetidos() {
        if (this.longitud() > 1) {
            int lo = this.longitud();
            int x = 0;
            while (x < lo) {
                int piv = this.decolar();
                int l = this.longitud();
                for (int i = 0; i < l; i++) {
                    int e = this.decolar();
                    if (piv != e) {
                        this.encolar(e);
                    } else {
                        lo--;
                    }
                }
                this.encolar(piv);
                x++;
            }
        }
    }

    public void invertirExtremos(PilaV pila) {
        Cola cola = this;
        if (cola.longitud() > 1 || pila.longitud() > 1) {
            int pc = cola.decolar();
            for (int i = 0; i < cola.longitud() - 1; i++) {
                cola.encolar(cola.decolar());
            }
            int uc = cola.decolar();
            int pp = pila.pop();
            int ec = cola.longitud();
            int ep = pila.longitud() - 1;
            for (int i = 0; i < ep; i++) {
                cola.encolar(pila.pop());
            }
            int up = pila.pop();
            for (int i = 0; i < ec; i++) {
                cola.encolar(cola.decolar());
            }
            pila.push(up);
            for (int i = 0; i < ep; i++) {
                pila.push(cola.decolar());
            }
            pila.push(pp);
            cola.encolar(pc);
            ec = cola.longitud();
            ep = pila.longitud();
            for (int i = 0; i < ep; i++) {
                cola.encolar(pila.pop());
            }
            cola.encolar(uc);
            for(int i = 0;i < ec;i++){
                cola.encolar(cola.decolar());
            }
            for (int i = 0; i < ep; i++) {
                pila.push(cola.decolar());
            }
        }
    }

    public static void main(String[] args) {
        Cola c = new Cola();
        c.encolar(5);
        c.encolar(6);
        c.encolar(7);
        c.encolar(8);
        PilaV p = new PilaV();
        p.push(1);
        p.push(2);
        p.push(3);
        p.push(4);
        System.out.println(c.toString());
        System.out.println(p.toString());
        c.invertirExtremos(p);
        System.out.println(c.toString());
        System.out.println(p.toString());

    }
}
