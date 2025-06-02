package org.example.UT3.PD12;


import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author ernesto
 * @param <T>
 */
public class Conjunto<T> extends Lista<T> implements IConjunto {

    @Override
    public Conjunto union(Conjunto otroConjunto) {
        HashSet<Integer> diccionario = new HashSet<>();
        Conjunto<T> resultado = new Conjunto<T>();
        Nodo<T> actualA = this.getPrimero();
        Nodo<T> actualB = otroConjunto.getPrimero();

        while (actualA != null) {
            diccionario.add(actualA.getDato().hashCode());
            resultado.insertar(actualA.getDato(), actualA.getEtiqueta());
            actualA = actualA.getSiguiente();
        }

        while (actualB != null) {
            if (!diccionario.contains(actualB.getDato().hashCode())) {
                resultado.insertar(actualB.getDato(), actualB.getEtiqueta());
            }
            actualB = actualB.getSiguiente();
        }

        return resultado;
    }

    @Override
    public Conjunto interseccion(Conjunto otroConjunto) {
        HashSet<Integer> diccionario = new HashSet<Integer>();
        Conjunto<T> resultado = new Conjunto<T>();
        Nodo<T> actualA = this.getPrimero();
        Nodo<T> actualB = otroConjunto.getPrimero();

        while (actualA != null) {
            diccionario.add(actualA.getDato().hashCode());
            actualA = actualA.getSiguiente();
        }

        while (actualB != null) {
            if (diccionario.contains(actualB.getDato().hashCode())) {
                resultado.insertar(actualB.getDato(), actualB.getEtiqueta());
            }
            actualB = actualB.getSiguiente();
        }

        return resultado;
    }
}
