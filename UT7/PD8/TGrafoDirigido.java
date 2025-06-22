package org.example.UT7.PD8;

import java.util.*;
import java.util.stream.Collectors;

/**
 *
 * @author Ernesto
 */
public class TGrafoDirigido implements IGrafoDirigido {

    private final Map<Comparable, TVertice> vertices; // vertices del grafo.-

    public TGrafoDirigido(Collection<TVertice> vertices, Collection<TArista> aristas) {
        this.vertices = new HashMap<>();
        for (TVertice vertice : vertices) {
            insertarVertice(vertice.getEtiqueta());
        }
        for (TArista arista : aristas) {
            insertarArista(arista);
        }
    }

    /**
     * Metodo encargado de eliminar una arista dada por un origen y destino.
     * En caso de no existir la adyacencia, retorna falso. En caso de que las
     * etiquetas sean inv�lidas, retorna falso.
     *
     * @param nomVerticeOrigen
     * @param nomVerticeDestino
     * @return 
     */
    @Override
    public boolean eliminarArista(Comparable nomVerticeOrigen, Comparable nomVerticeDestino) {
        if ((nomVerticeOrigen != null) && (nomVerticeDestino != null)) {
            TVertice vertOrigen = buscarVertice(nomVerticeOrigen);
            if (vertOrigen != null) {
                return vertOrigen.eliminarAdyacencia(nomVerticeDestino);
            }
        }
        return false;
    }

    /**
     * Metodo encargado de eliminar un vertice en el grafo. En caso de no
     * existir el vertice, retorna falso. En caso de que la etiqueta sea
     * inv�lida, retorna false.
     *
     * @param nombreVertice
     * @return 
     */
  
    @Override
    public boolean eliminarVertice(Comparable nombreVertice) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    /**
     * Metodo encargado de verificar la existencia de una arista. Las
     * etiquetas pasadas por par�metro deben ser v�lidas.
     *
     * @param etiquetaOrigen
     * @param etiquetaDestino
     * @return True si existe la adyacencia, false en caso contrario
     */
    @Override
    public boolean existeArista(Comparable etiquetaOrigen, Comparable etiquetaDestino) {
        TVertice vertOrigen = buscarVertice(etiquetaOrigen);
        TVertice vertDestino = buscarVertice(etiquetaDestino);
        if ((vertOrigen != null) && (vertDestino != null)) {
            return vertOrigen.buscarAdyacencia(vertDestino) != null;
        }
        return false;
    }

    /**
     * Metodo encargado de verificar la existencia de un vertice dentro del
     * grafo.-
     *
     * La etiqueta especificada como par�metro debe ser v�lida.
     *
     * @param unaEtiqueta Etiqueta del v�rtice a buscar.-
     * @return True si existe el vertice con la etiqueta indicada, false en caso
     * contrario
     */
    @Override
    public boolean existeVertice(Comparable unaEtiqueta) {
        return getVertices().get(unaEtiqueta) != null;
    }

    /**
     * Metodo encargado de verificar buscar un vertice dentro del grafo.-
     *
     * La etiqueta especificada como parametro debe ser valida.
     *
     * @param unaEtiqueta Etiqueta del v�rtice a buscar.-
     * @return El vertice encontrado. En caso de no existir, retorna nulo.
     */
    private TVertice buscarVertice(Comparable unaEtiqueta) {
        return getVertices().get(unaEtiqueta);
    }

    /**
     * Metodo encargado de insertar una arista en el grafo (con un cierto
     * costo), dado su vertice origen y destino.- Para que la arista sea
     * valida, se deben cumplir los siguientes casos: 1) Las etiquetas pasadas
     * por parametros son v�lidas.- 2) Los vertices (origen y destino) existen
     * dentro del grafo.- 3) No es posible ingresar una arista ya existente
     * (miso origen y mismo destino, aunque el costo sea diferente).- 4) El
     * costo debe ser mayor que 0.
     *
     * @param arista
     * @return True si se pudo insertar la adyacencia, false en caso contrario
     */
    @Override
    public boolean insertarArista(TArista arista) {
        if ((arista.getEtiquetaOrigen()!= null) && (arista.getEtiquetaDestino() != null)) {
            TVertice vertOrigen = buscarVertice(arista.getEtiquetaOrigen());
            TVertice vertDestino = buscarVertice(arista.getEtiquetaDestino());
            if ((vertOrigen != null) && (vertDestino != null)) {
                return vertOrigen.insertarAdyacencia(arista.getCosto(), vertDestino);
            }
        }
        return false;
    }
 
    /**
     * Metodo encargado de insertar un vertice en el grafo.
     *
     * No pueden ingresarse v�rtices con la misma etiqueta. La etiqueta
     * especificada como par�metro debe ser v�lida.
     *
     * @param unaEtiqueta Etiqueta del v�rtice a ingresar.
     * @return True si se pudo insertar el vertice, false en caso contrario
     */
    @Override
    public boolean insertarVertice(Comparable unaEtiqueta) {
        if ((unaEtiqueta != null) && (!existeVertice(unaEtiqueta))) {
            TVertice vert = new TVertice(unaEtiqueta);
            getVertices().put(unaEtiqueta, vert);
            return getVertices().containsKey(unaEtiqueta);
        }
        return false;
    }
    @Override
 public boolean insertarVertice(TVertice vertice) {
     Comparable unaEtiqueta = vertice.getEtiqueta();
     if (!existeVertice(unaEtiqueta)) {
            getVertices().put(unaEtiqueta, vertice);
            return getVertices().containsKey(unaEtiqueta);
        }
        return false;
    }

    public Object[] getEtiquetasOrdenado() {
        TreeMap<Comparable, TVertice> mapOrdenado = new TreeMap<>(this.getVertices());
        return mapOrdenado.keySet().toArray();
    }
    
 

    /**
     * @return the vertices
     */
    public Map<Comparable, TVertice> getVertices() {
        return vertices;
    }

    @Override
    public Comparable centroDelGrafo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Double[][] floyd() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Comparable obtenerExcentricidad(Comparable etiquetaVertice) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean[][] warshall() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection<TVertice> bpf(Comparable origen) {
        Set<Comparable> visitados= new HashSet<>();
        bpfRecursivo(origen, visitados);
        return visitados.stream().map(v -> (TVertice) buscarVertice(v)).collect(Collectors.toList());
    }

    private void bpfRecursivo(Comparable actual, Set<Comparable> visitados) {
        visitados.add(actual);
        IVertice verticeActual = vertices.get(actual);
        if (verticeActual!= null) {
            for (Object o: verticeActual.getAdyacentes()) {
                TAdyacencia adyacente = (TAdyacencia) o;
                Comparable destino= adyacente.getDestino().getEtiqueta();
                if (!visitados.contains(destino)) {
                    bpfRecursivo(destino, visitados);
                }
            }
        }
    }

    @Override
    public Collection<TVertice> bpf(TVertice vertice) {
        Set<TVertice> visitados= new HashSet<>();
        List<TVertice> resultado= new ArrayList<>();
        bpf(vertice, visitados,resultado, 1);
        return resultado;
    }

    private void bpf(TVertice vertice, Set<TVertice> visitados, List<TVertice> resultado, int tiempo) {
        visitados.add(vertice);
        resultado.add(vertice);

        for (Object o:vertice.getAdyacentes()) {
            TAdyacencia adyacencia= (TAdyacencia) o;
            TVertice adyacente= (TVertice) adyacencia.getDestino();
            if (!visitados.contains(adyacente)) {
                vertice.setTiempoDescubrimiento(tiempo);
                bpf(adyacente, visitados, resultado, tiempo+1);
            }

        }
    }

    @Override
    public Collection<TVertice> bpf() {
        List<TVertice> visitados = new LinkedList<>();
        int tiempo = 0;

        for (TVertice vertice : this.vertices.values()) {
            vertice.setVisitado(false);
        }

        for (TVertice vertice : this.vertices.values()) {
            if (!vertice.getVisitado()) {
                vertice.bpf(visitados);
            }
        }
        return visitados;
    }

    @Override
    public void desvisitarVertices() {
        for (TVertice v : vertices.values()) {
            v.setVisitado(false);
        }
    }

    @Override
    public TCaminos todosLosCaminos(Comparable etiquetaOrigen, Comparable etiquetaDestino) {
        TCaminos todosLosCaminos = new TCaminos();
        TVertice v = buscarVertice(etiquetaOrigen);

        if(v != null){
            TCamino caminoPrevio = new TCamino(v);
            v.todosLosCaminos(etiquetaDestino, caminoPrevio, todosLosCaminos);
            return todosLosCaminos;
        }
        return null;
    }

    public boolean tieneCiclo() {
        desvisitarVertices();

        for (TVertice vert : this.vertices.values()) {
            if (!vert.getVisitado()) {
                if (vert.tieneCiclo(new ArrayList<>())) {
                    return true;
                }
            }
        }
        return false;
    }

    public List<TVertice> topSort() {
        desvisitarVertices();
        List<TVertice> total = new LinkedList<>();

        for (TVertice vert : this.vertices.values()) {
            if (!vert.getVisitado()) {
                vert.topSort(total);
            }
        }

        return total;
    }

    public boolean esConexo() {
        TVertice vert = vertices.get(0);
        List<TVertice> recorridoDesdeVert = (List<TVertice>) bpf(vert);

        if (recorridoDesdeVert.size() != vertices.size()) {
            return false;
        }

        TGrafoDirigido grafoFlaco = voltearGrafo();
        recorridoDesdeVert = (List<TVertice>) grafoFlaco.bpf(vert);

        if (recorridoDesdeVert.size() != vertices.size()) {
            return false;
        }

        return true;
    }

    private TGrafoDirigido voltearGrafo() {
        List<TVertice> nuevosVert = new ArrayList<>();

        for (TVertice vert : this.vertices.values()) {
            nuevosVert.add(new TVertice(vert.getEtiqueta()));
        }

        List<TArista> aristasInvertidas = new ArrayList<>();

        for (TVertice vert : this.vertices.values()) {
            for (Object ady : vert.getAdyacentes()) {
                Comparable origen = ((TAdyacencia)ady).getDestino().getEtiqueta();
                Comparable destino = vert.getEtiqueta();
                double costo = ((TAdyacencia)ady).getCosto();

                aristasInvertidas.add(new TArista(origen, destino, costo));
            }
        }

        return new TGrafoDirigido(nuevosVert, aristasInvertidas);
    }


    public List<List<TVertice>> obtenerCompFuertes() {
        desvisitarVertices();
        Stack<TVertice> pila = new Stack<>();

        for (TVertice v : vertices.values()) {
            if (!v.getVisitado()) {
                bpfPost(v, pila);
            }
        }

        TGrafoDirigido volteado = this.voltearGrafo();

        volteado.desvisitarVertices();
        List<List<TVertice>> componentes = new ArrayList<>();

        while (!pila.isEmpty()) {
            TVertice vOriginal = pila.pop();
            TVertice vTranspuesto = volteado.buscarVertice(vOriginal.getEtiqueta());
            if (!vTranspuesto.getVisitado()) {
                List<TVertice> componente = new ArrayList<>();
                bpfComp(vTranspuesto, componente);
                componentes.add(componente);
            }
        }

        return componentes;
    }


    // BUSQUEDA EN PROFUNDIDAD PERO CON POSTORDEN
    private void bpfPost(TVertice v, Stack<TVertice> pila) {
        v.setVisitado(true);
        for (Object ady : v.getAdyacentes()) {
            TVertice destino = ((TAdyacencia)ady).getDestino();
            if (!destino.getVisitado()) {
                bpfPost(destino, pila);
            }
        }
        pila.push(v);
    }


    // RECOLECTA LOS COMPONENTES HA HA HA
    private void bpfComp(TVertice v, List<TVertice> componente) {
        v.setVisitado(true);
        componente.add(v);
        for (Object ady : v.getAdyacentes()) {
            TVertice destino = ((TAdyacencia)ady).getDestino();
            if (!destino.getVisitado()) {
                bpfComp(destino, componente);
            }
        }
    }


    public void clasificarArcos(
            String etiquetaOrigen,
            List<TArista> arcosArbol,
            List<TArista> arcosRetroceso,
            List<TArista> arcosAvance,
            List<TArista> arcosCruzados) {

        for (TVertice v : this.vertices.values()) {
            v.setVisitado(false);
        }

        TVertice origen = this.vertices.get(etiquetaOrigen);
        if (origen != null) {
            origen.clasificarArcos(arcosArbol, arcosRetroceso, arcosAvance, arcosCruzados);
        }
    }

}
