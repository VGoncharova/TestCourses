package atmmock.src.ru.raiffeisen.cources.atm.atmsoap;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface IAtmSoap {
    @WebMethod
    void addMoney(String name, double sum);
    @WebMethod
    void putMoney(String name, double sum);
}
