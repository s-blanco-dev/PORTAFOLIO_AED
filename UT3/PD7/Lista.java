package org.example.UT3.PD7;

public class Lista<T> implements ILista<T> {

    private Nodo<T> primero;
    private Nodo<T> ultimo;
    private int cantidad;

    public Lista() {
        primero = null;
        ultimo = null;
    }

    @Override
    public Nodo<T> getPrimero() {
        return primero;
    }

    @Override
    public Nodo<T> getUltimo() {
        return ultimo;
    }

    @Override
    public void insertar(T dato, Comparable clave) {
        Nodo<T> nuevo = new Nodo<T>(clave, dato);
        if (primero == null){
            primero = nuevo;
            ultimo = nuevo;
            cantidad++;
            return;
        }
        ultimo.setSiguiente(nuevo);
        ultimo = ultimo.getSiguiente();
        cantidad++;
    }

    @Override
    public T buscar(Comparable clave) {
        Nodo<T> actual = primero;
        while(actual != null){
            if(actual.getEtiqueta().equals(clave)){
                return actual.getDato();
            }
            actual = actual.getSiguiente();
        }
        return null;
    }



    @Override
    public boolean eliminar(Comparable clave) {
        Nodo<T> actual = primero;
        while(actual.getSiguiente() != null){
            if(actual.getSiguiente().getEtiqueta().equals(clave)){
                actual.setSiguiente(actual.getSiguiente().getSiguiente());
                cantidad--;
                return true;
            }
            actual = actual.getSiguiente();
        }
        return false;
    }


    @Override
    public String imprimir() {
        Nodo<T> actual = primero;
        String cadena = "";
        while(actual != null){
            cadena += actual.getDato() + " ";
            actual = actual.getSiguiente();
        }
        return cadena;
    }

    @Override
    public String imprimir(String separador) {
        Nodo<T> actual = primero;
        String cadena = "";
        while(actual != null){
            cadena += actual.getDato() + separador;
            actual = actual.getSiguiente();
        }
        return cadena;
    }

    @Override
    public int cantElementos() {
        return cantidad;
    }

    @Override
    public boolean esVacia() {
        return primero == null;
    }

}
