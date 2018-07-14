package ru.raiffeisen.cources.worker;

import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class Executor {
    private static Map<Integer, String> loggableMethods = new HashMap<>();

    static {

    }

    @SafeVarargs
    public static void main(String... args) {
        Worker worker = new Worker();
        Random random = new Random();

        Scanner scanner = new Scanner(System.in);
        System.out.println("How many methods do you want?");
        int methodsCount = scanner.nextInt();

        for (int i = 0; i < methodsCount; i++) {
            System.out.println("Enter method name!");
            String methodName = scanner.next();
            loggableMethods.put(i, methodName);
        }

        while (true) {
            int rand = random.nextInt(methodsCount+5);
            System.out.println(rand);
            String methodName = loggableMethods.get(rand);

            for (Method method:
                 worker.getClass().getDeclaredMethods()) {
                if(method.getName().equals(methodName)){
                    try {
                        method.invoke(worker, null);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    }
                }
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

