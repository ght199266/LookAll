package com.lly.lookall.http;

import com.google.gson.Gson;
import com.lly.lookall.entity.ChicenessEntity;
import com.zhy.http.okhttp.callback.Callback;

import java.io.IOException;

import okhttp3.Response;

public abstract class ChoicenessCallback extends Callback<ChicenessEntity> {
    @Override
    public ChicenessEntity parseNetworkResponse(Response response) throws IOException {
        String string = response.body().string();
        ChicenessEntity ChicenessEntity = new Gson().fromJson(string, ChicenessEntity.class);
        return ChicenessEntity;
    }

}