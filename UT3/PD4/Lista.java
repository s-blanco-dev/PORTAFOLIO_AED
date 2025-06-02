package uy.edu.ucu.aed.tdas;

public class Lista<T> implements ILista<T> {

    private Nodo<T> primero;
    private int cantidad;

    public Lista() {
        primero = null;
    }

    public Nodo<T> getPrimero() {
        return primero;
    }

    @Override
    public void insertar(T dato, Comparable clave) {
        // TODO Auto-generated method stub
        Nodo<T> actual = primero; 
        Nodo<T> nuevoproducto = new Nodo<>(clave, dato);
        if (primero == null){
            System.out.println("Insertando primer producto: " + dato);//Agregue una declaracion
            primero=nuevoproducto; //solo cambié el orden
            cantidad++;
        }
        else{
            while (actual.getSiguiente() != null) {
                actual = actual.getSiguiente();
            }

            actual.setSiguiente(nuevoproducto);
            System.out.println("Insertando producto: " + dato); //agregué una declaracion
            cantidad++;
        }

    }

    @Override
    public T buscar(Comparable clave) {
        Nodo<T> actual = primero;
        while (actual != null) {
            if (actual.getEtiqueta().equals(clave)) {
                return actual.getDato();
            }
            actual = actual.getSiguiente();
        }
        return null;
    }
    
    @Override
    public boolean eliminar(Comparable clave) {
        if (this.primero == null) {
            return false;
        }
        cantidad--;
        if (this.primero.getDato().equals(clave)) {
            this.primero = null;
            return true;
        }

        Nodo<T> actual = this.primero;

        while (actual.getSiguiente() != null) {
            actual = actual.getSiguiente();
            if (clave.equals(actual.getSiguiente().getDato())) {
                actual.setSiguiente(actual.getSiguiente().getSiguiente());
                return true;
            }
        }
        cantidad--;

        return false;
    }

    @Override
    public String imprimir() {
        if (this.primero == null) {
            return "Lista vacia";
        }
        StringBuilder sb = new StringBuilder();
        Nodo<T> nodo = primero;
        while (nodo != null) {
            sb.append(nodo.getEtiqueta()).append(": ").append(nodo.getDato()).append("\n");  // Acumula todos los productos
            nodo = nodo.getSiguiente();
        }
        return sb.toString();
    }

    @Override
    public String imprimir(String separador) {
        StringBuilder claves = new StringBuilder();
        Nodo<T> nodo = primero;
        while (nodo != null) {
            claves.append(separador);
            claves.append(nodo.getDato());
            nodo = nodo.getSiguiente();
        } return ("INFORMACION"+ claves.toString());
    }

    @Override
    public int cantElementos() {
        return cantidad;
    }

    @Override
    public boolean esVacia() {
        return primero == null;
    }


}