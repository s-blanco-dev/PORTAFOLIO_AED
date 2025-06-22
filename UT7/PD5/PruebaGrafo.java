package org.example.UT7.PD5;

public class PruebaGrafo {

    public static void main(String[] args) {
        TGrafoDirigido gd = (TGrafoDirigido) UtilGrafos.cargarGrafo("src/main/java/org/example/UT7/PD5/vert", "src/main/java/org/example/UT7/PD5/arist",
                false, TGrafoDirigido.class);

        
        
//        Collection<TVertice> recorrido_Asuncion = gd.bpf("Asuncion");
//        // imprimir etiquetas del bpf desde Asunción....
//        for (TVertice etVert : recorrido_Asuncion) {
//            System.out.print(etVert + " ");
//        }
        
        
        System.out.println(gd.tieneCiclo());
        System.out.println(gd.topSort());

    }
}
