package org.example.UT5.PD1;

public class TArbolGenerico<T> implements IArbolGenerico{
    private TNodoArbolGenerico<T> raiz;

    public TNodoArbolGenerico<T> getRaiz() {
        return raiz;
    }

    public boolean insertar(Comparable etiq, Comparable etiquetaPadre) {
        if (raiz == null || etiquetaPadre == ""){
            raiz = new TNodoArbolGenerico<T>(etiq);
            return true;
        }

       return raiz.insertar(etiq, etiquetaPadre);
    }

    public TNodoArbolGenerico<T> buscar(Comparable etiq) {
        if (raiz == null) {
            return null;
        }
        return raiz.buscar(etiq);
    }

    public String listarIndentado() {
        StringBuilder ham = new StringBuilder();
        return raiz.listarIndentado(raiz, 0, ham);
    }
}
