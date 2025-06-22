package org.example.UT7.PD8;

import java.util.LinkedList;
import java.util.List;

public class PruebaGrafo {

    public static void main(String[] args) {
        TGrafoDirigido gd = (TGrafoDirigido) UtilGrafos.cargarGrafo("src/main/java/org/example/UT7/PD8/vert", "src/main/java/org/example/UT7/PD8/arist",
                false, TGrafoDirigido.class);


        gd.bpf();

        LinkedList<TArista> arcosArbol = new LinkedList<>();
        LinkedList<TArista> arcosRetroceso = new LinkedList<>();
        LinkedList<TArista> arcosAvance = new LinkedList<>();
        LinkedList<TArista> arcosCruzados = new LinkedList<>();

        gd.clasificarArcos("A", arcosArbol, arcosRetroceso, arcosAvance, arcosCruzados);
        System.out.println(arcosArbol);
        System.out.println(arcosRetroceso);
        System.out.println(arcosAvance);
        System.out.println(arcosCruzados);

    }
}
