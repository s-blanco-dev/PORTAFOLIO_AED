package uy.edu.ucu.aed.tdas;

import uy.edu.ucu.aed.utils.ManejadorArchivosGenerico;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Almacen extends Lista<Producto> implements IAlmacen {

    private Lista<Producto> listaProductos;
    private String nombre;
    private String direccion;
    private String telefono;

    public Almacen() {
        listaProductos = new Lista<>(); //Cree el constructor
    }

    @Override
    public String getDireccion() {
        return this.direccion;
    }

    @Override
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String getTelefono() {
        return this.telefono;
    }

    @Override
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String getNombre() {
        return this.nombre;
    }

    @Override
    public Lista getListaProductos() {
        return (Lista) this.listaProductos;
    }

    @Override
    public void insertarProducto(Producto unProducto) {
        listaProductos.insertar(unProducto, unProducto.getEtiqueta());
    }

    @Override
    public boolean eliminar(Comparable clave) {
        return listaProductos.eliminar(clave);
    }

    @Override
    public String imprimirProductos() {
        return listaProductos.imprimir();
    }

    @Override
    public String imprimirSeparador(String separador) {
        return "";
    }

    @Override
    public Boolean agregarStock(Comparable clave, Integer cantidad) {
        Producto producto = buscarPorCodigo(clave);
        producto.setStock(producto.getStock() + cantidad);
        return true;
    }

    @Override
    public Integer restarStock(Comparable clave, Integer cantidad) {
        Producto producto = buscarPorCodigo(clave);
        producto.setStock(producto.getStock() - cantidad);
        return producto.getStock();
    }

    @Override
    public Producto buscarPorCodigo(Comparable clave) {
        return (Producto) listaProductos.buscar(clave);
    }

    @Override
public void listarOrdenadoPorNombre() {
    List<Producto> productos = new ArrayList<>();
    Nodo<Producto> actual = listaProductos.getPrimero();

    while (actual != null) {
        productos.add(actual.getDato());
        actual = actual.getSiguiente();
    }

    productos.sort(Comparator.comparing(Producto::getNombre));

    for (Producto producto : productos) {
        System.out.println(producto.getNombre() + ": " + producto);
    }
}
    @Override
    public Producto buscarPorDescripcion(String desc) {
        Nodo<Producto> actual = listaProductos.getPrimero();

        while (actual != null) {
            if (desc.equals(actual.getDato().getNombre())) {
                return actual.getDato();
            }
        }
        return null;
    }

    @Override
    public int cantidadProductos() {
        return listaProductos.cantElementos();
    }

    public int insertarProductos(Producto producto) {
        Producto productoExistente = buscarPorCodigo(producto.getEtiqueta());
        int valorAgregado = 0;

        if (productoExistente == null) {
            listaProductos.insertar(producto, producto.getEtiqueta());
            valorAgregado = producto.getPrecio() * producto.getStock();
        } else {
            productoExistente.setStock(productoExistente.getStock() + producto.getStock());
            valorAgregado = producto.getStock() * producto.getPrecio();
        }

        // Imprimir valor agregado de cada producto
        System.out.println("Valor agregado: $" + valorAgregado);
        return valorAgregado;
    }

    public void insertarProductosDesdeArchivo(String archivo) {
        String[] lista = ManejadorArchivosGenerico.leerArchivo(archivo);
        int valorTotalAgregado = 0;

        for (int i = 0; i < lista.length; i++) {
            String[] elementos = lista[i].split(",");

            String id = elementos[0];
            String descripcion = elementos[1];
            int precio = Integer.parseInt(elementos[2]);
            int cantidad = Integer.parseInt(elementos[3]);

            Producto producto = new Producto(descripcion, String.valueOf(precio), id, cantidad);


            System.out.println("Procesando producto: " + descripcion + ", Precio: " + precio + ", Cantidad: " + cantidad);

            valorTotalAgregado += this.insertarProductos(producto);

        }
        System.out.println("Valor total agregado al stock: $" + valorTotalAgregado);
    }

    public void eliminarProductosDesdeArchivo(String archivo) {
        String[] lista = ManejadorArchivosGenerico.leerArchivo(archivo);
        int valorTotalQuitado = 0;

        for (int i = 1; i < lista.length; i++) {
            String[] elementos = lista[i].split(",");
            String id = elementos[0].trim();
            int cantidad = Integer.parseInt(elementos[1].trim());


            Producto producto = buscarPorCodigo(id);
            if (producto != null) {
                valorTotalQuitado += this.eliminarCantidad(producto, cantidad);

            } else {
                System.out.println("El producto no existe");
            }
        }
        System.out.println("Valor total quitado: $" + valorTotalQuitado);
    }

    public int eliminarCantidad(Producto producto, int cantidad) {
        Producto productoExistente = buscarPorCodigo(producto.getEtiqueta());
        if (productoExistente == null) {
            System.out.println("El producto no existe");
            return 0;
        }

        int cantidadARestar = Math.min(producto.getStock(), cantidad);
        int valorEliminado = cantidadARestar * productoExistente.getPrecio();
        productoExistente.setStock(productoExistente.getStock() - cantidadARestar);
        System.out.println("Se quitaron " + cantidadARestar + " unidades del producto " + producto.getNombre() + ". Valor: $" + valorEliminado);
        return valorEliminado;
    }

//        listaOrdenada.sort(String.CASE_INSENSITIVE_ORDER);
//        System.out.println(listaOrdenada);
    }
