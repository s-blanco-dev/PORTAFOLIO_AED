package org.example.UT3.PD7;

public interface IConjunto<T> extends ILista<T>{
    public IConjunto<T> union(IConjunto<T> otroConjunto);
    public IConjunto<T> intersection(IConjunto<T> otroConjunto);
    public void agregar(T elemento, Comparable clave);
}
