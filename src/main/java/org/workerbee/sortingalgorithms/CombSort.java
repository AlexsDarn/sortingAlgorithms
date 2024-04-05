package org.workerbee.sortingalgorithms;

import java.util.Random;

public class CombSort {

    // Método para obtener el siguiente espacio entre elementos
    private int getNextGap(int gap) {
        // Reducir el espacio por un factor de reducción
        gap = (gap * 10) / 13;
        if (gap < 1)
            return 1;
        return gap;
    }

    // Función para ordenar arr[] usando Comb Sort
    public void sort(int arr[]) {
        int n = arr.length;

        // Inicializar el espacio (gap)
        int gap = n;

        // Inicializar swapped como true para asegurarse de que el bucle se ejecute
        boolean swapped = true;

        // Seguir ejecutando mientras el espacio (gap) sea mayor que 1 o la última iteración causó un intercambio
        while (gap != 1 || swapped) {
            // Encontrar el siguiente espacio (gap)
            gap = getNextGap(gap);

            // Inicializar swapped como false para poder verificar si se realizó un intercambio o no
            swapped = false;

            // Comparar todos los elementos con el espacio (gap) actual
            for (int i = 0; i < n - gap; i++) {
                if (arr[i] > arr[i + gap]) {
                    // Intercambiar arr[i] y arr[i+gap]
                    int temp = arr[i];
                    arr[i] = arr[i + gap];
                    arr[i + gap] = temp;

                    // Establecer swapped como true
                    swapped = true;
                }
            }
        }
    }
}
