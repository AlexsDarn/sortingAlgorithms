package org.workerbee;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
import org.workerbee.sortingalgorithms.BitonicSort;
import org.workerbee.sortingalgorithms.CombSort;
import org.workerbee.sortingalgorithms.GnomeSort;
import org.workerbee.sortingalgorithms.HeapSort;
import org.workerbee.sortingalgorithms.PigeonholeSort;
import org.workerbee.sortingalgorithms.TreeSort;
import org.workerbee.sortingalgorithms.TimSort;

import javax.swing.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        // Crear un mapa para almacenar los tiempos de ejecución de cada algoritmo
        Map<String, Long> executionTimes = new HashMap<>();

        int size = 500; // Tamaño del arreglo

        // Agregar tiempos de ejecución para cada algoritmo
        executionTimes.put("Gnome Sort", getExecutionTime(() -> {
            GnomeSort.gnomeSort(generateRandomArray(size), size);
        }));
        executionTimes.put("Bitonic Sort", getExecutionTime(() -> {
            BitonicSort bitonicSort = new BitonicSort();
            bitonicSort.sort(generateRandomArray(size), size, 1);
        }));
        executionTimes.put("Comb Sort", getExecutionTime(() -> {
            CombSort combSort = new CombSort();
            combSort.sort(generateRandomArray(size));
        }));
        executionTimes.put("Heap Sort", getExecutionTime(() -> {
            HeapSort heapSort = new HeapSort();
            heapSort.sort(generateRandomArray(size));
        }));
        executionTimes.put("Pigeonhole Sort", getExecutionTime(() -> {
            PigeonholeSort pigeonholeSort = new PigeonholeSort();
            pigeonholeSort.pigeonhole_sort(generateRandomArray(size), size);
        }));
        executionTimes.put("Tree Sort", getExecutionTime(() -> {
            TreeSort treeSort = new TreeSort();
            treeSort.treeins(generateRandomArray(size));
        }));
        executionTimes.put("Tim Sort", getExecutionTime(() -> {
            TimSort.timSort(generateRandomArray(size), size);
        }));

        // Ordenar el mapa por los valores (tiempos de ejecución)
        Map<String, Long> sortedExecutionTimes = executionTimes.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue, LinkedHashMap::new));

        // Crear el conjunto de datos para la gráfica
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        sortedExecutionTimes.forEach((algorithm, time) -> dataset.addValue(time, "Tiempo (ms)", algorithm));

        // Crear el gráfico de barras
        JFreeChart barChart = ChartFactory.createBarChart(
                "Tiempo de ejecución de Algoritmos de Ordenamiento (Tamaño del arreglo: 5000)",
                "Algoritmo de Ordenamiento",
                "Tiempo (ms)",
                dataset);

        // Mostrar el gráfico
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Gráfico de Tiempo de Ejecución");
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            ChartPanel chartPanel = new ChartPanel(barChart);
            frame.add(chartPanel);
            frame.pack();
            frame.setVisible(true);
        });
    }

    // Método para generar un arreglo aleatorio de tamaño 'size'
    private static int[] generateRandomArray(int size) {
        int[] arr = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(20000001) - 10000000; // Genera números aleatorios de 8 dígitos
        }
        return arr;
    }

    // Método para obtener el tiempo de ejecución de una tarea
    private static long getExecutionTime(Runnable task) {
        long startTime = System.currentTimeMillis();
        task.run();
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }
}
