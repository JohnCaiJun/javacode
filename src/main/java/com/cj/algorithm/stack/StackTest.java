package com.cj.algorithm.stack;

/**
 * @author caijun
 * @Classname StackTest
 * @Description
 * @Version 1.0
 * @create 2020-05-06 13:55
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 栈有以下几个方法：
 *  push
 *  pop
 *  top
 *  isEmpty
 *  size
 *  clear
 */
public class StackTest {
    private List<Integer> stack = new ArrayList<>();


    // 从栈顶添加元素
    public void push(int item){
        stack.add(item);
    }


    public void pop(){

    }
}
