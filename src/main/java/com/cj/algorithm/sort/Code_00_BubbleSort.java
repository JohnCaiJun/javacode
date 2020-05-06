package com.cj.algorithm.sort;

/**
 * @author caijun
 * @Classname Code_00_bubbleSort
 * @Description
 * @Version 1.0
 * @create 2020-05-06 14:44
 */

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 时间复杂度：O(n^2)
 */
public class Code_00_BubbleSort {
    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        for (int end = arr.length - 1; end > 0; end--) {
            for (int i = 0; i < end; i++) {
                if (arr[i] > arr[i + 1]) {
                    swap(arr, i, i + 1);
                }
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }


}
