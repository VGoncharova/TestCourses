package Reflection.phones;

import java.lang.reflect.Proxy;

public class Main {
    public static void main(String[] args) {
        Phone phone = new Smartphone();
        phone.questionAnswer("Hello!");

        Phone phoneProxy =
                (Phone) Proxy.newProxyInstance(
                        Smartphone.class.getClassLoader(),
                        Smartphone.class.getInterfaces(),
                        new PhoneInvocationHandler(phone));

        System.out.println(phoneProxy.questionAnswer("Secret message"));
    }
}
