package org.example.UT8.PD2;

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
        TGrafoNoDirigido gnd2 = gnd.Kruskal();
        TGrafoNoDirigido gndP = gnd.Prim();


        UtilGrafos.imprimirMatrizMejorado(UtilGrafos.obtenerMatrizCostos(gndP.getVertices()), gndP.getVertices(), "COMPARO CON PRIM");
        UtilGrafos.imprimirMatrizMejorado(UtilGrafos.obtenerMatrizCostos(gnd2.getVertices()), gnd2.getVertices(), "KRUSKAL");
    }
}
