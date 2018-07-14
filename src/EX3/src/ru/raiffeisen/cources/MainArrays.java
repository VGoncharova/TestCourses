package ru.raiffeisen.cources;

import java.util.Arrays;

public class MainArrays {
    public static void main(String[] args) {
        int[] masOfInts = {1, 434, 32, 42, 422, 6, 9 ,1, 90};
        Arrays.sort(masOfInts);
        System.out.println(Arrays.toString(masOfInts));

        int[] masOfIntsExtended =
                Arrays.copyOf(masOfInts, masOfInts.length + 5);
        int[] masOfIntsMin =
                Arrays.copyOf(masOfInts, 5);
        System.out.println(Arrays.toString(masOfIntsExtended));
        System.out.println(Arrays.toString(masOfIntsMin));

        System.out.println(
                Arrays.binarySearch(masOfInts, 3, 8, 42));

        System.arraycopy(masOfInts, 5,masOfIntsExtended, 8, 2);
        System.out.println(Arrays.toString(masOfIntsExtended));
    }
}
