package org.workerbee.sortingalgorithms;

import java.util.Arrays;

public class GnomeSort {

	public static void gnomeSort(int arr[], int n) {
		int index = 0;

		while (index < n) {
			if (index == 0)
				index++;
			if (arr[index] >= arr[index - 1])
				index++;
			else {
				// Intercambiar elementos si no están en orden
				int temp = arr[index];
				arr[index] = arr[index - 1];
				arr[index - 1] = temp;
				index--;
			}
		}
	}
}