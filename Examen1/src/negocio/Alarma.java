package negocio;

/**
 *
 * @author WillyVargasMendez
 */
public class Alarma {

    int cont;
    int[] datos;    
    int[] datos2;
    String[] nombres;

    public Alarma() {
        cont = 0;
        datos = new int[10];
        nombres = new String[10];
    }

    //5, 10, 15
    public void insertar(int dia, int mes, int ano, int hor, int min,
            boolean am, String nombre,
            boolean timbra, int repetir, int duracion) {
        if (cont < 10) {
            nombres[cont] = nombre;
            int vam = am ? 1 : 0;
            int vti = timbra ? 1 : 0;
            int vre;
            if (repetir == 5) {
                vre = 0;
            } else if (repetir == 10) {
                vre = 1;
            } else {
                vre = 2;
            }
            ano -= 2021;
            int valor = 0;
            valor = (dia << 23) | valor;
            valor = (mes << 19) | valor;
            valor = (ano << 17) | valor;
            valor = (hor << 13) | valor;
            valor = (min << 7) | valor;
            valor = (vam << 6) | valor;
            valor = (vti << 5) | valor;
            valor = (vre << 3) | valor;
            valor = duracion | valor;
            //v.set(valor, pos);
            datos[cont] = valor;
            cont++;
        }
    }

    private int dia(int pos) {
        if (pos >= 0 && pos < cont) {
            int x = datos[pos];
            int mask = (int) Math.pow(2, 5) - 1;
            x = x & (mask << 23);
            x = x >> 23;
            return x;
        }
        return 0;
    }

    private int mes(int pos) {
        if (pos >= 0 && pos < cont) {
            int x = datos[pos];
            int mask = (int) Math.pow(2, 4) - 1;
            x = x & (mask << 19);
            x = x >> 19;
            return x;
        }
        return 0;
    }

    private int ano(int pos) {
        if (pos >= 0 && pos < cont) {
            int x = datos[pos];
            int mask = (int) Math.pow(2, 2) - 1;
            x = x & (mask << 17);
            x = x >> 17;
            return x + 2021;
        }
        return 0;
    }

    private int hora(int pos) {
        if (pos >= 0 && pos < cont) {
            int x = datos[pos];
            int mask = (int) Math.pow(2, 4) - 1;
            x = x & (mask << 13);
            x = x >> 13;
            return x;
        }
        return 0;
    }

    private int min(int pos) {
        if (pos >= 0 && pos < cont) {
            int x = datos[pos];
            int mask = (int) Math.pow(2, 6) - 1;
            x = x & (mask << 7);
            x = x >> 7;
            return x;
        }
        return 0;
    }

    private boolean am(int pos) {
        if (pos >= 0 && pos < cont) {
            int x = datos[pos];
            int mask = (int) Math.pow(2, 1) - 1;
            x = x & (mask << 6);
            x = x >> 6;
            return x == 1;
        }
        return false;
    }

    private boolean timbrar(int pos) {
        if (pos >= 0 && pos < cont) {
            int x = datos[pos];
            int mask = (int) Math.pow(2, 1) - 1;
            x = x & (mask << 5);
            x = x >> 5;
            return x == 1;
        }
        return false;
    }

    private int repetir(int pos) {
        if (pos >= 0 && pos < cont) {
            int x = datos[pos];
            int mask = (int) Math.pow(2, 2) - 1;
            x = x & (mask << 3);
            x = x >> 3;
            if (x == 0) {
                return 5;
            } else if (x == 1) {
                return 10;
            } else {
                return 15;
            }
        }
        return 0;
    }

    private int duracion(int pos) {
        if (pos >= 0 && pos < cont) {
            int x = datos[pos];
            int mask = (int) Math.pow(2, 3) - 1;
            x = x & mask;
            return x;
        }
        return 0;
    }

    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < cont; i++) {
            boolean vam = am(i);
            String sam = vam ? "am" : "pm";
            s += nombres[i] + " "
                    + dia(i) + "/" + mes(i) + "/" + ano(i) + "   " + hora(i) + ":"
                    + min(i) + " " + sam + " timbra:" + timbrar(i) + " repite:" + repetir(i)
                    + " Duracion " + duracion(i) + "\n";
        }
        return s;
    }

    public static void main(String[] args) {
        Alarma a = new Alarma();
        a.insertar(12, 8, 2021, 12, 45, true, "Jorge", true, 10, 4);
        a.insertar(29, 01, 2023, 7, 45, false, "Marcos", false, 15, 2);

        System.out.println(a.toString());
    }

}
