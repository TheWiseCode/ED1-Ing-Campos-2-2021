package negocio;

/**
 *
 * @author WillyVargasMéndez
 */
public class Empleado {

    private String nombres;
    private String apellidos;
    private String fechaNac;
    private double sueldo;
    private int horasTrabajo;

    public Empleado() {
    }

    public Empleado(String nombres, String apellidos, String fechaNac, double sueldo, int horasTrabajo) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.fechaNac = fechaNac;
        this.sueldo = sueldo;
        this.horasTrabajo = horasTrabajo;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(String fechaNac) {
        this.fechaNac = fechaNac;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public int getHorasTrabAlMes() {
        return horasTrabajo;
    }

    public void setHorasTrabajo(int horasTrabajo) {
        this.horasTrabajo = horasTrabajo;
    }

    public String nombreCompleto() {
        return nombres + " " + apellidos;
    }

    @Override
    public String toString() {
        return "" + nombres + "," + apellidos + "," + fechaNac + "," + sueldo + "," + horasTrabajo;
    }

}
