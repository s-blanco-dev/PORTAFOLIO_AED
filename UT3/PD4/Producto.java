package uy.edu.ucu.aed.tdas;

public class Producto implements IProducto {

    private String nombre;
    private String precio;
    private String codigo;
    private int stock;
    public Producto(String nombre, String precio, String codigo, int stock){
        this.nombre = nombre;
        this.precio = precio;
        this.codigo = codigo;
        this.stock = stock;

    }

    @Override
    public Comparable getEtiqueta() {
        return this.codigo;
    }

    @Override
    public Integer getPrecio() {
        return Integer.parseInt(this.precio);
    }

    @Override
    public void setPrecio(Integer precio) {
        this.precio = String.valueOf(precio);
    }

    @Override
    public Integer getStock() {
        return this.stock;
    }

    @Override
    public void setStock(Integer stock) {
        this.stock = stock;
    }

    @Override
    public String getNombre() {
        return this.nombre;
    }

    @Override
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Codigo: " + this.codigo +  "Nombre: " + this.nombre +   "Precio: "+  this.precio + ", Stock: " + this.stock;
    }

}
