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
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        int size = 50000; // Tamaño del arreglo

        int[] arrGnome = generarArregloAleatorio(size);
        int[] arrBitonic = generarArregloAleatorio(size);
        int[] arrComb = generarArregloAleatorio(size);
        int[] arrHeap = generarArregloAleatorio(size);
        int[] arrPigeonhole = generarArregloAleatorio(size);
        int[] arrTree = generarArregloAleatorio(size);
        int[] arrTim = generarArregloAleatorio(size);

        // Gnome Sort
        long startTimeGnome = System.currentTimeMillis();
        GnomeSort.gnomeSort(arrGnome, arrGnome.length);
        long endTimeGnome = System.currentTimeMillis();
        dataset.addValue(endTimeGnome - startTimeGnome, "Gnome Sort", "5000");

        // Bitonic Sort
        BitonicSort bitonicSort = new BitonicSort();
        long startTimeBitonic = System.currentTimeMillis();
        bitonicSort.sort(arrBitonic, arrBitonic.length, 1); // Orden ascendente
        long endTimeBitonic = System.currentTimeMillis();
        dataset.addValue(endTimeBitonic - startTimeBitonic, "Bitonic Sort", "5000");

        // Comb Sort
        CombSort combSort = new CombSort();
        long startTimeComb = System.currentTimeMillis();
        combSort.sort(arrComb);
        long endTimeComb = System.currentTimeMillis();
        dataset.addValue(endTimeComb - startTimeComb, "Comb Sort", "5000");

        // Heap Sort
        HeapSort heapSort = new HeapSort();
        long startTimeHeap = System.currentTimeMillis();
        heapSort.sort(arrHeap);
        long endTimeHeap = System.currentTimeMillis();
        dataset.addValue(endTimeHeap - startTimeHeap, "Heap Sort", "5000");

        // Pigeonhole Sort
        PigeonholeSort pigeonholeSort = new PigeonholeSort();
        long startTimePigeonhole = System.currentTimeMillis();
        pigeonholeSort.pigeonhole_sort(arrPigeonhole, arrPigeonhole.length);
        long endTimePigeonhole = System.currentTimeMillis();
        dataset.addValue(endTimePigeonhole - startTimePigeonhole, "Pigeonhole Sort", "5000");

        // Tree Sort
        TreeSort treeSort = new TreeSort();
        long startTimeTree = System.currentTimeMillis();
        treeSort.treeins(arrTree);
        long endTimeTree = System.currentTimeMillis();
        dataset.addValue(endTimeTree - startTimeTree, "Tree Sort", "5000");

        // Tim Sort
        long startTimeTim = System.currentTimeMillis();
        TimSort.timSort(arrTim, arrTim.length);
        long endTimeTim = System.currentTimeMillis();
        dataset.addValue(endTimeTim - startTimeTim, "Tim Sort", "5000");

        // Crear el gráfico de barras
        JFreeChart barChart = ChartFactory.createBarChart(
                "Tiempo de ejecución de Algoritmos de Ordenamiento (Tamaño del arreglo: 5000)",
                "Algoritmo de Ordenamiento",
                "Tiempo (ms)",
                dataset);

        // Mostrar el gráfico
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Gráfico de Tiempo de Ejecución");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            ChartPanel chartPanel = new ChartPanel(barChart);
            frame.add(chartPanel);
            frame.pack();
            frame.setVisible(true);
        });
    }

    // Método para generar un arreglo aleatorio de tamaño 'size'
    private static int[] generarArregloAleatorio(int size) {
        int[] arr = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(20000001) - 10000000; // Genera números aleatorios de 8 dígitos
        }
        return arr;
    }
}
