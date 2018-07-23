package atmmock.src.ru.raiffeisen.cources.atm.atmsoapclient;

import atmmock.src.ru.raiffeisen.cources.atm.atmsoap.IAtmSoap;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URL;

public class AtmClient {
    public static void main(String[] args) {
        try {
            URL url = new URL("http://localhost:9999/atm?wsdl");

            QName qName = new QName("http://atmsoap.atm.cources.raiffeisen.ru.src.atmmock/",
                    "AtmSoapImplService");

            Service service = Service.create(url, qName);

            IAtmSoap atmSoap = service.getPort(IAtmSoap.class);

            atmSoap.addMoney("credit", 1000.0);
            atmSoap.addMoney("debet", 1500.0);
            atmSoap.addMoney("current", 500.0);
            atmSoap.putMoney("current", 900.0);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
