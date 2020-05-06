package com.cj.algorithm.sort;

/**
 * @author caijun
 * @Classname Code_01_InsertionSort
 * @Description
 * @Version 1.0
 * @create 2020-05-06 15:10
 */


public class Code_01_InsertionSort {
    public static void insertionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) {
                swap(arr, j, j + 1);
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}
