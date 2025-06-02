package org.example.UT3.PD14;

public class Cola<T> implements ICola<T> {
    private int primero;
    private int prox;
    private T[] array;

    public Cola() {
        this.primero = 0;
        this.prox = 0;
        array = (T[]) new Object[128];
    }

    @Override
    public void poneEnCola(T elemento) {
        if (prox == array.length) {
            redimensionar();
        }
        array[prox] = elemento;
        prox++;
    }

    @Override
    public T quitaDeCola() {
        if (esVacia()) {
            return null;
        }
        T elemento = array[primero];
        primero++;
        return elemento;
    }

    @Override
    public void anula() {
    array = (T[]) new Object[128];
    primero = 0;
    prox = 0;
    }

    @Override
    public T frente() {
        if (esVacia()) {
            return null;
        }
        return array[primero];
    }

    @Override
    public boolean esVacia() {
        return primero == prox;
    }

    private void redimensionar() {
       T[] newArray = (T[]) new Object[array.length * 2];
       for (int i = 0; i < array.length; i++) {
           newArray[i] = array[i];
       }
       array = newArray;
    }
}
