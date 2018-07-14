package Reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class Main {

    public static void main(String[] args) {
	    Class parentClass= Parent.class;

	    Child child = new Child();
        Class childClass = child.getClass();

        System.out.println(parentClass.getName());
        System.out.println(parentClass.getCanonicalName());
//        for (Field field:
//                childClass.getFields()) {
//            System.out.print(field.getType());
//            System.out.println(" ");
//            System.out.print(field.getName());
//            System.out.println(" ");
//            System.out.print(field.getModifiers());
//            System.out.println();
//        }

        System.out.println("____________________");
        for (Field field:
                childClass.getDeclaredFields()) {
            System.out.print(field.getType());
            System.out.println(" ");
            System.out.print(field.getName());
            System.out.println(" ");
            System.out.print(field.getModifiers());
            System.out.println();
        }

//        System.out.println("_____________");
//        for (Method method:
//             childClass.getMethods()) {
//            System.out.print(method.getReturnType());
//            System.out.print(" ");
//            System.out.println(method.getName());
//            System.out.println(" ");
//            for (Parameter parameter:
//                 method.getParameters()) {
//                System.out.print(parameter.getName());
//                System.out.print(" ");
//                System.out.print(parameter.getType());
//                System.out.print(" ");
//                System.out.print(parameter.getModifiers());
//            }
//        }
//
//        for (Method method:
//                childClass.getDeclaredMethods()) {
//            System.out.print(method.getReturnType());
//            System.out.print(" ");
//            System.out.println(method.getName());
//            System.out.println(" ");
//            for (Parameter parameter:
//                    method.getParameters()) {
//                System.out.print(parameter.getName());
//                System.out.print(" ");
//                System.out.print(parameter.getType());
//                System.out.print(" ");
//                System.out.print(parameter.getModifiers());
//            }
//        }

        /*childClass.getSuperclass();
        childClass.getConstructors();
        childClass.getAnnotations();*/
        for (Class inter:
             childClass.getInterfaces()) {
            for (Method method:
                    inter.getDeclaredMethods()) {
                System.out.print(method.getReturnType());
                System.out.print(" ");
                System.out.println(method.getName());
                System.out.println(" ");
                for (Parameter parameter:
                        method.getParameters()) {
                    System.out.print(parameter.getName());
                    System.out.print(" ");
                    System.out.print(parameter.getType());
                    System.out.print(" ");
                    System.out.print(parameter.getModifiers());
                }
            }
        }
    }
}
