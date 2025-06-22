package org.example.UT7.PD8;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class TVertice<T> implements IVertice {

    private Comparable etiqueta;
    private LinkedList<TAdyacencia> adyacentes;
    private boolean visitado;
    private T datos;
    private int tiempoDescubrimiento = 0;
    private int tiempoFinalizacion = 0;
    private static int tiempo = 0;

    public Comparable getEtiqueta() {
        return etiqueta;
    }

    public LinkedList<TAdyacencia> getAdyacentes() {
        return adyacentes;
    }

    public TVertice(Comparable unaEtiqueta) {
        this.etiqueta = unaEtiqueta;
        adyacentes = new LinkedList();
        visitado = false;
        datos = null;
    }

    public void setVisitado(boolean valor) {
        this.visitado = valor;
    }

    public boolean getVisitado() {
        return this.visitado;
    }

    public int getTiempoDescubrimiento() {
        return tiempoDescubrimiento;
    }

    public void setTiempoFinalizacion(int tiempo) {
        this.tiempoFinalizacion = tiempo;
    }

    public int getTiempoFinalizacion() {
        return tiempoFinalizacion;
    }

    public void setTiempoDescubrimiento(int tiempo) {
        this.tiempoDescubrimiento = tiempo;
    }

    @Override
    public TAdyacencia buscarAdyacencia(TVertice verticeDestino) {
        if (verticeDestino != null) {
            return buscarAdyacencia(verticeDestino.getEtiqueta());
        }
        return null;
    }

    @Override
    public Double obtenerCostoAdyacencia(TVertice verticeDestino) {
        TAdyacencia ady = buscarAdyacencia(verticeDestino);
        if (ady != null) {
            return ady.getCosto();
        }
        return Double.MAX_VALUE;
    }

    @Override
    public boolean insertarAdyacencia(Double costo, TVertice verticeDestino) {
        if (buscarAdyacencia(verticeDestino) == null) {
            TAdyacencia ady = new TAdyacencia(costo, verticeDestino);
            return adyacentes.add(ady);
        }
        return false;
    }

    @Override
    public boolean eliminarAdyacencia(Comparable nomVerticeDestino) {
        TAdyacencia ady = buscarAdyacencia(nomVerticeDestino);
        if (ady != null) {
            adyacentes.remove(ady);
            return true;
        }
        return false;
    }

    @Override
    public TAdyacencia buscarAdyacencia(Comparable etiquetaDestino) {
        for (TAdyacencia adyacencia : adyacentes) {
            if (adyacencia.getDestino().getEtiqueta().compareTo(etiquetaDestino) == 0) {
                return adyacencia;
            }
        }
        return null;
    }

    public T getDatos() {
        return datos;
    }

    @Override
    public TVertice primerAdyacente() {
        if (this.adyacentes.getFirst() != null) {
            return this.adyacentes.getFirst().getDestino();
        }
        return null;
    }

    @Override
    public TVertice siguienteAdyacente(TVertice w) {
        TAdyacencia adyacente = buscarAdyacencia(w.getEtiqueta());
        int index = adyacentes.indexOf(adyacente);
        if (index + 1 < adyacentes.size()) {
            return adyacentes.get(index + 1).getDestino();
        }
        return null;
    }

    @Override
    public void bpf(Collection<TVertice> visitados) {
       this.visitado = true;
       this.tiempoDescubrimiento = ++tiempo;

       visitados.add(this);

       for (TAdyacencia adyacencia : this.getAdyacentes()) {
           TVertice ady = adyacencia.getDestino();
           if (!ady.getVisitado()) {
               ady.bpf(visitados);
           }
       }
       this.tiempoFinalizacion = ++tiempo;
    }

    @Override
    public TCaminos todosLosCaminos(Comparable etVertDest, TCamino caminoPrevio, TCaminos todosLosCaminos) {
    this.setVisitado(true);
    for (TAdyacencia adyacencia : this.getAdyacentes()) {
        TVertice destino = adyacencia.getDestino();
        if (!destino.getVisitado()) {
            if (destino.getEtiqueta().compareTo(etVertDest) == 0) {
                TCamino copia = caminoPrevio.copiar();
                copia.agregarAdyacencia(adyacencia);
                todosLosCaminos.getCaminos().add(copia);
            } else {
                TCamino copia = caminoPrevio.copiar();
                copia.agregarAdyacencia(adyacencia);
                destino.todosLosCaminos(etVertDest, copia, todosLosCaminos);
            }
        }
    }
        this.setVisitado(false);
        return todosLosCaminos;
    }

    public String toString() {
        return this.etiqueta.toString();
    }



    public boolean tieneCiclo(Collection<TVertice> visitados) {
        setVisitado(true);
        visitados.add(this);
        for (TAdyacencia adyacente : adyacentes) {
            TVertice destino = adyacente.getDestino();
            if (!destino.getVisitado()) {
                if (destino.tieneCiclo(visitados)) {
                    return true;
                }
            }
            else if (visitados.contains(destino)){
                return true;
            }
        }
        return false;
    }

    public void topSort(List<TVertice> total) {
        setVisitado(true);
        for (TAdyacencia adyacente : adyacentes) {
            TVertice destino = adyacente.getDestino();
            if (!destino.getVisitado()) {
               destino.topSort(total);
            }
        }
        total.addFirst(this);
    }


    public void clasificarArcos(
            List<TArista> arcosArbol,
            List<TArista> arcosRetroceso,
            List<TArista> arcosAvance,
            List<TArista> arcosCruzados) {

        this.visitado = true;

        for (TAdyacencia adyacencia : this.getAdyacentes()) {

            TVertice ady = adyacencia.getDestino();
            TArista arco = new TArista(this.getEtiqueta(), ady.getEtiqueta(), 0);

            if (!ady.getVisitado()) {
                arcosArbol.add(arco);
                ady.clasificarArcos(arcosArbol, arcosRetroceso, arcosAvance, arcosCruzados);
            } else {
                if (ady.getTiempoDescubrimiento() < this.getTiempoDescubrimiento()
                        && ady.getTiempoFinalizacion() == 0) {
                    arcosRetroceso.add(arco);
                } else if (this.getTiempoDescubrimiento() < ady.getTiempoDescubrimiento()) {
                    arcosAvance.add(arco);
                } else {
                    arcosCruzados.add(arco);
                }
            }
        }
    }

}