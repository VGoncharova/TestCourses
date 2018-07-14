package ru.raiffeisen.cources;

public class Main {

    public static void main(String[] args) {
	    int[] masOfInts = new int[10];
	    int[] masOfInts2;
	    masOfInts2 = new int[5];

	    int[] masOfIntsCreated = {1, 2, 3, 4};
        System.out.println(masOfIntsCreated[0]);
        masOfIntsCreated[1] = 7;

        String[] masOfStrings = {"Art", "Den"};

        Parent[] parents = new Parent[5];
        parents[0] = new Parent(10);
        parents[1] = new Child(6);

        System.out.println(parents[0].getAge());
        System.out.println(parents[1].getAge());

        Object[] objects = new Object[10];
        objects[0] = "Message";
        objects[1] = new Parent(10);
        objects[2] = new StringBuffer();

        int[][] matrixOfInts = new int[5][5];
        int[][][] cubeOfInts = new int[3][3][3];
        int[][] matrixOfIntsCreated = {{1,2,3}, {4,6}, {7,8,9,10}};
    }
}
