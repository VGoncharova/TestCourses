package ATMadvanced;

import ATMadvanced.model.money.Money;
import ATMadvanced.model.score.*;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ATM atm = new ATM();
        Scanner scanner = new Scanner(System.in);
        int val = scanner.nextInt();

        Money money = new Money(val, "RUR");
        atm.getCreditScore().addMoney(money);
        atm.getCreditScore().getMoney(scanner.nextDouble());

        printLoggable(CreditScore.class);
        printLoggable(DebetScore.class);
        printLoggable(CurrentScore.class);
    }
    public static void printLoggable(Class someClass){
        System.out.println("\nLog for class "+someClass.getSimpleName()+"\n");

            for (Annotation annotation :
                    someClass.getDeclaredAnnotations()) {
                if (annotation instanceof Loggable) {
                    for (Method method :
                            someClass.getDeclaredMethods()) {
                        System.out.print(method.getReturnType());
                        System.out.print(" ");
                        System.out.println(method.getName());
                    }
                }
            }
        }
    }

