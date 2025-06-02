package org.example.UT3.PD7;

import org.w3c.dom.Node;

import java.util.Arrays;
import java.util.HashSet;

public class Conjunto<T> implements IConjunto<T> {

    private Nodo<T> primero;
    private Nodo<T> ultimo;
    private int cantidad;

    public Conjunto() {
        this.cantidad = 0;
    }

   /* @Override
    public IConjunto<T> union(IConjunto<T> conjuntoB) {
        IConjunto<T> conjuntoRetorno = new Conjunto<>(); *//* Creo un nuevo conjunto con los mismos elementos del propio *//*
        Nodo<T> actual = this.getPrimero();

        *//* Recorre los elementos del conjuntoB, y si el elemento no está presente en el conjunto conjuntoRetorno,
        * lo agrega al conjunto *//*
        while (actual != null) {
            if (this.buscar(actual.getDato()) == null) {
                conjuntoRetorno.insertar(actual.getDato());
            }
            actual = actual.getSiguiente();
        }
        return conjuntoRetorno;
    }*/



    /**
     * Asumo que la lista está ordenada según dice la letra. Eso me permite escribir un algoritmo
     * de búsqueda de orden O(n) porque no tengo que comparar cada elemento con los demás elementos de la lista
     * en cada iteración.
     * La idea es que cada referencia está apuntando siempre al elemento más chico de cada lista
     * La implementación de este algoritmo la tomé del libro 'Estructuras de Datos y Algoritmos' de Alfred Aho
     * @param conjuntoB
     * @return
     */

    @Override
    public IConjunto<T> intersection(IConjunto<T> conjuntoB) {
        IConjunto<T> conjuntoRetorno = new Conjunto<>(); /* Creo un nuevo conjunto vacío */

        /* Creo dos referencias y las igualo para que apunten en principio al primer nodo
        de ambos respectivamente */
        Nodo<T> actualB = conjuntoB.getPrimero();
        Nodo<T> actualA = this.getPrimero();

        /*
        * Mientras ambos no sean nulos, comparo el dato almacenado en cada nodo
        * Si son iguales avanzo en ambas referencias al siguiente
        * Si a es menor que b, avanzo en la referencia de A
        * Sino avanzo en la referencia de B
         */
        while (actualA != null && actualB != null) {
            int cmp = actualA.getEtiqueta().compareTo(actualB.getEtiqueta()); // O(1)
            if (cmp == 0) {
                conjuntoRetorno.agregar(actualA.getDato(),actualA.getEtiqueta()); // O(1)
                actualA = actualA.getSiguiente(); // O(1)
                actualB = actualB.getSiguiente(); // O(1)
            }
            else if (cmp < 0) {
                    actualA = actualA.getSiguiente(); // O(1)
            }
            else {
                actualB = actualB.getSiguiente(); // O(1)
            }
        }
        return conjuntoRetorno;
    }

    @Override
    public IConjunto<T> union(IConjunto<T> listaB) {
            IConjunto<T> resultado = new Conjunto<T>();
    Nodo<T> actualA = this.primero;
    Nodo<T> actualB = listaB.getPrimero();

    while (actualA != null && actualB != null) {
        int cmp = actualB.getEtiqueta().compareTo(actualA.getEtiqueta());
        if (cmp < 0) {
            resultado.agregar(actualA.getDato(), actualA.getEtiqueta());
            actualA = actualA.getSiguiente();
        } else if (cmp > 0) {
            resultado.agregar(actualB.getDato(), actualB.getEtiqueta());
            actualB = actualB.getSiguiente();
        } else {
            resultado.agregar(actualA.getDato(), actualA.getEtiqueta());
            actualA = actualA.getSiguiente();
            actualB = actualB.getSiguiente();
        }
    }

    // Agregar elementos restantes
    while (actualA != null) {
        resultado.insertar(actualA.getDato(), actualA.getEtiqueta());
        actualA = actualA.getSiguiente();
    }

    while (actualB != null) {
        resultado.insertar(actualB.getDato(), actualB.getEtiqueta());
        actualB = actualB.getSiguiente();
    }

    return resultado;
    }

    public IConjunto<T> intersectionHash(IConjunto<T> conjuntoB) {
        HashSet<T> elementos = new HashSet<>();
        IConjunto<T> conjuntoRetorno = new Conjunto<>();
        Nodo<T> actualA = this.getPrimero();
        Nodo<T> actualB = conjuntoB.getPrimero();

        while (actualA != null) {
            elementos.add(actualA.getDato());
            actualA = actualA.getSiguiente();
        }

        while (actualB != null) {
            if (elementos.contains(actualB.getDato())) {
               conjuntoRetorno.agregar(actualB.getDato(), actualB.getEtiqueta());
            }
            actualB = actualB.getSiguiente();
        }
        return conjuntoRetorno;
    }

    @Override
    public Nodo<T> getPrimero() {
        return this.primero;
    }

    @Override
    public Nodo<T> getUltimo() {
        return this.ultimo;
    }

//    @Override
//    public IConjunto<T> intersection(IConjunto<T> conjuntoB) {
//        IConjunto<T> conjuntoRetorno = new Conjunto<>(); /* Creo un nuevo conjunto vacío */
//        Nodo<T> actualA = this.getPrimero();
//
//        /*  */
//        while (actualA != null) {
//            if (conjuntoB.buscar(actualA.getDato()) != null) {
//                conjuntoRetorno.agregar(actualA.getDato());
//            }
//            actualA = actualA.getSiguiente();
//        }
//        return conjuntoRetorno;
//    }

    @Override
       public void insertar(T valor, Comparable etiqueta) {
        if (buscar(etiqueta) == null) {
            agregar(valor, etiqueta);
        }
    }

    @Override
    public void agregar(T valor, Comparable clave) {
        Nodo<T> nuevo = new Nodo<>(clave, valor);
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
        if (esVacia()) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        Nodo<T> nodo = this.getPrimero();
        sb.append("{ ");
        while (nodo != null) {
            sb.append(nodo.getDato()).append(", ");
            nodo = nodo.getSiguiente();
        }
        sb.append(" }");
        return sb.toString();
    }

    @Override
    public String imprimir(String separador) {
        return null;
    }

    @Override
    public int cantElementos() {
        return cantidad;
    }

    @Override
    public boolean esVacia() {
        return primero == null;
    }

    public IConjunto<T> copiar() {
        IConjunto<T> copia = new Conjunto<T>();
        Nodo<T> actual = primero;
        while (actual != null) {
            copia.agregar(actual.getDato(), actual.getEtiqueta());
            actual = actual.getSiguiente();
        }
        return copia;
    }
}
