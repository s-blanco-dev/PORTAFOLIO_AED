package org.example.UT7.PD4;

import static java.lang.System.in;
import java.util.Collection;

public class PruebaGrafo {

    public static void main(String[] args) {
        TGrafoDirigido gd = (TGrafoDirigido) UtilGrafos.cargarGrafo("src/main/java/org/example/UT7/PD4/aeropuertos_2.txt", "src/main/java/org/example/UT7/PD4/conexiones_2.txt",
                false, TGrafoDirigido.class);

        
        
//        Collection<TVertice> recorrido_Asuncion = gd.bpf("Asuncion");
//        // imprimir etiquetas del bpf desde Asunción....
//        for (TVertice etVert : recorrido_Asuncion) {
//            System.out.print(etVert + " ");
//        }
        
        
        TCaminos caminos = gd.todosLosCaminos("Asuncion", "Montevideo");
        caminos.imprimirCaminosConsola();
        System.out.println(gd.tieneCiclo());

    }
}
