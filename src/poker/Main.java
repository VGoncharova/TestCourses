package poker;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int playersQuantity = 0;
        Scanner scanner = new Scanner(System.in);

        while (playersQuantity < 2 || playersQuantity > 10) {
            System.out.println("Enter players quantity from 2 to 10");
            try {
                playersQuantity = scanner.nextInt();

            } catch (InputMismatchException e) {
                System.out.println("Incorrect input! Not numeral. You are not greeted in our casino anymore!");
                scanner.close();
                return;
            }
        }
        scanner.close();

        Croupier croupier = new Croupier();
        croupier.setPlayersQuantity(playersQuantity);

        String[][] playersCardSets = croupier.getPlayersCardSets();
        for (int i = 0; i < playersQuantity; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.println(playersCardSets[i][j]);
            }
            System.out.print("\n");
        }

    }
}
