package org.example.UT8.PD32;
import org.example.UT8.PD2.ManejadorArchivosGenerico;

import java.util.Collection;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Programa {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      // cargar grafo con casas y distancias
        TGrafoRedElectrica laRed =  (TGrafoRedElectrica) UtilGrafos.cargarGrafo(
                "src/main/java/org/example/UT8/PD32/barrio.txt",
                "src/main/java/org/example/UT8/PD32/distancias.txt",
                false, TGrafoRedElectrica.class);
       
        /*
           
        calcular la mejor red electrica\
        listar en el archivo "redelectrica.txt" el costo total del cableado
        y las conexiones establecidas, una por linea (origen, destino, costo)
        
        */

        TAristas mejorRed = laRed.mejorRedElectrica();
        String[] impresionFinal = new String[mejorRed.size() + 1];

        Double costoTotal = 0.0;
        for (int i = 1; i < mejorRed.size()+1; i++) {
            costoTotal += mejorRed.get(i-1).getCosto();
            impresionFinal[i] = mejorRed.get(i-1).getEtiquetaOrigen() + " -> " + mejorRed.get(i-1).getEtiquetaDestino() + ": " + mejorRed.get(i-1).getCosto();
        }

        impresionFinal[0] = "-----> COSTO TOTAL: " + costoTotal;

        ManejadorArchivosGenerico.escribirArchivo("src/main/java/org/example/UT8/PD32/redelectrica.txt", impresionFinal);
    }
}
