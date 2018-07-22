package atmmock.src.ru.raiffeisen.cources.atm.atmsoap;

import javax.xml.ws.Endpoint;

public class Main {
    public static void main(String[] args) {
        Endpoint.publish("http://localhost:9999/atm",
                new AtmSoapImpl());
    }
}
