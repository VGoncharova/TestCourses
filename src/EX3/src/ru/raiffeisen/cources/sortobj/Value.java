package ru.raiffeisen.cources.sortobj;

public class Value implements Comparable{
    private int val1;
    private String val2;

    public Value(int val1, String val2) {
        this.val1 = val1;
        this.val2 = val2;
    }

    public int getVal1() {
        return val1;
    }

    public void setVal1(int val1) {
        this.val1 = val1;
    }

    public String getVal2() {
        return val2;
    }

    public void setVal2(String val2) {
        this.val2 = val2;
    }

    @Override
    public String toString() {
        return "Value{" +
                "val1=" + val1 +
                ", val2='" + val2 + '\'' +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        Value innerValue = (Value) o;
        if(innerValue.val1 > this.val1) {
            return 1;
        }
        if(innerValue.val1 < this.val1) {
            return -1;
        }

        return 0;
    }
}
