package org.example.UT7.PD7;

public class Tarea implements Comparable {
    private String nombre;
    private int tiempo;

    public String getNombre() {
        return nombre;
    }
    public int getTiempo() {
        return tiempo;
    }

    public Tarea(String nombre, int tiempo) {
        this.nombre = nombre;
        this.tiempo = tiempo;
    }

    @Override
    public int compareTo(Object o) {
        return nombre.compareTo(((Tarea) o).getNombre());
    }

    @Override
    public String toString() {
       return nombre + "| T:" + tiempo;
    }
}
