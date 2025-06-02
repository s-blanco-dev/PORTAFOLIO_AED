package uy.edu.ucu.aed.tdas;

public class Main {
    public static void main(String[] args) {
        Almacen almacen = new Almacen();
        try {
            almacen.insertarProductosDesdeArchivo("src/main/java/uy/edu/ucu/aed/tdas/altas.TXT");
            System.out.println("Altas cargadas con éxito:");
//            System.out.println(almacen.imprimirProductos());

            almacen.listarOrdenadoPorNombre();
//            System.out.println(almacen.buscarPorDescripcion("ADES� DURAZNO�"));
            Producto cho = almacen.buscarPorDescripcion("ADES� DURAZNO�");

            System.out.println("Antes: " + cho);
            System.out.println(almacen.eliminarCantidad(cho, 20));
            System.out.println("Despues: " + cho + "\n");
            System.out.println("---------------------------");

            almacen.eliminarProductosDesdeArchivo("src/main/java/uy/edu/ucu/aed/tdas/ventas.txt");
        } catch (Exception e) {
            System.err.println("Error al cargar el archivo: " + e.getMessage());
        }

    }
}
