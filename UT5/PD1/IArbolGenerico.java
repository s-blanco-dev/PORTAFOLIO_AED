package org.example.UT5.PD1;

public interface IArbolGenerico<T> {
    public TNodoArbolGenerico<T> buscar(Comparable etiq);
    public boolean insertar(Comparable etiq, Comparable etiquetaPadre);
    public String listarIndentado();
}
