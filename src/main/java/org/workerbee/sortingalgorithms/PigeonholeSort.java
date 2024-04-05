package org.workerbee.sortingalgorithms;

import java.util.Arrays;

public class PigeonholeSort {

	public void pigeonhole_sort(int arr[], int n) {
		int min = arr[0];
		int max = arr[0];
		int rango, i, j, indice;

		// Encontrar el mínimo y máximo en el arreglo
		for (int a = 0; a < n; a++) {
			if (arr[a] > max)
				max = arr[a];
			if (arr[a] < min)
				min = arr[a];
		}

		rango = max - min + 1;
		int[] agujero = new int[rango];
		Arrays.fill(agujero, 0);

		// Llenar el arreglo 'agujero' con las frecuencias de cada elemento
		for (i = 0; i < n; i++)
			agujero[arr[i] - min]++;

		// Reordenar el arreglo original basado en las frecuencias
		indice = 0;
		for (j = 0; j < rango; j++)
			while (agujero[j]-- > 0)
				arr[indice++] = j + min;
	}
}
