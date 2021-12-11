package negocio;

/**
 *
 * @author WillyVargasMendez
 */
public class MatrizDispersaFraccionEntero {

    private int nf, nc;
    private int elem;
    int[] vfc;
    int[] vd;
    int[] ve;
    private int cont;

    public MatrizDispersaFraccionEntero(int f, int c) {
        this.nf = f;
        this.nc = c;
        this.elem = 0;
        vfc = new int[f * c];
        vd = new int[f * c];
        ve = new int[f * c];
    }

    public void set(int f, int c,int ent, int num, int den) {
        if (f >= 1 && f <= nf && c >= 1 && c <= nc) {
            //char s = (num * den) > 0 ? '+' : '-';
            //num = (int) Math.abs(num);
            //den = (int) Math.abs(den);
            int v = (num << 16) | den;
            int pos = buscar(f, c);
            if (pos == -1) {
                int p = (f << 16) | c;
                vfc[cont] = p;
                vd[cont] = v;
                ve[cont] = ent;
                cont++;
            } else {
                vd[pos] = v;
                ve[pos] = ent;
            }

        }
    }

    public String get(int f, int c) {
        int pos = buscar(f, c);
        if (pos == -1) {
            return "" + elem;
        } else {
            int val = vd[pos];
            int e = ve[pos];
            int num = val >> 16;
            int dem = (val << 16) >> 16;
            return "" + e + " " + num + "/" + dem;
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
            int[] cve = new int[n];
            for (int i = 0; i < cont; i++) {
                cvfc[i] = vfc[i];
                cvd[i] = vd[i];
                cve[i] = ve[i];
            }
            nf = f;
            nc = c;
            vfc = new int[f * c];
            vd = new int[f * c];
            ve = new int[f * c];
            int ncont = 0;
            for (int i = 0; i < cont; i++) {
                int pos = cvfc[i];
                int xf = pos >> 16;
                int xc = (pos << 16) >>16;
                if(xf <= f && xc <= c){
                    vfc[ncont] = cvfc[i];
                    vd[ncont] = cvd[i];
                    ve[ncont] = cve[i];
                    ncont++;
                }
            }
            cont = ncont;
        }
    }

    @Override
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
        MatrizDispersaFraccionEntero m = new MatrizDispersaFraccionEntero(5, 5);
        m.set(1, 1, 2, 1, 1);
        m.set(2, 2, 3, 1, 2);
        m.set(3, 3, -4, 1, 3);
        m.set(4, 4, 5, 1, 4);
        m.set(5, 5, 7, 1, 5);
        //System.out.println(m.toString());
        //m.set(3, 3, 4, 5);
        System.out.println(m.toString());
        m.redimensionar(7, 7);
        System.out.println(m.toString());
        m.redimensionar(3, 3);
        System.out.println(m.toString());
    }
}
