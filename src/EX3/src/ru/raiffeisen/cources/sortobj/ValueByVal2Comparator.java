package ru.raiffeisen.cources.sortobj;

import java.util.Comparator;

public class ValueByVal2Comparator implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        Value innerValue1 = (Value) o1;
        Value innerValue2 = (Value) o2;

        if(innerValue1.getVal2().length() > innerValue2.getVal2().length()) {
            return 1;
        }

        if(innerValue1.getVal2().length() < innerValue2.getVal2().length()) {
            return -1;
        }

        return 0;
    }
}
