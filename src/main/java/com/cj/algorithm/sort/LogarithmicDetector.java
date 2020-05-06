package com.cj.algorithm.sort;

import org.junit.Test;

import java.util.Arrays;


/**
 * @author caijun
 * @Classname LogarithmicDetector
 * @Description 对数器
 * @Version 1.0
 * @create 2020-05-06 15:34
 */


public class LogarithmicDetector {
    /**
     * Math.random() -> double [0,1)
     * (int) ((size + 1) * Math.random()) -> [0,size] 整数
     *
     * @param size
     * @param value
     * @return
     */
    public static int[] generateRandomArray(int size, int value) {
        int[] arr = new int[(int) ((size + 1) * Math.random())];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((value + 1) * Math.random()) - (int) (value * Math.random());
        }
        return arr;
    }

    /**
     * 绝对正确的方法： 好写，时间复杂度低也没关系，保证正确
     */
    public static void rightMethod(int[] arr) {
        Arrays.sort(arr);
    }


    @Test
    public void testLogarithmicDetector() {
        int testTime = 500000;
        int size = 10;   // 样本量先用少的
        int value = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(size, value);
            int[] arr2 = copyArray(arr1);
            Code_01_InsertionSort.insertionSort(arr1);
            rightMethod(arr2);
            if (!isEqual(arr1, arr2)) {
                succeed = false;

                // 打印数组
                printArray(arr1);
                printArray(arr2);
                break;
            }

        }
        System.out.println(succeed ? "Nice!" : "fucking fucked!");


    }

    private boolean isEqual(int[] arr1, int[] arr2) {
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
            return false;
        }

        if (arr1.length != arr2.length) {
            return false;
        }

        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    private void printArray(int[] arr3) {
        System.out.println(Arrays.toString(arr3));
    }

    private int[] copyArray(int[] arr1) {
        int[] arr_new = new int[arr1.length];
        for (int i = 0; i < arr_new.length; i++) {
            arr_new[i] = arr1[i];
        }
        return arr_new;
    }

}
