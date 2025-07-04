package org.example;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        TArbolTrie trie = new TArbolTrie();

        String[] dic = ManejadorArchivosGenerico.leerArchivo("src/org/example/palabrasIndice.txt");
        for (String w : dic) {
            String p = w.replaceAll("[^A-Za-z]+", "").toLowerCase();
            if (!p.isEmpty()) trie.insertar(p);
        }

        trie.indizarLibro("src/org/example/libro.txt");

        System.out.println("indice:");
        trie.imprimirIndice();

        String[] aBuscar = ManejadorArchivosGenerico.leerArchivo("src/org/example/palabrasABuscar.txt");

        System.out.println("Acá viene la búsqueda en cuestión: ")
        for (String w : aBuscar) {
            String p = w.replaceAll("[^A-Za-z]+", "").toLowerCase();
            if (!p.isEmpty()) trie.buscar(p);
        }
    }
}
