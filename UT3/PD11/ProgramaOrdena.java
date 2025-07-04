package org.example;

public class ProgramaOrdena {
    public static void main(String[] args) {

        int[] original = {4, 71, 3, 6, 12, 8, 35, 11, 22, 17};
        Lista<Integer> lista = new Lista<>();
        for (int c : original) {
            lista.insertar(new Nodo<>(c, c));
        }

        System.out.println("Antes: " + lista.imprimir(","));

        Lista<Integer> ordenada = lista.ordenaParesImpares();

        System.out.println("Sorted: " + ordenada.imprimir(","));
    }
}
