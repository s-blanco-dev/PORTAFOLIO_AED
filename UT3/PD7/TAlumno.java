package org.example.UT3.PD7;

public class TAlumno{
    private String nombre;
    private String apellido;
    private int cedula;

    public TAlumno(int cedula, String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getCedula() {
        return cedula;
    }

    public String toString() {
        return nombre + " " + apellido + " " + cedula;
    }
}
