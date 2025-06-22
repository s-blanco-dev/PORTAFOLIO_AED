package org.example.UT7.PD7;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {
        public static void main(String[] args) {

            String[] lineasTareas = ManejadorArchivosGenerico.leerArchivo("src/main/java/org/example/UT7/PD7/tareas.txt", true);
            String[] lineasAristas = ManejadorArchivosGenerico.leerArchivo("src/main/java/org/example/UT7/PD7/precedencias.txt", true);

            List<TVertice> listaVertices = new LinkedList<>();
            List<TArista> listaAristas = new LinkedList<>();

            cargarListaVertices(lineasTareas, listaVertices);
            cargarListaAristas(lineasAristas, listaAristas);

            TGrafoDirigido grafo = new TGrafoDirigido(listaVertices, listaAristas);
            LinkedList<Tarea> orden = grafo.ordenParcial();

            grafo.listarTareas(orden);
            guardeNomas(orden, "orden.txt");
        }

        public static void guardeNomas(LinkedList<Tarea> orden, String archivoSalida) {
            List<String> lineas = new ArrayList<>();
            for (Tarea tarea : orden) {
                lineas.add(tarea.getNombre());
            }
            ManejadorArchivosGenerico.escribirArchivo(archivoSalida, lineas.toArray(new String[0]));
        }

        public static void cargarListaVertices(String[] lineasTareas, List<TVertice> listaVertices){
            for (String linea : lineasTareas) {
                String[] partes = linea.split(",");
                if (partes.length >= 2) {
                    String nombre = partes[0].trim();
                    int tiempo = Integer.parseInt(partes[1].trim());
                    Tarea tarea = new Tarea(nombre, tiempo);
                    TVertice<Tarea> vertice = new TVertice<>(nombre);
                    vertice.setDatos(tarea);
                    listaVertices.add(vertice);
                }
            }
        }

        public static void cargarListaAristas(String[] lineasAristas, List<TArista> listaAristas){
            for (String linea : lineasAristas) {
                String[] partes = linea.split(",");
                if (partes.length >= 2) {
                    listaAristas.add(new TArista(partes[0].trim(), partes[1].trim(), 1));
                }
            }
        }
    }

