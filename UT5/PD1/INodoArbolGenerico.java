package org.example.UT5.PD1;


public interface INodoArbolGenerico<T> {
    public Comparable getEtiqueta();
    public void setEtiqueta(Comparable etiqueta);

    public TNodoArbolGenerico<T> getPrimerHijo();
    public void setPrimerHijo(TNodoArbolGenerico<T> primerHijo);

    public TNodoArbolGenerico<T> getSiguienteHermano();
    public void setSiguienteHermano(TNodoArbolGenerico<T> siguienteHermano);

    public TNodoArbolGenerico<T> buscar(Comparable etiq);
    public boolean insertar(Comparable etiq, Comparable etiquetaPadre);
}
