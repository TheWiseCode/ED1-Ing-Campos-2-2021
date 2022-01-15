package negocio;

/**
 *
 * @author WillyVargasMendez
 */
public class ColaBanco {

    private VectorNBits v;
    int cant;

    public ColaBanco() {
        v = new VectorNBits(100, 9);
        cant = 0;
    }

    public String decolar() {
        String tipoCaja = this.tipoPlataforma(0) ? "Plataforma" : "Caja";
        String tipoUser = this.tipoTercera(0) ? "3ra Edad" : "Cliente";
        String r = this.nro(0) + "," + tipoCaja + "," + tipoUser;
        for (int i = 1; i < cant; i++) {
            int e = this.v.sacar(i + 1);
            this.v.insertar(e, i);
        }
        cant--;
        return r;
    }

    public void encolar(int nro, boolean tipoPlataforma, boolean tipoTercera) {
        if (cant < 100) {
            int tp = tipoPlataforma ? 1 : 0;
            int tt = tipoTercera ? 1 : 0;
            int x = 0;
            x = x | (nro << 2);
            x = x | (tp << 1);
            x = x | tt;
            v.insertar(x, cant + 1);
            cant++;
        }
    }

    private int nro(int pos) {
        if (pos >= 0 && pos < cant) {
            int x = v.sacar(pos + 1);
            int mask = (int) Math.pow(2, 7) - 1;
            x = x & (mask << 2);
            x = x >> 2;
            return x;
        }
        return 0;
    }

    private boolean tipoPlataforma(int pos) {
        if (pos >= 0 && pos < cant) {
            int x = v.sacar(pos + 1);
            int mask = (int) Math.pow(2, 1) - 1;
            x = x & (mask << 1);
            x = x >> 1;
            return x == 1;
        }
        return false;
    }

    private boolean tipoTercera(int pos) {
        if (pos >= 0 && pos < cant) {
            int x = v.sacar(pos + 1);
            int mask = (int) Math.pow(2, 1) - 1;
            x = x & mask;
            return x == 1;
        }
        return false;
    }

    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < cant; i++) {
            String tipoCaja = this.tipoPlataforma(i) ? "Plataforma" : "Caja";
            String tipoUser = this.tipoTercera(i) ? "3ra Edad" : "Cliente";
            s += nro(i) + "," + tipoCaja + "," + tipoUser + "\t";
        }
        return s;
    }

    public static void main(String[] args) {
        ColaBanco c = new ColaBanco();
        c.encolar(1, false, false);
        c.encolar(2, true, false);
        c.encolar(3, false, true);
        c.encolar(4, true, true);
        System.out.println(c);
        System.out.println(c.decolar());
        System.out.println(c);
    }
}
