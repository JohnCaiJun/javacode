package com.cj.javase.java集合;

import org.junit.Test;

import javax.sound.midi.Soundbank;
import java.util.*;

/**
 * @author caijun
 * @Classname UtilList
 * @Description
 * @Version 1.0
 * @create 2020-05-04 21:29
 */


public class UtilTest {

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

        for (String s : ss) {
            System.out.println(s);
        }
    }

    @Test
    public void testEquals() {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("Cai", 25));
        persons.add(new Person("Jun", 26));
        persons.add(new Person("Qian", 20));
        System.out.println(persons);

        System.out.println(persons.contains(new Person("Jun", 26)));


    }

    /**
     * 根据姓名获取对象
     */

    @Test
    public void testMap() {
        List<Person> list = Arrays.asList(new Person("Ming", 12),
                new Person("Cai", 14), new Person("Song", 18));
        Map<String, Person> map = new HashMap<>();

        for (Person p : list) {
            map.put(p.getName(), p);

        }

        System.out.println(map.get("Ming"));
        System.out.println(map.get("Cai"));

        System.out.println("--- HashMap ---");


        // 通过key遍历
        for (String k : map.keySet()) {
            System.out.println(k + " -> " + map.get(k));
        }

        System.out.println("--- Treemap ---");

        Map<String, Person> treeMap = new TreeMap<>();
        for (Person p : list) {
            treeMap.put(p.getName(), p);
        }

        for (String k : treeMap.keySet()) {
            System.out.println(k + " -> " + treeMap.get(k));
        }

        System.out.println("--- 倒序 TreeMap ---");

        // 实现Comparator方法实现倒序
        Map<String, Person> reverseTreeMap = new TreeMap<>(
                new Comparator<String>() {
                    @Override
                    public int compare(String o1, String o2) {
                        return -o1.compareTo(o2);
                    }
                }
        );
        for (Person p : list) {
            reverseTreeMap.put(p.getName(), p);
        }

        for (Map.Entry<String, Person> entry : reverseTreeMap.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }


    }

}
