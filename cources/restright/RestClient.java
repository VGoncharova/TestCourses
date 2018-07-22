package ru.raiffeisen.cources.restright;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import ru.raiffeisen.cources.restright.model.Post;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RestClient {
    private HttpClient httpClient;

    public RestClient() {
        this.httpClient = new DefaultHttpClient();
    }

    public Post getSerializedPostByNumber(int number){
        HttpGet getRequest = new HttpGet("https://jsonplaceholder.typicode.com/posts/"+ number);

        StringBuilder builder = new StringBuilder("");

        try {
            HttpResponse httpResponse = httpClient.execute(getRequest);
            BufferedReader bufferedReader =
                    new BufferedReader(
                            new InputStreamReader(
                                    httpResponse.getEntity().getContent()));

            String line = "";
            while ((line = bufferedReader.readLine())!= null){
                builder.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return RestDataParser.getPostFromJSON(builder.toString());
    }

    public String getUserPostByNumber(int number){
        HttpGet getRequest = new HttpGet("https://jsonplaceholder.typicode.com/posts/"+ number);

        StringBuilder builder = new StringBuilder("");

        try {
            HttpResponse httpResponse = httpClient.execute(getRequest);
            BufferedReader bufferedReader =
                    new BufferedReader(
                            new InputStreamReader(
                                    httpResponse.getEntity().getContent()));

            String line = "";
            while ((line = bufferedReader.readLine())!= null){
                builder.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return builder.toString();
    }
}
