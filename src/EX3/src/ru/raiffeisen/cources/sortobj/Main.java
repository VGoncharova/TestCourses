package ru.raiffeisen.cources.sortobj;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Value[] values = new Value[5];
        values[0] = new Value(1, "10");
        values[1] = new Value(2, "67");
        values[2] = new Value(3, "900");
        values[3] = new Value(4, "1000");
        values[4] = new Value(5, "100000");

        Arrays.sort(values);

        for (Value value:
             values) {
            System.out.println(value.toString());
        }

        System.out.println("_________________________");

        Arrays.sort(values, new ValueByVal2Comparator());
        for (Value value:
                values) {
            System.out.println(value.toString());
        }
    }
}
