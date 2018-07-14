package Reflection.longloaders;

import java.lang.reflect.Proxy;

public class Main {
    public static void main(String[] args) {
        LongLoader longLoader = new LongLoader();
        longLoader.load("dataaa");

        ILoader loader =(ILoader) Proxy.newProxyInstance(longLoader.getClass().getClassLoader(),longLoader.getClass().getInterfaces(),new LongLoaderHandler(longLoader));
        loader.load("some text");
    }
}
