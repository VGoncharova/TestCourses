package ru.raiffeisen.cources.soapclient;

import ru.raiffeisen.cources.soap.IHelloWorld;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URL;

public class Client {
    public static void main(String[] args) {
        try {
            URL url = new URL("http://localhost:9999/ws/hello?wsdl");

            QName qName = new QName("http://soap.cources.raiffeisen.ru/",
                                    "HelloWorldImplService");

            Service service = Service.create(url, qName);

            IHelloWorld helloWorld = service.getPort(IHelloWorld.class);

            System.out.println(helloWorld.sayHello("Artem"));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
