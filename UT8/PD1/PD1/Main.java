package org.example.UT8.PD1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class Main {
    public static void main(String[] args) {

        TVertice t1 = new TVertice<>("A");
        TVertice t2 = new TVertice<>("B");
        TVertice t3 = new TVertice<>("C");
        TVertice t4 = new TVertice<>("D");
        TVertice t5 = new TVertice<>("E");
        TVertice t6 = new TVertice<>("G");

        TArista a1 = new TArista("A", "B", 4);
        TArista a2 = new TArista("A", "C", 10);
        TArista a3 = new TArista("B", "E", 7);
        TArista a4 = new TArista("E", "G", 9);
        TArista a5 = new TArista("E", "C", 14);
        TArista a6 = new TArista("C", "D", 8);

        Collection<TVertice> vert = new ArrayList<>(Arrays.asList(t1, t2, t3, t4, t5, t6));
        Collection<TArista> aristas = new ArrayList<>(Arrays.asList(
                a1,
                a2,
                a3,
                a4,
                a5,
                a6
        ));

        TGrafoNoDirigido gnd = new TGrafoNoDirigido(vert, aristas);
        TGrafoNoDirigido gnd2 = gnd.Prim();


        System.out.println(gnd.bpf());
        UtilGrafos.imprimirMatrizMejorado(UtilGrafos.obtenerMatrizCostos(gnd2.getVertices()), gnd2.getVertices(), "PRIM");

        TVertice v1 = new TVertice<>("a");
        TVertice v2 = new TVertice<>("b");
        TVertice v3 = new TVertice<>("c");
        TVertice v4 = new TVertice<>("d");
        TVertice v5 = new TVertice<>("e");
        TVertice v6 = new TVertice<>("f");
        TVertice v7 = new TVertice<>("g");

        TArista ar1 = new TArista("a", "b", 0);
        TArista ar2 = new TArista("a", "e", 0);
        TArista ar3 = new TArista("b", "e", 0);
        TArista ar4 = new TArista("b", "d", 0);
        TArista ar5 = new TArista("e", "c", 0);
        TArista ar6 = new TArista("c", "f", 0);
        TArista ar7 = new TArista("c", "g", 0);

        Collection<TVertice> verte = new ArrayList<>(Arrays.asList(v1, v2, v3, v4, v5, v6, v7));
        Collection<TArista> areste = new ArrayList<>(Arrays.asList(
                ar1,
                ar2,
                ar3,
                ar4,
                ar5,
                ar6,
                ar7
        ));

        TGrafoNoDirigido grafoBobo = new TGrafoNoDirigido(verte, areste);

        System.out.println(grafoBobo.bea("a"));

    }
}
