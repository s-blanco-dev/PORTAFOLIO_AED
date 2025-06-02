package org.example.UT3.PD13;

public class PIla<T> implements IPila<T>{
    private Nodo<T> primero;
    private int cantidad;

    public PIla() {
        cantidad = 0;
    }

    @Override
    public T pop() {
        if (primero == null) {
            return null;
        }
        Nodo<T> temporal = primero;
        primero = primero.getSiguiente();
        cantidad--;
        return temporal.getDato();
    }

    @Override
    public boolean push(T dato) {
        Nodo<T> nuevo = new Nodo<>(dato);
        if (primero == null) {
            primero = nuevo;
            cantidad++;
            return true;
        }
        nuevo.setSiguiente(primero);
        primero = nuevo;
        cantidad++;
        return true;
    }

    @Override
    public T tope() {
        if (primero == null) {
            return null;
        }
        return primero.getDato();
    }

    @Override
    public void anula() {
        while (!esVacia()) {
            pop();
        }
    }

    @Override
    public Nodo<T> getPrimero() {
        return primero;
    }

    @Override
    public void insertar(T dato) {
        push(dato);
    }

    @Override
    public int cantElementos() {
        return cantidad;
    }

    @Override
    public boolean esVacia() {
        return primero == null;
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
    public Nodo<T> getUltimo() {
        Nodo<T> actual = primero;
        while (actual.getSiguiente() != null) {
            actual = actual.getSiguiente();
        }
        return actual;
    }

    @Override
    public String imprimir() {
        Nodo<T> actual = primero;
        StringBuilder sb = new StringBuilder();
        while (actual != null) {
           sb.append(actual.getDato());
        }
        return sb.toString();
    }

    @Override
    public String imprimir(String separador) {
        return "";
    }


}
