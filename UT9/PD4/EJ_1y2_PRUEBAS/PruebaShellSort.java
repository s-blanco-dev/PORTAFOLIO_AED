package org.example.UT9.PD4;

import java.util.Arrays;
import java.util.Random;

public class PruebaShellSort {

    public static void main(String[] args) {
        int n = 1000;
        int[] original = generarArregloAleatorio(n);

        probar("Ciura", original, generarCiura());
        probar("Tokuda", original, generarTokuda(n));
        probar("Sedgewick", original, generarSedgewick(n));
        // Sedgewick es mi favorito :)
    }

    private static void probar(String nombre, int[] original, int[] incrementos) {
        int[] copia = Arrays.copyOf(original, original.length);
        // Mido tiempo en milisegundos, pasamos de lo teórico a lo experimental
        long start = System.nanoTime();
        shellSort(copia, incrementos);
        long end = System.nanoTime();
        System.out.printf("%-18s: %.3f ms%n", nombre, (end - start) / 1e6); // coso mágico
    }

    private static void shellSort(int[] arr, int[] gaps) {
        for (int gap : gaps) {
            for (int i = gap; i < arr.length; i++) {
                int temp = arr[i];
                int j = i;
                while (j >= gap && arr[j - gap] > temp) {
                    arr[j] = arr[j - gap];
                    j -= gap;
                }
                arr[j] = temp;
            }
        }
    }

    private static int[] generarArregloAleatorio(int n) {
        Random rnd = new Random(48);
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = rnd.nextInt(10_000);
        return arr;
    }

    private static int[] generarCiura() {
        return new int[]{701, 301, 132, 57, 23, 10, 4, 1};
    }

    private static int[] generarTokuda(int n) {
        int[] gaps = new int[40];
        int k = 0;
        for (int i = 1;; i++) {
            int h = (int) Math.ceil((Math.pow(9.0 / 4, i) - 1) / (9.0 / 4 - 1));
            if (h >= n) break;
            gaps[k++] = h;
        }
        return invertir(gaps, k);
    }

    /**
     * Una joyita de secuencia
     * @param n: largo del array
     * @return secuencia de largo suficiente
     */
    private static int[] generarSedgewick(int n) {
        int[] gaps = new int[40];
        int k = 0;
        int i = 0;
        while (true) {
            int g1 = (int) (Math.pow(4, i + 1) + 3 * Math.pow(2, i) + 1);
            if (g1 >= n) break;
            gaps[k++] = g1;
            i++;
        }
        return invertir(gaps, k);
    }

    private static int[] generarGamma(int n, double gamma) {
        int[] gaps = new int[40];
        int k = 0;
        int g = 1;
        while (g < n) {
            gaps[k++] = g;
            g = (int) Math.floor(g * gamma);
        }
        return invertir(gaps, k);
    }

    private static int[] invertir(int[] original, int length) {
        int[] invertido = new int[length];
        for (int i = 0; i < length; i++) {
            invertido[i] = original[length - i - 1];
        }
        return invertido;
    }
}

