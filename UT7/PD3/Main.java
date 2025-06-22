package org.example.UT7.PD3;

public class Main {
    public static void main(String[] args){
        TGrafoDirigido gd = (TGrafoDirigido) UtilGrafos.cargarGrafo("src/main/java/org/example/UT7/PD3/aeropuertos.txt","src/main/java/org/example/UT7/PD3/conexiones.txt",
                false, TGrafoDirigido.class);

        Object[] etiquetasarray = gd.getEtiquetasOrdenado();

        Double[][] matriz = UtilGrafos.obtenerMatrizCostos(gd.getVertices());
        UtilGrafos.imprimirMatrizMejorado(matriz, gd.getVertices(), "Matriz");
        Double[][] mfloyd = gd.floyd();
        UtilGrafos.imprimirMatrizMejorado(mfloyd, gd.getVertices(), "Matriz luego de FLOYD");
        for (int i = 0; i < etiquetasarray.length; i++) {
            System.out.println("excentricidad de " + etiquetasarray[i] + " : " + gd.obtenerExcentricidad((Comparable) etiquetasarray[i]));
        }
        System.out.println("Existe camino entre Montevideo y Curitiba: " + gd.existeCamino("Montevideo", "Curitiba"));
        System.out.println("Existe camino entre Porto Alegre y Santos: " + gd.existeCamino("PortoAlegre", "Santos"));
        System.out.println("Desde Montevideo (BPF): " + gd.bpf("Montevideo"));
        System.out.println(gd.obtenerCaminos("Montevideo", "RioDeJaneiro"));

//        System.out.println("Centro del grafo: " + gd.centroDelGrafo());


    }
}
