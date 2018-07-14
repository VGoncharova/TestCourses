package Reflection;

public class Parent {
    public String familyName;
    protected String familySecret;
    private String secret;

    public int getNumber() {
        return 42;
    }

    protected boolean getBool(){
        return false;
    }

    private String getSomethingTerrible(){
        return "myhaha";
    }
}
