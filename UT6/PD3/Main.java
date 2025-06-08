package org.example.UT6.PD3;

import org.example.UT5.ManejadorArchivosGenerico;

import java.io.File;
import java.util.*;

public class Main {
    public static void main(String[] args){
        Map<String, String> theMap = new HashMap<String,String>();
        theMap.put("Rodo", null);
        theMap.put("Mono", null);
        theMap.put("Ogro", "NO NO");
        theMap.put("Sindo", "NE NO");
        System.out.println(theMap.entrySet());
        eliminarEntradasNull(theMap);
        System.out.println(theMap.entrySet());
        invertirEntradas(theMap);
        System.out.println(theMap.entrySet());

        // ------------------------------------------

//        String cadenas[] = ManejadorArchivosGenerico.leerArchivo("src/main/java/org/example/UT5/palabras.txt");
//        imprimeCadenasLongitud(cadenas);

        // ------------------------------------------

        File ham = new File("src/main/java/org/example/UT5/palabras.txt");
        imprimerAlAzar(ham, 5);
    }

    // EJERCICIO 1
    // -------------------------------
    static void eliminarEntradasNull(Map mapa) {
       List<Object> keys = new ArrayList<>(mapa.keySet());
       for (Object key : keys) {
           if (mapa.get(key) == null) {
               mapa.remove(key);
           }
       }
    }

    // EJERCICIO 2
    // -------------------------------
    static void invertirEntradas(Map mapa) {
        if (hayValoresDuplicados(mapa)) {
            throw new Error("TIENE DUPLICADOS");
        }

        List<Object> keys = new ArrayList<>(mapa.keySet());
        for (Object p : keys) {
            mapa.put(mapa.get(p), p);
            mapa.remove(p);
        }
    }

    static boolean hayValoresDuplicados(Map mapa){
        TreeSet aux = new TreeSet();
        for (Object key : mapa.keySet()) {
            if (aux.contains(mapa.get(key))){
                return true;
            }
            aux.add(mapa.get(key));
        }
        return false;
    }

    static void imprimeCadenasLongitud(String[] lineas) {
        Map<Integer, TreeSet<String>> mapaLongitudes = new HashMap<>();
        for (String s : lineas) {
            int longitud = s.length();
            mapaLongitudes.putIfAbsent(longitud, new TreeSet<>());
            mapaLongitudes.get(longitud).add(s);
        }

        Set<Integer> longitudes = mapaLongitudes.keySet();
        int maxLongitud = longitudes.stream().max(Integer::compare).orElse(0); // Algo mágico que encontré en internet

        System.out.println("Ordenadongo:");
        for (int len = 1; len <= maxLongitud; len++) {
            if (mapaLongitudes.containsKey(len)) {
                for (String cadena : mapaLongitudes.get(len)) {
                    System.out.println(cadena);
                }
            }
        }
    }

    // EJERCICIO 4
    // -------------------------------
    static void imprimerAlAzar(File archivo, int cantidadLineasImprimir){
        int largoPromedioLinea = 100;
        int lineasEstimadas = (int) (archivo.length() / largoPromedioLinea);

        List<String> lineas = new ArrayList<>();
//        Set<String> tablita = new HashSet<>(lineasEstimadas);

        String[] lineasArchivo = ManejadorArchivosGenerico.leerArchivo(archivo.getAbsolutePath());
        Collections.addAll(lineas, lineasArchivo);

        Random random = new Random();
        Collections.shuffle(lineas, random);

        for (int i = 0; i < cantidadLineasImprimir; i++) {
            System.out.println(lineas.get(i));
        }
    }
}
