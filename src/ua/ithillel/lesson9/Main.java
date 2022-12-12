package ua.ithillel.lesson9;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        Integer[] array = new Integer[]{1, 2, 3, 4};
        List<Integer> list1 = new ArrayList<>();
        List<String> name = Arrays.asList("ball", "bat", "glove", "glove", "glove", "car", "police", "house", "wall", "run");


        list.add(0, "Hello");
        list.add(1, "My");
        list.add(2, "name");
        list.add(3, "is");
        list.add(4, "Yevhen");
        list.add(5, "Yevhen");
        list.add(6, "Yevhen");
        list.add(7, "and");
        list.add(8, "what");
        list.add(9, "is");
        list.add(10, "your");
        list.add(11, "name");
        list1.add(0, 1);
        list1.add(1, 2);
        list1.add(2, 2);
        list1.add(3, 3);
        list1.add(4, 4);
        countOccurance(list, "Yevhen"); //дз п.1


        System.out.println(toList(array));  //дз п.2
        System.out.println(findUnique(list1)); //дз п.3
        calcOccurance(name); //дз п.4
        findOccurance(name);

    }

    public static void countOccurance(List<String> list, String str) {
        int iterator = 0;
        for (String s : list) {
            if (s.equals(str)) {
                iterator++;
            }
        }
        System.out.println("Numbers of duplicates: " + iterator);
    }

    public static List<Integer> toList(Integer[] array) {
        return Arrays.asList(array);
    }

    public static List<Integer> findUnique(List<Integer> list1) {
        return list1.stream().distinct().collect(Collectors.toList());
    }

    public static void calcOccurance(List<String> name) {

        Collections.sort(name);
        String str1 = name.get(0);
        int occurance = 1;
        for (int i = 1; i < name.size(); i++) {
            String str2 = name.get(i);
            if (name.get(0).equals(str2)) {
                occurance++;
            } else {
                System.out.println("word: " + str1 + " occurance: " + occurance);
                occurance = 1;
                str1 = str2;
            }
        }
        System.out.println("word: " + str1 + " occurance: " + occurance);
    }

    public static List<String> findOccurance(List<String> name) {
        Collections.sort(name);
        String str1 = name.get(0);
        int occurance = 1;
        List<String> names2 = new ArrayList<>();
        for (int i = 1; i < name.size(); i++) {
            String str2 = name.get(i);
            if (str1.equals(str2)) {
                occurance++;
            } else {
                names2.add("{name: " + str1 + " , occurance " + occurance + "}");
                occurance = 1;
                str1 = str2;
            }
        }
        names2.add("{name: " + str1 + " , occurance " + occurance + "}");
        names2.forEach(System.out::println);
        return names2;
    }
}
