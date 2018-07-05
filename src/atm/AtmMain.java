package atm;

import java.util.Scanner;

public class AtmMain {
    public static void main(String[] args) {
        ATM atm = new ATM();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Choose operation: put/give/balance");
            String userInput = scanner.next().toLowerCase();

            if (userInput.equals("put")) {
                int amount = readInt(scanner, "Choose amount to put(multiples 100)");
                atm.putMoney(amount);
                showBalance(atm);
            } else if (userInput.equals("give")) {
                int amount = readInt(scanner, "Choose amount to give(multiples 100)");
                atm.giveMoney(amount);
                showBalance(atm);
            } else if (userInput.equals("balance")) {
                showBalance(atm);
            } else {
                System.out.println("Incorrect operation chosen");
            }
        }
    }

    public static int readInt(Scanner scanner, String message) {
        System.out.println(message);
        return scanner.nextInt();
    }

    public static void showBalance(ATM atm) {
        System.out.println("Your account balance is " + atm.getBalance());
    }
}
