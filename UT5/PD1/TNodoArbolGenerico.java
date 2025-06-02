package org.example.UT5.PD1;

public class TNodoArbolGenerico<T> implements INodoArbolGenerico<T> {

    private Comparable etiqueta;
    private TNodoArbolGenerico<T> primerHijo;
    private TNodoArbolGenerico<T> siguienteHermano;

    @Override
    public Comparable getEtiqueta() {
        return etiqueta;
    }

    @Override
    public void setEtiqueta(Comparable etiqueta) {
        this.etiqueta = etiqueta;
    }

    @Override
    public TNodoArbolGenerico<T> getPrimerHijo() {
        return primerHijo;
    }

    @Override
    public void setPrimerHijo(TNodoArbolGenerico<T> primerHijo) {
        this.primerHijo = primerHijo;
    }

    @Override
    public TNodoArbolGenerico<T> getSiguienteHermano() {
        return siguienteHermano;
    }

    @Override
    public void setSiguienteHermano(TNodoArbolGenerico<T> siguienteHermano) {
        this.siguienteHermano = siguienteHermano;
    }

    public TNodoArbolGenerico(Comparable etiqueta){
       this.etiqueta = etiqueta;
    }

    public TNodoArbolGenerico<T> getUltimoHijo() {
        TNodoArbolGenerico<T> hijoActual = getPrimerHijo();
        if (hijoActual == null) return null;

        while (hijoActual.getSiguienteHermano() != null) {
            hijoActual = hijoActual.getSiguienteHermano();
        }

        return hijoActual;
    }

    //----------------------------------------------------------
    //----------------------------------------------------------

    @Override
    public TNodoArbolGenerico<T> buscar(Comparable etiq) {
        if (etiqueta == etiq){
            return this;
        }

        if (primerHijo == null) {
            return null;
        }

        if (primerHijo.getEtiqueta() == etiq) {
            return primerHijo;
        }

        TNodoArbolGenerico resultado = primerHijo.buscar(etiq);

        if (resultado != null) {
            return resultado;
        }

        TNodoArbolGenerico hermanoActual = primerHijo.getSiguienteHermano();

        while (hermanoActual != null) {
            if (hermanoActual.getEtiqueta() == etiq) {
                return hermanoActual;
            }

            TNodoArbolGenerico res = hermanoActual.buscar(etiq);

            if (res != null) {
                return res;
            }

            hermanoActual = hermanoActual.getSiguienteHermano();
        }

        return null;
    }

    @Override
    public boolean insertar(Comparable etiq, Comparable etiquetaPadre) {
        TNodoArbolGenerico<T> nuevo = new TNodoArbolGenerico<T>(etiq);
        TNodoArbolGenerico<T> nodoPadre = buscar(etiquetaPadre);

        /* Padre encontrado, se procede a insertar como el ultimo de sus hijos*/
        if (nodoPadre != null){
            TNodoArbolGenerico ultimoHijo = nodoPadre.getUltimoHijo();
            if (ultimoHijo != null){
                ultimoHijo.setSiguienteHermano(nuevo);
            }
            else {
                nodoPadre.setPrimerHijo(nuevo);
            }
            return true;
        }

        return false;
    }

    public String listarIndentado(TNodoArbolGenerico<T> nodo, int nivel, StringBuilder mensaje){
        String indentado = "";
        for (int i = 0; i < nivel; i++){
            indentado += "\t";
        }

        TNodoArbolGenerico<T> actual = nodo;
        while (actual != null) {
            mensaje.append(indentado).append(actual.getEtiqueta()).append("\n");
//            System.out.println(indentado + actual.getEtiqueta());
            if (actual.getPrimerHijo() != null) {
               listarIndentado(actual.getPrimerHijo(), nivel+1, mensaje);
            }
            actual = actual.getSiguienteHermano();
        }

        return mensaje.toString();
    }
}
