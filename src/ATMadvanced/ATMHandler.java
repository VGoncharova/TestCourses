package ATMadvanced;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ATMHandler implements InvocationHandler {
    private ATM atm;

    public ATMHandler(ATM atm) {
        this.atm = atm;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args){
        long startTime = System.currentTimeMillis();

        Object result = null;
        try {
            result = method.invoke(atm, args);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        long endTime = System.currentTimeMillis();

        if (endTime - startTime > 2000) {
            return null;
        } else {
            return result;
        }
    }
}
