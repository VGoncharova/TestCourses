package ru.raiffeisen.cources.soap;

import javax.jws.WebService;

@WebService(endpointInterface = "ru.raiffeisen.cources.soap.IHelloWorld")
public class HelloWorldImpl implements IHelloWorld {
    @Override
    public String sayHello(String name) {
        return "Hello world to " + name;
    }
}
