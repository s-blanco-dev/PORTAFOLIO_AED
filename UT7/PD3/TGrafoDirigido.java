package org.example.UT7.PD3;

import java.util.*;
import java.util.stream.Collectors;

public class TGrafoDirigido implements IGrafoDirigido {

    private Map<Comparable, TVertice> vertices; // vertices del grafo.-

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
     * Metodo encargado de eliminar una arista dada por un origen y destino. En
     * caso de no existir la adyacencia, retorna falso. En caso de que las
     * etiquetas sean invalidas, retorna falso.
     *
     */
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
     * Metodo encargado de verificar la existencia de una arista. Las etiquetas
     * pasadas por par�metro deben ser v�lidas.
     *
     * @return True si existe la adyacencia, false en caso contrario
     */
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
     * @param unaEtiqueta Etiqueta del vertice a buscar.-
     * @return True si existe el vertice con la etiqueta indicada, false en caso
     * contrario
     */
    public boolean existeVertice(Comparable unaEtiqueta) {
        return getVertices().get(unaEtiqueta) != null;
    }

    /**
     * Metodo encargado de verificar buscar un vertice dentro del grafo.-
     *
     * La etiqueta especificada como parametro debe ser valida.
     *
     * @param unaEtiqueta Etiqueta del vertice a buscar.-
     * @return El vertice encontrado. En caso de no existir, retorna nulo.
     */
    private TVertice buscarVertice(Comparable unaEtiqueta) {
        return getVertices().get(unaEtiqueta);
    }

    /**
     * Metodo encargado de insertar una arista en el grafo (con un cierto
     * costo), dado su vertice origen y destino.- Para que la arista sea valida,
     * se deben cumplir los siguientes casos: 1) Las etiquetas pasadas por
     * parametros son v�lidas.- 2) Los vertices (origen y destino) existen
     * dentro del grafo.- 3) No es posible ingresar una arista ya existente
     * (miso origen y mismo destino, aunque el costo sea diferente).- 4) El
     * costo debe ser mayor que 0.
     *
     * @return True si se pudo insertar la adyacencia, false en caso contrario
     */
    public boolean insertarArista(TArista arista) {
        if ((arista.getEtiquetaOrigen() != null) && (arista.getEtiquetaDestino() != null)) {
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
     * No pueden ingresarse vertices con la misma etiqueta. La etiqueta
     * especificada como par�metro debe ser v�lida.
     *
     * @param unaEtiqueta Etiqueta del vertice a ingresar.
     * @return True si se pudo insertar el vertice, false en caso contrario
     */
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
        if ((unaEtiqueta != null) && (!existeVertice(unaEtiqueta))) {
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
    public Double[][] floyd() {
        // Obtener las etiquetas de los vértices ordenadas de forma segura
        List<Comparable> etiquetas = new ArrayList<>(new TreeMap<>(this.getVertices()).keySet());
        int n = etiquetas.size();
        Double[][] dist = UtilGrafos.obtenerMatrizCostos(this.vertices);

        // Algoritmo de Floyd-Warshall
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dist[k][j] != Double.MAX_VALUE &&
                            dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        return dist;
    }


    @Override
    public Comparable obtenerExcentricidad(Comparable etiquetaVertice) {
        Double[][] distancias = this.floyd();

        List<Comparable> etiquetas = new ArrayList<>(new TreeMap<>(this.getVertices()).keySet());
        int indiceVertice = etiquetas.indexOf(etiquetaVertice);

        double excentricidad = 0.0;
        for (int j = 0; j < distancias[indiceVertice].length; j++) {
            if (distancias[indiceVertice][j] > excentricidad && distancias[indiceVertice][j] != Double.MAX_VALUE) {
                excentricidad = distancias[indiceVertice][j];
            }
        }

        if (excentricidad == 0.0 && distancias[indiceVertice].length > 1) {
            return Double.MAX_VALUE;
        }

        return excentricidad;
    }

    @Override
    public Comparable centroDelGrafo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean[][] warshall() {
        List<Comparable> etiquetas = new ArrayList<>(new TreeMap<>(this.getVertices()).keySet());
        int n = etiquetas.size();

        Double[][] distancias = floyd();
        boolean[][] alcanzabilidad = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                alcanzabilidad[i][j] = (distancias[i][j] < Double.MAX_VALUE);
            }
        }

        return alcanzabilidad;
    }


    @Override
    public boolean eliminarVertice(Comparable nombreVertice) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean existeCamino(Comparable origen, Comparable destino) {
        boolean[][] llega = this.warshall();

        List<Comparable> etiquetas = new ArrayList<>(new TreeMap<>(this.getVertices()).keySet());
        int indiceOrigen = etiquetas.indexOf(origen);
        int indiceDestino = etiquetas.indexOf(destino);

        if (indiceOrigen == -1 || indiceDestino == -1) {
            return false;
        }

        return llega[indiceOrigen][indiceDestino];
    }

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

    public List<Comparable> obtenerCaminos(Comparable origen, Comparable destino) {
        List<Comparable> caminos= new ArrayList<>();
        Set<Comparable> visitados=new HashSet<>();
        backtrackingCaminos(origen, destino, visitados, caminos);
        return caminos;
    }

    private void backtrackingCaminos(Comparable actual, Comparable destino, Set<Comparable> visitados, List<Comparable> camino) {
        visitados.add(actual);
        camino.add(actual);

        if (actual.equals(destino)) {
            System.out.println(camino);
        } else {
            IVertice verticeActual= vertices.get(actual);
            if (verticeActual!= null) {
                for (Object o: verticeActual.getAdyacentes()) {
                    TAdyacencia adyacente= (TAdyacencia) o;
                    Comparable proximo= adyacente.getDestino().getEtiqueta();
                    if (!visitados.contains(proximo)) {
                        backtrackingCaminos(proximo,destino,visitados,camino);
                    }
                }
            }
        }
        camino.remove(camino.size() - 1);
        visitados.remove(actual);
    }

}
