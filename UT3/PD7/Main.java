package org.example.UT3.PD7;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        TAlumno coco = new TAlumno(1266, "Cono", "Incienso");
        TAlumno juan = new TAlumno(2211, "Juan", "Rombo");
        TAlumno chorro = new TAlumno(4215, "Heriberto", "Parral");
        TAlumno pedro = new TAlumno(5918, "Pedro", "Navaja");
        TAlumno morro = new TAlumno(7799, "Manfredo", "Pado");
        TAlumno elsa = new TAlumno(8811, "Elsa", "Capunta");
        TAlumno pocho = new TAlumno(8791, "Luis", "Motoneta");

        IConjunto<TAlumno> AED = new Conjunto<TAlumno>();
        IConjunto<TAlumno> PF = new Conjunto<TAlumno>();

        AED.insertar(juan, juan.getCedula());
        AED.insertar(chorro, chorro.getCedula());
        AED.insertar(morro, morro.getCedula());
        AED.insertar(elsa, elsa.getCedula());

        PF.insertar(coco, coco.getCedula());
        PF.insertar(juan, juan.getCedula());
        PF.insertar(pedro, pedro.getCedula());
        PF.insertar(elsa, elsa.getCedula());
        PF.insertar(pocho, pocho.getCedula());

        IConjunto<TAlumno> inter = AED.intersection(PF);
        IConjunto<TAlumno> union = AED.union(PF);

        System.out.println(inter.imprimir());
        System.out.println(union.imprimir());
    }
}
