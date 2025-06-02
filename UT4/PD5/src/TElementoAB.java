package org.example.UT4.PD5;

import org.example.UT4.PD3.BinaryNode;

import java.util.ArrayList;

public class TElementoAB<T> implements IElementoAB<T> {

    private Comparable etiqueta;
    private TElementoAB<T> hijoIzq;
    private TElementoAB<T> hijoDer;
    private T datos;

    /**
     * @param unaEtiqueta
     * @param unosDatos
     * @return
     */
    @SuppressWarnings("unchecked")
    public TElementoAB(Comparable unaEtiqueta, T unosDatos) {
        etiqueta = unaEtiqueta;
        datos = unosDatos;
    }

    /**
     * Retorna el hijo izquierdo del nodo actual.
     *
     * @return Hijo izquierdo del nodo.
     */
    public TElementoAB<T> getHijoIzq() {
        return hijoIzq;
    }

    /**
     * Retorna el hijo derecho del nodo actual.
     *
     * @return Hijo derecho del nodo.
     */
    public TElementoAB<T> getHijoDer() {
        return hijoDer;
    }

    @Override
    public void setHijoIzq(TElementoAB<T> elemento) {
        this.hijoIzq = elemento;


    }

    @Override
    public void setHijoDer(TElementoAB<T> elemento) {
        this.hijoDer = elemento;

    }

    // UT4 - PD5
    // ------------------------------------------------------------
    // ------------------------------------------------------------
    public Comparable obtenerMenorClave() {
        if (hijoIzq == null) {
            return this.etiqueta;
        }
        else {
            return hijoIzq.obtenerMenorClave();
        }
    }

    public Comparable obtenerMayorClave() {
        if (hijoDer == null) {
            return this.etiqueta;
        }
        else {
            return hijoDer.obtenerMayorClave();
        }
    }

    /**
     * Busca la etiqueta del padre del nodo que contiene la etiqueta especificada
     * @param unaEtiqueta La etiqueta del nodo hijo a buscar
     * @return La etiqueta del nodo padre o null si no se encuentra o es la raíz
     */
    public Comparable buscarAnterior(Comparable unaEtiqueta) {
        if (hijoDer != null && unaEtiqueta.equals(hijoDer.getEtiqueta())) {
            return this.etiqueta;
        }

        if (hijoIzq != null && unaEtiqueta.equals(hijoIzq.getEtiqueta())) {
            return this.etiqueta;
        }

        if (unaEtiqueta.compareTo(etiqueta) < 0) {
            if (hijoIzq != null) {
                return getHijoIzq().buscarAnterior(unaEtiqueta);
            } else {
                return null;
            }
        } else if (hijoDer != null) {
            return getHijoDer().buscarAnterior(unaEtiqueta);
        } else {
            return null;
        }
    }

    public void listarHojas(TElementoAB<T> nodo, int nivel) {
        if (nodo == null) {
            return;
        }

        if (nodo.hijoIzq == null && nodo.hijoDer == null) {
            System.out.println(nodo.getEtiqueta().toString() + " - " + nivel);
            return;
        }

        listarHojas(nodo.hijoIzq, nivel+1);
        listarHojas(nodo.hijoDer, nivel+1);
    }

    public int contarNodosNivel(TElementoAB nodo, int nivel){
        if (nodo == null){
            return 0;
        }

        int nodosIzq = contarNodosNivel(nodo.hijoIzq, nivel-1);
        int nodosDer = contarNodosNivel(nodo.hijoDer, nivel-1);

        if (nivel == 0) {
            return 1;
        }

        return nodosIzq + nodosDer;
    }

    public boolean esDeBusqueda() {
        ArrayList<Comparable> elementosInorden = new ArrayList<>();
        inOrden((ArrayList<T>) elementosInorden);

        for (int i = 1; i < elementosInorden.size(); i++) {
            int comparacion = elementosInorden.get(i).compareTo(elementosInorden.get(i - 1));
            if (comparacion <= 0) {
                return false;
            }
        }
        return true;
    }
    // ------------------------------------------------------------
    // ------------------------------------------------------------

    @SuppressWarnings("unchecked")
    /**
     * Inserta un elemento en el árbol
     *
     * @param unElemento El elemento a insertar.
     * @return true si el elemento se insertó correctamente,
     *         false si ya existe un elemento con la misma etiqueta.
     */
    public boolean insertar(TElementoAB<T> unElemento) {
        if (unElemento.getEtiqueta().compareTo(etiqueta) < 0) {
            if (hijoIzq != null) {
                return getHijoIzq().insertar(unElemento);
            } else {
                hijoIzq = unElemento;
                return true;
            }
        } else if (unElemento.getEtiqueta().compareTo(etiqueta) > 0) {
            if (hijoDer != null) {
                return getHijoDer().insertar(unElemento);
            } else {
                hijoDer = unElemento;
                return true;
            }
        } else {
            // Ya existe un elemento con la misma etiqueta.
            return false;
        }
    }

    /**
     * Busca un elemento en el árbol binario de búsqueda por su etiqueta.
     *
     * @param unaEtiqueta La etiqueta del elemento a buscar
     * @return El elemento encontrado, o null si no existe.
     */
    public TElementoAB<T> buscar(Comparable unaEtiqueta) {
        if (unaEtiqueta.equals(etiqueta)) {
            return this;
        } else if (unaEtiqueta.compareTo(etiqueta) < 0) {
            if (hijoIzq != null) {
                return getHijoIzq().buscar(unaEtiqueta);
            } else {
                return null;
            }
        } else if (hijoDer != null) {
            return getHijoDer().buscar(unaEtiqueta);
        } else {
            return null;
        }
    }

    public String inOrden() {
        StringBuilder tempStr = new StringBuilder();
        if (hijoIzq != null) {
            tempStr.append(getHijoIzq().inOrden());
            tempStr.append(TArbolBB.SEPARADOR_ELEMENTOS_IMPRESOS);
        }
        tempStr.append(imprimir());
        if (hijoDer != null) {
            tempStr.append(TArbolBB.SEPARADOR_ELEMENTOS_IMPRESOS);
            tempStr.append(getHijoDer().inOrden());
        }
        return tempStr.toString();
    }


    public void inOrden(ArrayList<T> unaLista) {
        if (hijoIzq != null) {
            hijoIzq.inOrden(unaLista);
        }
        unaLista.add(this.getDatos());
        if (hijoDer != null) {
            hijoDer.inOrden(unaLista);
        }
    }


    @Override
    public Comparable getEtiqueta() {
        return etiqueta;
    }

    public String imprimir() {
        return (etiqueta.toString());
    }

    @Override
    public T getDatos() {
        return datos;
    }

    /**
     * Busca y elimina un nodo basado en su etiqueta
     * @param unaEtiqueta
     * @return -> nodo eliminado
     */
    @Override
    @SuppressWarnings({"unchecked"})
    public TElementoAB<T> eliminar(Comparable unaEtiqueta) {
        if (unaEtiqueta.compareTo(this.getEtiqueta()) < 0) {
            if (this.hijoIzq != null) {
                this.hijoIzq = hijoIzq.eliminar(unaEtiqueta);
            }
            return this;
        }
        if (unaEtiqueta.compareTo(this.getEtiqueta()) > 0) {
            if (this.hijoDer != null) {
                this.hijoDer = hijoDer.eliminar(unaEtiqueta);
            }
            return this;
        }
        return quitaElNodo();
    }


    /**
     * Auxiliar para eliminar(), maneja los casos de eliminación de nodos
     * Casos: es hoja, tiene un hijo sólo, o es nodo interior completo
     * @return -> retorna el nodo a eliminar
     */
    private TElementoAB<T> quitaElNodo() {
        if (hijoIzq == null) {    // solo tiene un hijo o es hoja
            return hijoDer;
        }
        if (hijoDer == null) { // solo tiene un hijo o es hoja
            return hijoIzq;
        }
        // El nodo tiene dos hijos, se busca el nodo anterior
        TElementoAB<T> elHijo = hijoIzq;
        TElementoAB<T> elPadre = this;

        while (elHijo.getHijoDer() != null) {
            elPadre = elHijo;
            elHijo = elHijo.getHijoDer();
        }
        if (elPadre != this) {
            elPadre.setHijoDer(elHijo.getHijoIzq());
            elHijo.setHijoIzq(hijoIzq);
        }
        elHijo.setHijoDer(hijoDer);

        return elHijo;
    }

    /**
     * Obtiene el tamaño del árbol
     * @return -> cantidad de nodos del árbol
     */
    public int obtenerTamanio() {
        int tam = 1;
        if (this.getHijoIzq() != null) {
            tam += this.getHijoIzq().obtenerTamanio();
        }
        if (this.getHijoDer() != null) {
            tam += this.getHijoDer().obtenerTamanio();
        }
        return tam;
    }

    @Override
    public String preOrden() {
        String resultado = this.getDatos().toString();

        if (hijoIzq != null) {
            resultado += "-" + hijoIzq.preOrden();
        }
        if (hijoDer != null) {
            resultado += "-" + hijoDer.preOrden();
        }
        return resultado;
    }



    @Override
    public String postOrden() {
        String resultado = "";
        if (hijoIzq != null) {
            resultado += hijoIzq.postOrden() + "-";
        }
        if (hijoDer != null) {
            resultado += hijoDer.postOrden() + "-";
        }
        resultado += this.getDatos().toString();
        return resultado;
    }

    public int alturaAux() {
        if (this.hijoIzq == null && this.hijoDer == null) {
            return 0;
        } else {
            int izq = (this.hijoIzq != null) ? this.hijoIzq.alturaAux() : -1;
            int der = (this.hijoDer != null) ? this.hijoDer.alturaAux() : -1;
            return 1 + Math.max(izq, der);
        }

    }



/*    public String listarHojas() {
        LinkedList<TElementoAB<T>> hojas = new LinkedList<>();
        listarHojasAux(this, hojas);

        String resultado = "";
        for (TElementoAB<T> nodo : hojas) {
           resultado += nodo.datos.toString() + "\n";
        }
        return resultado;
    }


    public void listarHojasAux(TElementoAB<T> nodo, LinkedList<TElementoAB<T>> hojas) {
        if (nodo == null) {
            return;
        }

        if (nodo.hijoIzq == null && nodo.hijoDer == null) {
            hojas.add(nodo);
            return;
        }

        listarHojasAux(nodo.hijoIzq, hojas);
        listarHojasAux(nodo.hijoDer, hojas);
    }*/
}