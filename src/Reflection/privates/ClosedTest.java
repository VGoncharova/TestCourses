package Reflection.privates;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ClosedTest {
    public static void main(String[] args) {
        ClosedClass closedClassExamplar = new ClosedClass();
        closedClassExamplar.publicMethod();

        try {
            Field privateStateField =
                    closedClassExamplar
                            .getClass()
                            .getDeclaredField("privateState");

            privateStateField.setAccessible(true);

            //privateStateField.set(closedClassExamplar, 15);
            Object value = privateStateField
                                .get(closedClassExamplar);
            if((int)value == 10) {
                System.out.println("Test ok!");
            }

            Method method = closedClassExamplar
                                .getClass()
                                .getDeclaredMethod("privateMethod");
            method.setAccessible(true);
            method.invoke(closedClassExamplar, null);

            Object value2 = privateStateField
                    .get(closedClassExamplar);
            if((int)value2 == 11) {
                System.out.println("Test ok again!");
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }
}
