package com.lly.lookall.http;

import com.google.gson.Gson;
import com.lly.lookall.entity.JokeEntity;
import com.zhy.http.okhttp.callback.Callback;

import java.io.IOException;

import okhttp3.Response;

public abstract class JokeCallback extends Callback<JokeEntity> {
    @Override
    public JokeEntity parseNetworkResponse(Response response) throws IOException {
        String string = response.body().string();
        JokeEntity jokeEntity = new Gson().fromJson(string, JokeEntity.class);
        return jokeEntity;
    }

}