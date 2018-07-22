package ru.raiffeisen.cources;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {
        HttpClient client = new DefaultHttpClient();
        HttpGet getRequest = new HttpGet("https://jsonplaceholder.typicode.com/posts/1");
        try {
            HttpResponse httpResponse = client.execute(getRequest);
            BufferedReader bufferedReader =
                    new BufferedReader(
                            new InputStreamReader(
                                    httpResponse.getEntity().getContent()));

            String line = "";
            while ((line = bufferedReader.readLine())!= null){
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
