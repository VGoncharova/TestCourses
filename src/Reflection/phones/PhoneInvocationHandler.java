package Reflection.phones;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class PhoneInvocationHandler implements InvocationHandler {
    private Phone phone;

    public PhoneInvocationHandler(Phone phone) {
        this.phone = phone;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = method.invoke(phone, args);
        System.out.println();
        System.out.println("Method result is " + result.toString());

        return result;
    }
}
