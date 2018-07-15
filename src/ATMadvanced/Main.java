package ATMadvanced;

import ATMadvanced.annotations.Loggable;
import ATMadvanced.annotations.MethodLimit;
import ATMadvanced.model.money.Money;
import ATMadvanced.model.score.*;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ATM atm = new ATM();

        IATM atmProxy = (IATM) Proxy.newProxyInstance(
                atm.getClass().getClassLoader(),
                atm.getClass().getInterfaces(),
                new ATMHandler(atm)
        );

        printLoggable(CreditScore.class);
        printLoggable(DebetScore.class);
        printLoggable(CurrentScore.class);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Choose operation: put/give/balance");
            String userInput = scanner.next().toLowerCase();

            if (userInput.equals("put")) {
                int methodCounter = atm.getCreditScore().getExecutionCounter();
                boolean stopAddingMoney = isAddMoneyExecutionLimitReached(methodCounter);
                if (!stopAddingMoney) {
                    System.out.println("Choose amount to put in USD");
                    atm.getCreditScore().addMoney(new Money(scanner.nextInt(), "USD"));
                } else {
                    System.out.println("Your limit for putting money is reached");
                }

            } else if (userInput.equals("give")) {
                Score creditScore =  atmProxy.getCreditScore();
                if (creditScore == null) {
                    System.out.println("Operation time reached 2seconds! \nOperation was interrapted.");
                } else {
                    System.out.println("Choose amount to give in USD");
                    creditScore.getMoney(scanner.nextInt());
                }
            } else {
                System.out.println("Incorrect operation chosen");
            }
        }
    }

    public static void printLoggable(Class someClass) {
        System.out.println("\nLog for class " + someClass.getSimpleName() + "\n");

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

    public static boolean isAddMoneyExecutionLimitReached(int executions) {
        for (Method method :
                Score.class.getDeclaredMethods()) {
            if (method.getName().equals("addMoney")) {
                for (Annotation annotation :
                        method.getDeclaredAnnotations())
                    if (annotation instanceof MethodLimit) {
                        MethodLimit methodLimit = (MethodLimit) annotation;
                        if (methodLimit.execution() <= executions) {
                            return true;
                        }
                    }
            }
        }
        return false;
    }
}