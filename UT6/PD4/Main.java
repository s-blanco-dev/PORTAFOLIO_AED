package org.example.UT6.PD4;

import org.example.UT6.PD3.ManejadorArchivosGenerico;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args){

       String[] mugre = ManejadorArchivosGenerico.leerArchivo("src/main/java/org/example/UT6/PD4/libro.txt");
       HashMap<String, Integer> esUnMapa = obtenerPalabras(Arrays.toString(mugre));
       List<HashMap.Entry<String, Integer>> ojo = ordenarPorFrecuencia(esUnMapa);

       System.out.println("10 PALABRAS MAS FRECUENTES");
       for (int i = 0; i < 10; i++) {
           System.out.println(ojo.get(i));
       }
    }

    static HashMap<String, Integer> obtenerPalabras(String lineas) {
        HashMap<String, Integer> mapita = new HashMap<>();
        String[] palabras = lineas.toLowerCase().split("[\\s\\p{Punct}&&[^'-]]+");

        for (String s : palabras) {
            if (mapita.containsKey(s)){
                mapita.put(s, mapita.get(s)+1);
            } else {
                mapita.put(s, 1);
            }
        }

        return mapita;
    }

    static List<HashMap.Entry<String, Integer>> ordenarPorFrecuencia(HashMap<String, Integer> frecuencia) {
        return frecuencia.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .collect(Collectors.toList());
    }
}
