package ru.raiffeisen.cources;

import java.util.Random;

public class MainWorkOnMas {
    public static void main(String[] args) {
        String[] randomDigitMas = new String[20];

        Random random = new Random();
        for (int i = 0; i < randomDigitMas.length; i++) {
            randomDigitMas[i] =
                    String.valueOf(random.nextGaussian());
        }

        for (int i = 0; i < randomDigitMas.length; i++) {
            System.out.print(randomDigitMas[i]+" ");
        }

        short[][] shortMatrix = new short[5][5];
        for (int i = 0; i < shortMatrix.length; i++) {
            for (int j = 0; j < shortMatrix[i].length; j++) {
                shortMatrix[i][j] = (short) random.nextInt();
            }
        }
        System.out.println("____________________________");

        for (int i = 0; i < shortMatrix.length; i++) {
            for (int j = 0; j < shortMatrix[i].length; j++) {
                System.out.print(shortMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
