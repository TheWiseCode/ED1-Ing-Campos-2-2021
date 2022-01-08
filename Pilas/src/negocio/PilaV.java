package negocio;

/**
 *
 * @author willy
 */
public class PilaV {

    private int v[];
    private int num;
    private int cant;

    public PilaV() {
        cant = 0;
        num = 10;
        v = new int[num];
    }

    public void push(int e) {
        if (cant < num) {
            v[cant] = e;
            cant++;
        } else {
            int n = num;
            num += 10;
            int vec[] = new int[n];
            for (int i = 0; i < n; i++) {
                int el = v[i];
                vec[i] = el;
            }
            v = new int[num];
            for (int i = 0; i < n; i++) {
                int el = vec[i];
                v[i] = el;
            }
            v[cant] = e;
            cant++;
        }
    }

    public int pop() {
        if (!vacia()) {
            int e = v[cant - 1];
            cant--;
            return e;
        } else {
            System.err.println("Pila vacia");
            return 0;
        }
    }

    public int peek() {
        if (!vacia()) {
            return v[cant - 1];
        } else {
            System.err.println("Pila vacia");
            return 0;
        }
    }

    public boolean vacia() {
        return cant == 0;
    }

    @Override
    public String toString() {
        String s = "";
        for (int i = cant; i >= 1; i--) {
            int e = v[i - 1];
            s += "| " + e + " |\n";
        }
        s += "|---|";
        return s;
    }

    public int longitud() {
        return cant;
    }

    public void intercambiar() {
        if (this.longitud() > 1) {
            Integer cima = null;
            if (longitud() % 2 == 1) {
                cima = this.pop();
            }
            int x = this.pop();
            int y = this.pop();
            intercambiar();
            this.push(x);
            this.push(y);
            if (cima != null) {
                this.push(cima);
            }
        }
    }

    public void intercambiar1() {
        if (this.longitud() > 1) {
            boolean b = longitud() % 2 == 1;
            int cima = 0;
            if (b) {
                cima = this.pop();
            }
            int x = this.pop();
            int y = this.pop();
            intercambiar();
            this.push(x);
            this.push(y);
            if (b) {
                this.push(cima);
            }
        }
    }

    public static void main(String[] args) {
        PilaV p = new PilaV();
        p.push(1);
        p.push(2);
        p.push(3);
        p.push(4);
        //p.push(5);
        System.out.println(p.toString());
        p.intercambiar1();
        System.out.println(p.toString());
    }
}
