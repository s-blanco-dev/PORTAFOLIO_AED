package org.example.UT7.PD7;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PD7_Test {


    @Test
    public void verificarOrdenSimple() {
        Tarea tarea1 = new Tarea("A", 2);
        Tarea tarea2 = new Tarea("B", 3);
        Tarea tarea3 = new Tarea("C", 1);

        TVertice vertice1 = new TVertice<>("A");
        vertice1.setDatos(tarea1);
        TVertice vertice2 = new TVertice<>("B");
        vertice2.setDatos(tarea2);
        TVertice vertice3 = new TVertice<>("C");
        vertice3.setDatos(tarea3);

        List<TVertice> listaVertices = List.of(vertice1, vertice2, vertice3);
        List<TArista> listaAristas = List.of(
                new TArista("A", "B", 1),
                new TArista("B", "C", 1)
        );

        TGrafoDirigido grafoTareas = new TGrafoDirigido(listaVertices, listaAristas);
        LinkedList<Tarea> resultadoOrden = grafoTareas.ordenParcial();

        List<String> ordenEsperado = List.of("A", "B", "C");
        List<String> nombresObtenidos = resultadoOrden.stream()
                .map(Tarea::getNombre)
                .toList();

        assertEquals(ordenEsperado, nombresObtenidos);
    }

    @Test
    public void verificarSinDependencias() {
        Tarea tareaA = new Tarea("A", 1);
        Tarea tareaB = new Tarea("B", 1);

        TVertice verticeA = new TVertice<>("A");
        verticeA.setDatos(tareaA);
        TVertice verticeB = new TVertice<>("B");
        verticeB.setDatos(tareaB);

        List<TVertice> verticesIndependientes = List.of(verticeA, verticeB);
        List<TArista> aristasVacias = List.of();

        TGrafoDirigido grafoIndependiente = new TGrafoDirigido(verticesIndependientes, aristasVacias);
        LinkedList<Tarea> ordenResultado = grafoIndependiente.ordenParcial();

        assertEquals(2, ordenResultado.size());
        List<String> nombres = ordenResultado.stream()
                .map(Tarea::getNombre)
                .toList();
        assertTrue(nombres.containsAll(List.of("A", "B")));
    }
}