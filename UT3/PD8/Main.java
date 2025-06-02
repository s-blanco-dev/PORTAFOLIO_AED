package org.example.UT3.PD8;

public class Main {
    public static void main(String[] args) {
        EstructurasYAlgoritmos este = new EstructurasYAlgoritmos("Gordo");
        este.cargarArchivo("src/main/java/org/example/UT3/PD8/suc3.txt");
        este.imprimirLista();
        System.out.println("\n");
        este.cantidadDeSucursales();
        System.out.println("\n");
        este.ciudadSiguiente("Hong Kong");
    }


}
