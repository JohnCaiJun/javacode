package com.cj.algorithm.sort;

/**
 * @author caijun
 * @Classname Code_05_Reverse
 * @Description 逆序对
 * @Version 1.0
 * @create 2020-05-06 17:28
 */


public class Code_05_Reverse {
    public static void reverse(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        sortProcess(arr, 0, arr.length - 1);
    }

    private static void sortProcess(int[] arr, int L, int R) {
        if (L == R) {
            return;
        }
        int mid = (L + R) / 2;
        sortProcess(arr, L, mid);
        sortProcess(arr, mid + 1, R);
        merge(arr, L, mid, R);

    }

    private static void merge(int[] arr, int L, int mid, int R) {
        int[] help = new int[R - L + 1];
        int i = 0;
        int p1 = L;
        int p2 = mid + 1;
        int sum = 0;
        while (p1 <= mid && p2 <= R) {

            for (int j=p2;arr[p1]>arr[p2] && j<=R;j++){
                System.out.println("("+arr[p1]+","+arr[j]+")");
            }
            help[i++] = arr[p1] > arr[p2] ? arr[p1++] : arr[p2++];
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

    }
}
