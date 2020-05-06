package com.cj.algorithm.sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author caijun
 * @Classname Code_02_SelectionSort
 * @Description
 * @Version 1.0
 * @create 2020-05-06 14:53
 */


public class Code_02_SelectionSort {
    public static void selectionSort(int[] arr){
        if(arr == null || arr.length < 2){
            return;
        }

        for (int i = 0; i < arr.length - 1; i++){
            int minIndex = i;
            for (int j = i+1; j < arr.length; j++){
                minIndex = arr[j] < arr[minIndex] ? j:minIndex;
            }
            swap(arr,i,minIndex);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}
