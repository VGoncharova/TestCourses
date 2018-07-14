package Reflection.phones;

public class Smartphone implements Phone {
    @Override
    public String questionAnswer(String message) {
        return "my answer to your message " + message + " is OK!";
    }
}
