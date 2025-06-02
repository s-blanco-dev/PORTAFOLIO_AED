package org.example.UT3.PD12;

/**
 *
 * @author ernesto
 * @param <T>
 */
public interface IConjunto<T> {

    public Conjunto union (Conjunto otroConjunto);
    public Conjunto interseccion (Conjunto otroConjunto);
}
