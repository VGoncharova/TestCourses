package Reflection.longloaders;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class LongLoaderHandler implements InvocationHandler {
    private ILoader loader;

    public LongLoaderHandler(ILoader loader) {
        this.loader = loader;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        long startTime = System.currentTimeMillis();

        Object result = method.invoke(loader, args);
        System.out.println(System.currentTimeMillis() - startTime);

        return result;
    }
}
