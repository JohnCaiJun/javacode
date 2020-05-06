package com.cj.algorithm.sort;

/**
 * @author caijun
 * @Classname Code_04_SmallSum
 * @Description
 * @Version 1.0
 * @create 2020-05-06 17:03
 */


public class Code_04_SmallSum {
    public static int smallSum(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }

        return mergeSort(arr, 0, arr.length - 1);

    }

    private static int mergeSort(int[] arr, int L, int R) {
        if (L == R) {
            return 0;
        }
        int mid = (L + R) / 2;
        return mergeSort(arr, L, mid) + mergeSort(arr, mid + 1, R) + merge(arr, L, mid, R);
    }

    private static int merge(int[] arr, int L, int mid, int R) {
        int[] help = new int[R - L + 1];
        int i = 0;
        int p1 = L;
        int p2 = mid + 1;
        int sum = 0;
        while (p1 <= mid && p2 <= R) {
            sum += arr[p1] < arr[p2] ? (R - p2 + 1) * arr[p1] : 0;
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= mid) {
            help[i++] = arr[p1++];
        }
        while (p2 <= R) {
            help[i++] = arr[p2++];
        }

        for (int j = 0; j < help.length; j++) {
            arr[L + j] = help[j];
        }
        return sum;
    }
}
