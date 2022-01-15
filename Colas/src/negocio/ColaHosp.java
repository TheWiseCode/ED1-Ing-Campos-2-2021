package negocio;

import java.util.Arrays;

/**
 *
 * @author WillyVargasMendez
 */
public class ColaHosp {

    //Poner empieza indice desde 1
    private VectorNBits v;
    int cant;

    public ColaHosp() {
        v = new VectorNBits(100, 10);
        cant = 0;
    }

    public int longitud() {
        return cant;
    }

    public String sacarFicha() {
        if (cant > 0) {
            boolean b = false;
            String e = "";
            int le = longitud();
            for (int i = 0; i < le; i++) {
                String x = decolar();
                if (b == false) {
                    if (x.contains("EMBARAZADA")) {
                        b = true;
                        e = x;
                    } else {
                        String[] partes = x.split(",");
                        encolar(Integer.parseInt(partes[0]), partes[1], partes[2]);
                    }
                } else {
                    String[] partes = x.split(",");
                    encolar(Integer.parseInt(partes[0]), partes[1], partes[2]);
                }
            }
            if (b == false) {
                for (int i = 0; i < le; i++) {
                    String x = decolar();
                    if (b == false) {
                        if (x.contains("3RA EDAD")) {
                            b = true;
                            e = x;
                        } else {
                            String[] partes = x.split(",");
                            encolar(Integer.parseInt(partes[0]), partes[1], partes[2]);
                        }
                    } else {
                        String[] partes = x.split(",");
                        encolar(Integer.parseInt(partes[0]), partes[1], partes[2]);
                    }
                }
            }
            if(b == false){
                return decolar();
            }
            return e;
        }
        return "";
    }

    public String decolar() {
        String r = nro(0) + "," + tipo(0) + "," + prioridad(0);
        for (int i = 1; i < cant; i++) {
            int e = this.v.sacar(i + 1);
            this.v.insertar(e, i);
        }
        cant--;
        return r;
    }

    public void encolar(int nro, String tipo, String prioridad) {
        if (cant < 100) {
            int p;
            int t = tipo.equals("ENFERMERIA") ? 1 : 0;
            if (prioridad.equals("NORMAL")) {
                p = 1;
            } else if (prioridad.equals("EMBARAZADA")) {
                p = 2;
            } else {
                p = 3;
            }
            int x = 0;
            x = x | (nro << 3);
            x = x | (t << 2);
            x = x | p;
            v.insertar(x, cant + 1);
            cant++;
        }
    }

    private int nro(int pos) {
        if (pos >= 0 && pos < cant) {
            int x = v.sacar(pos + 1);
            int mask = (int) Math.pow(2, 7) - 1;
            x = x & (mask << 3);
            x = x >> 3;
            return x;
        }
        return 0;
    }

    private String tipo(int pos) {
        if (pos >= 0 && pos < cant) {
            int x = v.sacar(pos + 1);
            int mask = (int) Math.pow(2, 1) - 1;
            x = x & (mask << 2);
            x = x >> 2;
            return x == 1 ? "ENFERMERIA" : "CONSULTA";
        }
        return "";
    }

    private String prioridad(int pos) {
        if (pos >= 0 && pos < cant) {
            int x = v.sacar(pos + 1);
            int mask = (int) Math.pow(2, 2) - 1;
            x = x & mask;
            if (x == 1) {
                return "NORMAL";
            } else if (x == 2) {
                return "EMBARAZADA";
            } else {
                return "3RA EDAD";
            }
        }
        return "";
    }

    @Override
    public String toString() {
        String s = "[";
        for (int i = 0; i < cant; i++) {
            s += "" + nro(i) + "," + tipo(i) + "," + prioridad(i) + "\t";
        }
        return s + "]";
    }

    public static void main(String[] args) {
        ColaHosp c = new ColaHosp();
        c.encolar(1, "CONSULTA", "NORMAL");
        c.encolar(2, "ENFERMERIA", "3RA EDAD");
        c.encolar(3, "ENFERMERIA", "EMBARAZADA");
        c.encolar(4, "ENFERMERIA", "EMBARAZADA");
        c.encolar(5, "ENFERMERIA", "3RA EDAD");
        System.out.println(c);
        System.out.println(c.sacarFicha());
        System.out.println(c);
        System.out.println(c.sacarFicha());
        System.out.println(c);
        System.out.println(c.sacarFicha());
        System.out.println(c);
        System.out.println(c.sacarFicha());
        System.out.println(c);
        System.out.println(c.sacarFicha());
        System.out.println(c);
    }
}
