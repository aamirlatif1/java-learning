package edu.learning.collections;

import java.util.*;

public class CollectionFramework {

    public static void main(String[] args) {
        //List
        List<Integer> al = new ArrayList<>();
        al.add(6);
        al.add(44);
        al.add(8);
        al.add(12);

        Collections.sort(al);
        System.out.println(al);

        // classical
        for (Iterator<Integer> itr = al.iterator(); itr.hasNext(); ){
            System.out.println(itr.next());
        }
        System.out.println();
        // For each loop
        for (Integer i : al){
            System.out.println(i);
        }
        //Foreach
        System.out.println();
        al.forEach(System.out::println);


//        List<Integer> ll = new LinkedList<>();
//
//        List<Integer> vec = new Vector<>();
//
//        //Set
        System.out.println();
        Set<Integer> hs = new HashSet<>();
        hs.add(22);
        hs.add(232);
        hs.add(11);
        hs.add(12121);
        for (Integer i : hs) {
            System.out.println(i);
        }
        hs.forEach(System.out::println);
//        Set<Integer> ts = new TreeSet<>();
//
//        Queue<Integer> q = new LinkedList<>();
//
//        Stack<Integer> s = new Stack<>();
//
//        //Map
//        Map<String, Integer> map = new HashMap<>();
//        Map<String, Integer> tmap = new TreeMap<>();

    }
}
