package org.example.UT3.PD13;

public class Cola<T> implements ICola<T> {
    private Nodo<T> primero;
    private Nodo<T> ultimo;
    private int cantidad;

    public Cola() {
        cantidad = 0;
    }

    @Override
    public void encolar(T elemento) {
        Nodo<T> nuevo = new Nodo<T>(elemento);
        if (primero == null) {
            primero = nuevo;
            ultimo = nuevo;
        } else {
           ultimo.setSiguiente(nuevo);
           ultimo = nuevo;
        }
        cantidad++;
    }

    @Override
    public T desencolar() {
        Nodo<T> temp = primero;
        if (primero == null) {
            return null;
        }
        if (cantidad == 1) {
            primero = null;
            ultimo = null;
        }
        else {
            primero = primero.getSiguiente();
            temp.setSiguiente(null);
        }
        cantidad--;
        return temp.getDato();
    }

    @Override
    public void anula() {
        while (!esVacia()) {
            desencolar();
        }
    }

    @Override
    public T frente() {
        if (esVacia()) {
            return null;
        }
        return primero.getDato();
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
    public void insertar(T dato) {
        encolar(dato);
    }

    @Override
    public Nodo<T> buscar(T dato) {
        Nodo<T> actual = primero;
        while (actual != null) {
            if (actual.getDato().equals(dato)) {
                return actual;
            }
            actual = actual.getSiguiente();
        }
        return null;
    }

    @Override
       public boolean eliminar(T dato) {
        if (this.primero == null) {
            return false;
        }
        if (this.primero.getDato().equals(dato)) {
            this.primero = primero.getSiguiente();
            cantidad--;
            return true;
        }

        Nodo<T> anterior = this.primero;
        Nodo<T> actual = this.primero;

        while (actual != null) {
            if (actual.getDato().equals(dato)) {
                anterior.setSiguiente(actual.getSiguiente());
                cantidad--;
                return true;
            }
            anterior = actual;
            actual = actual.getSiguiente();
        }

        return false;
    }

    @Override
    public String imprimir() {
        return "bobada";
    }

    @Override
    public String imprimir(String separador) {
        return "";
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
