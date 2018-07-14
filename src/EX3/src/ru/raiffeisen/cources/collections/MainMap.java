package ru.raiffeisen.cources.collections;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class MainMap {
    public static void main(String[] args) {
        Map<Key, String> evilMap =
                new TreeMap<>();

        Key key1 = new Key(1,2,3);
        Key key2 = new Key(2,3,4);
        Key key3 = new Key(3,4,5);
        Key key4 = new Key(4,5,6);
        Key key5 = new Key(5,6,7);

        evilMap.put(key1, "Jofree");
        evilMap.put(key2, "Joker");
        evilMap.put(key3, "Tanos");
        evilMap.put(key4, "Loki");
        evilMap.put(key5, "Sauron");

        System.out.println(evilMap);

        evilMap.putIfAbsent(key1, "Zemo");
        Key key6 = new Key(9,10,11);
        evilMap.putIfAbsent(key6, "Ramsee");

        System.out.println(evilMap);

        Key key7 = new Key(1,2,3);
        evilMap.putIfAbsent(key7, "Zorg");
        evilMap.put(key2, "zavulon");

        System.out.println(evilMap);
    }
}
