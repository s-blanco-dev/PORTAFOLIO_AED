package org.example.UT3.PD12;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ernesto
 */
public class Alumno {
    private final int codigo;
    private final String Nombre;

    public Alumno(int codigo, String Nombre) {
        this.codigo = codigo;
        this.Nombre = Nombre;
    }

    /**
     * @return the codigo
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * @return the Nombre
     */
    public String getNombre() {
        return Nombre;
    }

    public String toString() {
        return codigo + "," + Nombre;
    }

    @Override
    public int hashCode() {
        return codigo;
    }
}
