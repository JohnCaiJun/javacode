package com.cj.javase.java集合;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author caijun
 * @Classname UtilList
 * @Description
 * @Version 1.0
 * @create 2020-05-04 21:29
 */


public class UtilList {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Apple");
        list.add("Pear");
        list.add("Orange");
        for (String s : list) {
            System.out.println(s);
        }

        System.out.println("------");

        List<String> linkedList = new LinkedList<>();
        linkedList.add("Apple");
        linkedList.add("Pear");
        linkedList.add("Orange");

        String[] ss = linkedList.toArray(new String[linkedList.size()]);

        for (String s : ss){
            System.out.println(s);
        }



    }

}
