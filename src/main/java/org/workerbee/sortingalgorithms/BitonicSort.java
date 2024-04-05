package org.workerbee.sortingalgorithms;

import java.util.Random;

public class BitonicSort {

    /* El parámetro dir indica la dirección de clasificación,
       ASCENDENTE o DESCENDENTE; si (a[i] > a[j]) concuerda
       con la dirección, entonces a[i] y a[j] se intercambian. */
    void compAndSwap(int a[], int i, int j, int dir) {
        if ((a[i] > a[j] && dir == 1) || (a[i] < a[j] && dir == 0)) {
            // Intercambiando elementos
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }
    }

    /* Ordena recursivamente una secuencia bitónica en orden ascendente,
       si dir = 1, y en orden descendente en caso contrario
       (significa dir = 0). La secuencia a ordenar comienza en
       la posición de índice baja, el parámetro cnt es el número
       de elementos a ordenar.*/
    void bitonicMerge(int a[], int low, int cnt, int dir) {
        if (cnt > 1) {
            int k = cnt / 2;
            for (int i = low; i < low + k; i++)
                compAndSwap(a, i, i + k, dir);
            bitonicMerge(a, low, k, dir);
            bitonicMerge(a, low + k, k, dir);
        }
    }

    /* Esta función primero produce una secuencia bitónica al
       ordenar recursivamente sus dos mitades en órdenes de clasificación opuestos,
       y luego llama a bitonicMerge para ponerlos en
       el mismo orden */
    void bitonicSort(int a[], int low, int cnt, int dir) {
        if (cnt > 1) {
            int k = cnt / 2;

            // ordena en orden ascendente ya que dir aquí es 1
            bitonicSort(a, low, k, 1);

            // ordena en orden descendente ya que dir aquí es 0
            bitonicSort(a, low + k, k, 0);

            // Mezclará toda la secuencia en orden ascendente
            // ya que dir=1.
            bitonicMerge(a, low, cnt, dir);
        }
    }

    /*Llamador de bitonicSort para ordenar todo el array
      de longitud N en orden ASCENDENTE */
    public void sort(int a[], int N, int up) {
        bitonicSort(a, 0, N, up);
    }

    // Método para generar un arreglo aleatorio de tamaño 'size'
    public static int[] generarArregloAleatorio(int size) {
        int[] arr = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(90000000) + 10000000; // Genera números aleatorios de 8 dígitos
        }
        return arr;
    }
}
