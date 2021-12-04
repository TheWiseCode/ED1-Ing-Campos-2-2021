package negocio;

import datos.VectorNBits;

/**
 *
 * @author WillyVargasMendez
 */
public class ConjuntoFraccionBits {

    private VectorNBits v;
    private int cont;

    public ConjuntoFraccionBits() {
        v = new VectorNBits(100, 9);
        cont = 0;
    }

    private char signo(int pos) {
        if (pos >= 0 && pos < cont) {
            int x = v.sacar(pos);
            int mask = (int) Math.pow(2, 1) - 1;
            x = x & (mask << 8);
            x = x >> 8;
            return x == 1 ? '-' : '+';
        }
        return 0;
    }

    private int numerador(int pos) {
        if (pos >= 0 && pos < cont) {
            int x = v.sacar(pos);
            int mask = (int) Math.pow(2, 4) - 1;
            x = x & (mask << 4);
            x = x >> 4;
            return x;
        }
        return 0;
    }

    private int denominador(int pos) {
        if (pos >= 0 && pos < cont) {
            int x = v.sacar(pos);
            int mask = (int) Math.pow(2, 4) - 1;
            x = x & mask;
            return x;
        }
        return 0;
    }

    public void insertar(int num, int den) {
        int sig = num * den > 0 ? 0 : 1;
        num = (int) Math.abs(num);
        den = (int) Math.abs(den);
        if (num >= 0 && num < 10 && den >= 1 && den < 10) {
            if (cont < 100) {
                int x = 0;
                x = x | (sig << 8);
                x = x | (num << 4);
                x = x | den;
                for(int i = 0; i < cont;i++){
                    int e = v.sacar(i);
                    if(e == x)
                        return;
                }
                v.insertar(x, cont);
                cont++;
            }
        }
    }

    @Override
    public String toString() {
        String s = "{";
        for (int i = 0; i < cont; i++) {
            s += signo(i) + "" + numerador(i) + "/" + denominador(i) + ",";
        }
        if(s.length() != 1)
            s = s.substring(0, s.length() - 1);
        return s + "}";
    }

    public static void main(String[] args) {
        ConjuntoFraccionBits c = new ConjuntoFraccionBits();
        c.insertar(2, 3);
        c.insertar(-4, 8);
        c.insertar(-5, -4);
        c.insertar(-4, 8);
        c.insertar(-5, -4);
        System.out.println(c.toString());
    }
}
