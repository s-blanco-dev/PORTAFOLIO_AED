package org.example.UT3.PD13;

public interface ICola<T> extends ILista<T>{
    public void encolar(T elemento);
    public T desencolar();
    public void anula();
    public T frente();
}
