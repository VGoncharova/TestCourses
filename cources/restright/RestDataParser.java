package ru.raiffeisen.cources.restright;

import com.google.gson.Gson;
import ru.raiffeisen.cources.restright.model.Post;

public class RestDataParser {

    private static final Gson parserGson = new Gson();

    public static Post getPostFromJSON(String json){
        return parserGson.fromJson(json, Post.class);
    }
}
