package org.example.UT3.PD12;

import org.example.UT3.PD12.Alumno;
import org.example.UT3.PD12.Conjunto;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ProgramaPD12 {

    public static void main(String[] args) throws IOException {

        // instanciar curso BasicoIng...
        Conjunto<Alumno> BasicoIng = new Conjunto<>();
        // cargar alumnos del curso BasicoIng desde el archivo “basico-ing.txt”
        BasicoIng = LeerArchivoAlumno("src/main/java/org/example/UT3/PD12/basico-ing.txt");


        // instanciar curso BasicoEmp...
        Conjunto<Alumno> BasicoEmp = new Conjunto<>();
        // cargar alumnos del curso BasicoEmp desde el archivo “basico-emp.txt”
        BasicoEmp = LeerArchivoAlumno("src/main/java/org/example/UT3/PD12/basico-emp.txt");




        // generar el curso "integrador101" con los alumnos que están en condiciones de cursarlo  
        Conjunto<Alumno> Integrador101 = new Conjunto<>();
        Integrador101 = BasicoIng.union(BasicoEmp);
        imprimirArchivoAlumno(Integrador101, "src/main/java/org/example/UT3/PD12/Integrador101.txt");

        // generar el curso "exigente102" con los alumnos que están en condiciones de cursarlo
        Conjunto<Alumno> Integrador102 = new Conjunto<>();
        Integrador102 = BasicoIng.interseccion(BasicoEmp);
        imprimirArchivoAlumno(Integrador102, "src/main/java/org/example/UT3/PD12/Integrador102.txt");
    }

    public static Conjunto<Alumno> LeerArchivoAlumno(String ruta) throws IOException {
        String[] lineas = ManejadorArchivosGenerico.leerArchivo(ruta);
        Conjunto<Alumno> conjunto = new Conjunto<>();
        for (int i = 0; i < lineas.length; i++) {
            String[] alumnete = lineas[i].split(",");
            Alumno nuevoAlomno = new Alumno(Integer.parseInt(alumnete[0]), alumnete[1]);
            Nodo<Alumno> alomno = new Nodo<>(nuevoAlomno.getCodigo(), nuevoAlomno);
            conjunto.insertar(nuevoAlomno, nuevoAlomno.getCodigo());
        }
        return conjunto;
    }

    public static void imprimirArchivoAlumno(Conjunto<Alumno> conjunto, String ruta) throws IOException {
       String[] lineas = conjunto.imprimir().split("\n");
       ManejadorArchivosGenerico.escribirArchivo(ruta, lineas);
    }

}
