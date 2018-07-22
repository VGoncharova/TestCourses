package ru.raiffeisen.cources.restright;

public class Main {
    public static void main(String[] args) {
        RestClient restClient = new RestClient();
        System.out.println(restClient.getSerializedPostByNumber(1));
    }
}
