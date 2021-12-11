package negocio;

/**
 *
 * @author WillyVargasMendez
 */
public class MatrizDispersaFraccion {

    private int nf, nc;
    private int elemN, elemD;
    int[] vfc;
    int[] vd;
    char[] vs;
    private int cont;

    public MatrizDispersaFraccion(int f, int c, int elemN, int elemD) {
        this.nf = f;
        this.nc = c;
        this.elemN = elemN;
        this.elemD = elemD;
        vfc = new int[f * c];
        vd = new int[f * c];
        vs = new char[f * c];
    }

    public void set(int f, int c, int num, int den) {
        if (f >= 1 && f <= nf && c >= 1 && c <= nc) {
            if (num == elemN && den == elemD) {
                return;
            }
            char s = (num * den) > 0 ? '+' : '-';
            num = (int) Math.abs(num);
            den = (int) Math.abs(den);
            int v = (num << 16) | den;
            int pos = buscar(f, c);
            if (pos == -1) {
                int p = (f << 16) | c;
                vfc[cont] = p;
                vd[cont] = v;
                vs[cont] = s;
                cont++;
            } else {
                vd[pos] = v;
                vs[pos] = s;
            }

        }
    }

    public String get(int f, int c) {
        int pos = buscar(f, c);
        if (pos == -1) {
            if (elemN * 1.0 / elemD == 0) {
                return "0";
            }
            return "" + elemN + "/" + elemD;
        } else {
            int val = vd[pos];
            char s = vs[pos];
            int num = val >> 16;
            int dem = (val << 16) >> 16;
            return "" + s + "" + num + "/" + dem;
        }
    }

    public int buscar(int f, int c) {
        int pos = (f << 16) | c;
        for (int i = 0; i < cont; i++) {
            if (pos == vfc[i]) {
                return i;
            }
        }
        return -1;
    }

    public void redimensionar(int f, int c) {
        if (f > 0 && c > 0 && f != nf && c != nc) {
            int n = nf * nc;
            int[] cvfc = new int[n];
            int[] cvd = new int[n];
            char[] cvs = new char[n];
            for (int i = 0; i < cont; i++) {
                cvfc[i] = vfc[i];
                cvd[i] = vd[i];
                cvs[i] = vs[i];
            }
            nf = f;
            nc = c;
            vfc = new int[f * c];
            vd = new int[f * c];
            vs = new char[f * c];
            int ncont = 0;
            for (int i = 0; i < cont; i++) {
                int pos = cvfc[i];
                int xf = pos >> 16;
                int xc = (pos << 16) >>16;
                if(xf <= f && xc <= c){
                    vfc[ncont] = cvfc[i];
                    vd[ncont] = cvd[i];
                    vs[ncont] = cvs[i];
                    ncont++;
                }
            }
            cont = ncont;
        }
    }

    public String toString() {
        String s = "";
        for (int i = 1; i <= nf; i++) {
            s += "|";
            for (int j = 1; j <= nc; j++) {
                String val = get(i, j);
                s += val;
                if (j < nc) {
                    s += "\t";
                }
            }
            s += "|\n";
        }
        return s;
    }

    public static void main(String[] args) {
        MatrizDispersaFraccion m = new MatrizDispersaFraccion(5, 5, 0, 2);
        m.set(1, 1, 1, 1);
        m.set(2, 2, -1, 2);
        m.set(3, 3, -1, -3);
        m.set(4, 4, 1, -4);
        m.set(5, 5, 1, 5);
        //System.out.println(m.toString());
        //m.set(3, 3, 4, 5);
        System.out.println(m.toString());
        m.redimensionar(7, 7);
        System.out.println(m.toString());
        m.redimensionar(3, 3);
        System.out.println(m.toString());
    }
}
