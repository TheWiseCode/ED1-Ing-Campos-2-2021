package negocio;

/**
 *
 * @author WillyVargasMendez
 */
public class PlantillaCovid {

    private final String[] nombres;
    private final int[] valores;
    private int cont;

    public PlantillaCovid() {
        cont = 0;
        nombres = new String[10];
        valores = new int[10];
    }

    private char sexo(int pos) {
        if (pos >= 0 && pos < cont) {
            int x = valores[pos];
            int mask = (int) Math.pow(2, 1) - 1;
            x = x & (mask << 12);
            x = x >> 12;
            return x == 1 ? 'M' : 'F';
        }
        return 0;
    }

    private int edad(int pos) {
        if (pos >= 0 && pos < cont) {
            int x = valores[pos];
            int mask = (int) Math.pow(2, 7) - 1;
            x = x & (mask << 5);
            x = x >> 5;
            return x;
        }
        return 0;
    }

    private boolean fiebre(int pos) {
        if (pos >= 0 && pos < cont) {
            int x = valores[pos];
            int mask = (int) Math.pow(2, 1) - 1;
            x = x & (mask << 4);
            x = x >> 4;
            return x == 1;
        }
        return false;
    }

    private boolean tos(int pos) {
        if (pos >= 0 && pos < cont) {
            int x = valores[pos];
            int mask = (int) Math.pow(2, 1) - 1;
            x = x & (mask << 3);
            x = x >> 3;
            return x == 1;
        }
        return false;
    }

    private boolean diarrea(int pos) {
        if (pos >= 0 && pos < cont) {
            int x = valores[pos];
            int mask = (int) Math.pow(2, 1) - 1;
            x = x & (mask << 2);
            x = x >> 2;
            return x == 1;
        }
        return false;
    }

    private boolean dolorCabeza(int pos) {
        if (pos >= 0 && pos < cont) {
            int x = valores[pos];
            int mask = (int) Math.pow(2, 1) - 1;
            x = x & mask;
            return x == 1;
        }
        return false;
    }

    private boolean dolorGarganta(int pos) {
        if (pos >= 0 && pos < cont) {
            int x = valores[pos];
            int mask = (int) Math.pow(2, 1) - 1;
            x = x & (mask << 1);
            x = x >> 1;
            return x == 1;
        }
        return false;
    }

    public void insertar(String nombre, char sexo, int edad, boolean fiebre, boolean tos, boolean diarrea, boolean dolGarg, boolean dolCab) {
        if (cont < 10) {
            nombres[cont] = nombre;
            int x = 0;
            int sex = sexo == 'M' ? 1 : 0;
            int fie = fiebre ? 1 : 0;
            int ts = tos ? 1 : 0;
            int dia = diarrea ? 1 : 0;
            int dgr = dolGarg ? 1 : 0;
            int dcz = dolCab ? 1 : 0;
            x = x | (sex << 12);
            x = x | (edad << 5);
            x = x | (fie << 4);
            x = x | (ts << 3);
            x = x | (dia << 2);
            x = x | (dgr << 1);
            x = x | dcz;
            valores[cont] = x;
            cont++;
        }
    }

    public String toString() {
        String s = "";
        for (int i = 0; i < cont; i++) {
            String sint = "";
            if (fiebre(i)) {
                sint += "Fiebre ";
            }
            if (tos(i)) {
                sint += "Tos ";
            }
            if (diarrea(i)) {
                sint += "Diarrea ";
            }
            if (dolorGarganta(i)) {
                sint += "Dolor garganta";
            }
            if (dolorCabeza(i)) {
                sint += "Dolor cabeza";
            }
            if(sint.length() == 0)
                sint = "No tiene";
            s += nombres[i] + ", " + sexo(i) + ", " + edad(i) + ", Sintomas: " + sint + "\n";
        }
        return s;
    }

    public static void main(String[] args) {
        PlantillaCovid pc = new PlantillaCovid();
        pc.insertar("Carlos", 'M', 34, true, true, false, true, false);
        pc.insertar("Fernanda", 'F', 17, false, true, true, true, false);
        pc.insertar("Fernanda", 'F', 17, false, false, false, false, false);
        System.out.println(pc.toString());
    }
}
