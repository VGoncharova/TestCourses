package ru.raiffeisen.cources.collections;

public class Key implements Comparable<Key>{
    private int val1;
    private int val2;
    private int val3;

    public Key(int val1, int val2, int val3) {
        this.val1 = val1;
        this.val2 = val2;
        this.val3 = val3;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Key key = (Key) o;

        if (val1 != key.val1) return false;
        if (val2 != key.val2) return false;
        return val3 == key.val3;
    }

    @Override
    public int hashCode() {
        int result = val1;
        result = 31 * result + val2;
        result = (int) (31 * result + val3);
        return result;
    }

    @Override
    public String toString() {
        return "Key{" +
                "val1=" + val1 +
                ", val2=" + val2 +
                ", val3=" + val3 +
                '}';
    }

    @Override
    public int compareTo(Key o) {
        if(val1 > o.val1) {
            return 1;
        }

        if(val1 < o.val1) {
            return -1;
        }

        return 0;
    }
}
