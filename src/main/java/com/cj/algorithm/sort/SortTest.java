package com.cj.algorithm.sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author caijun
 * @Classname SortTest
 * @Description
 * @Version 1.0
 * @create 2020-05-06 15:13
 */


public class SortTest {
    @Test
    public void testSort() {
        int[] arr = {5, 28, 7, 6, 3, 2};
        System.out.println("before:" + Arrays.toString(arr));
        Code_05_Reverse.reverse(arr);
        System.out.println("after" + Arrays.toString(arr));
    }
}
