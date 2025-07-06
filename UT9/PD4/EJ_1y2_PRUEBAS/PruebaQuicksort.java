package org.example.UT9.PD4;

import java.util.Arrays;
import java.util.Random;

public class PruebaQuicksort {

    public static void main(String[] args) {
        final int N = 100_000;
        int[] arrRandom = generarArrayAleatorio(N);

        probar("Pivote Fijo", arrRandom, PruebaQuicksort::quicksortPivoteFijo);
        probar("Pivote Aleatorio", arrRandom, PruebaQuicksort::quicksortPivoteAleatorio);
        probar("Mediana de Tres", arrRandom, PruebaQuicksort::quicksortMedianaTres);

    }

    static void probar(String nombre, int[] original, ConsumerQS qs) {
        int[] copia = Arrays.copyOf(original, original.length);
        long inicio = System.nanoTime();
        qs.sort(copia, 0, copia.length - 1);
        long fin = System.nanoTime();
        System.out.printf("%-30s Tiempo: %.2f ms%n", nombre, (fin - inicio) / 1e6);
    }

    static void quicksortPivoteFijo(int[] a, int lo, int hi) {
        if (lo >= hi) return;
        int p = partitionFijo(a, lo, hi);
        quicksortPivoteFijo(a, lo, p - 1);
        quicksortPivoteFijo(a, p + 1, hi);
    }

    static void quicksortPivoteAleatorio(int[] a, int lo, int hi) {
        if (lo >= hi) return;
        int p = partitionAleatorio(a, lo, hi);
        quicksortPivoteAleatorio(a, lo, p - 1);
        quicksortPivoteAleatorio(a, p + 1, hi);
    }

    static void quicksortMedianaTres(int[] a, int lo, int hi) {
        if (lo >= hi) return;
        int p = partitionMedianaTres(a, lo, hi);
        quicksortMedianaTres(a, lo, p - 1);
        quicksortMedianaTres(a, p + 1, hi);
    }

    // Particiones

    static int partitionFijo(int[] a, int lo, int hi) {
        int pivot = a[lo];
        int i = lo + 1, j = hi;
        while (i <= j) {
            while (i <= hi && a[i] <= pivot) i++;
            while (a[j] > pivot) j--;
            if (i < j) swap(a, i, j);
        }
        swap(a, lo, j);
        return j;
    }

    static int partitionAleatorio(int[] a, int lo, int hi) {
        int r = new Random().nextInt(hi - lo + 1) + lo;
        swap(a, lo, r);
        return partitionFijo(a, lo, hi);
    }

    static int partitionMedianaTres(int[] a, int lo, int hi) {
        int mid = (lo + hi) / 2;
        int pivotIndex = medianaIndice(a, lo, mid, hi);
        swap(a, lo, pivotIndex);
        return partitionFijo(a, lo, hi);
    }

    static int medianaIndice(int[] a, int i, int j, int k) {
        int ai = a[i], aj = a[j], ak = a[k];
        if ((ai > aj) == (ai < ak)) return i;
        else if ((aj > ai) == (aj < ak)) return j;
        else return k;
    }

    static void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    // Generadores de arrays

    static int[] generarArrayAleatorio(int n) {
        Random r = new Random();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = r.nextInt(n);
        return a;
    }

    interface ConsumerQS {
        void sort(int[] arr, int lo, int hi);
    }
}

