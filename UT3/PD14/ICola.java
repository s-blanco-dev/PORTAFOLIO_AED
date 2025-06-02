package org.example.UT3.PD14;

public interface ICola<T> {
    public void poneEnCola(T elemento);
    public T quitaDeCola();
    public void anula();
    public T frente();
    public boolean esVacia();
}
