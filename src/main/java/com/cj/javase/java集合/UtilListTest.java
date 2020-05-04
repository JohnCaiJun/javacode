package com.cj.javase.java集合;

import org.junit.Test;

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


public class UtilListTest {

    @Test
    public void testList() {
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

    @Test
    public void testEquals(){
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("Cai",25));
        persons.add(new Person("Jun",26));
        persons.add(new Person("Qian",20));
        System.out.println(persons);

        System.out.println(persons.contains(new Person("Jun",26)));



    }

}
