package org.workerbee.sortingalgorithms;

import java.util.Random;

public class HeapSort {

    // Método para ordenar el arreglo utilizando Heap Sort
    public void sort(int arr[]) {
        int N = arr.length;

        // Construir el montículo (reorganizar el arreglo)
        for (int i = N / 2 - 1; i >= 0; i--)
            heapify(arr, N, i);

        // Extraer uno por uno un elemento del montículo
        for (int i = N - 1; i > 0; i--) {
            // Mover la raíz actual al final
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // Llamar a heapify en el montículo reducido
            heapify(arr, i, 0);
        }
    }

    // Método para reorganizar un subárbol con raíz en el índice i
    void heapify(int arr[], int N, int i) {
        int largest = i; // Inicializar 'largest' como raíz
        int l = 2 * i + 1; // Izquierda = 2*i + 1
        int r = 2 * i + 2; // Derecha = 2*i + 2

        // Si el hijo izquierdo es mayor que la raíz
        if (l < N && arr[l] > arr[largest])
            largest = l;

        // Si el hijo derecho es mayor que el 'largest' hasta ahora
        if (r < N && arr[r] > arr[largest])
            largest = r;

        // Si 'largest' no es la raíz
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Recursivamente reorganizar el subárbol afectado
            heapify(arr, N, largest);
        }
    }
}
