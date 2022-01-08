package negocio1;

import java.io.Serializable;

/**
 *
 * @author willy
 */
public class Estudiante implements Comparable<Estudiante>, Serializable {

    public int edad;
    public String nombre;

    public Estudiante(int edad, String nombre) {
        this.edad = edad;
        this.nombre = nombre;
    }

    public static void main(String[] args) {
        Estudiante a = new Estudiante(15, "William");
        Estudiante b = new Estudiante(15, "Pedrini");
        int v = a.compareTo(b);
        System.out.println(v);
    }

    //Estudiante a y Estudiante b
    // a.compareTo(b) = -1      => a < b
    // a.compareTo(b) = 0      => a == b
    // a.compareTo(b) = 1      => a > b
    @Override
    public int compareTo(Estudiante otro) {
        /*if (this.edad == otro.edad) {
            return 0;
        } else if (this.edad < otro.edad) {
            return -1;
        } else {
            return 1;
        }*/
        return nombre.compareTo(otro.nombre);
    }

    @Override
    public String toString() {
        return "(" + edad + ", " + nombre + ")";
    }

}
