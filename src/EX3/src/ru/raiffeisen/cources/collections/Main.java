package ru.raiffeisen.cources.collections;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> heroes = new ArrayList<String>();
        heroes.add("John Snow");
        heroes.add("Hulk");
        heroes.add("Spider Man");

        boolean isHulk = heroes.contains("Hulk");
        System.out.println(isHulk);

        System.out.println(heroes);

        heroes.remove("Hulk");
        heroes.remove(0);

        System.out.println(heroes);

        List<Integer> integerList = new ArrayList<Integer>();
        integerList.add(50);
        integerList.add(0);

        Integer integer = 0;
        integerList.remove(integer);
        System.out.println(integerList);
        integerList.remove(0);
        System.out.println(integerList);
    }
}
