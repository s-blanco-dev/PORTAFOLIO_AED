package org.example.UT3.PD13;

public interface IPila<T> extends ILista<T> {
    public boolean push(T dato);
    public T pop();
    public T tope();
    public void anula();
}
