package com.lly.lookall.http;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lly.lookall.module.picture.PhotoEntity;
import com.lly.lookall.params.Params;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

import okhttp3.Call;

/**
 * HttpRequestUtils[v 1.0.0]
 * classes:com.lly.lookall.http.HttpRequestUtils
 *
 * @author lileiyi
 * @date 2016/5/3
 * @time 10:02
 * @description
 */
public class HttpRequestUtils {

    /**
     * pno	int	否	当前页数，默认1
     * ps	int	否	每页返回条数，最大100，默认20
     * key	string	是	应用APPKEY(应用详细页查询)
     * dtype	string	否	返回数据的格式,xml或json，默认json
     */
    public static void getWXChoicenessList(int pno, int ps, String key, ChoicenessCallback chicenessCallback) {
        OkHttpUtils.get().url(Params.URL).addParams("pno", String.valueOf(pno))
                .addParams("ps", String.valueOf(ps)).addParams("key", key).addParams("dtype", "json").build().execute(chicenessCallback);
    }


    /**
     * pno	int	否	当前页数，默认1
     * ps	int	否	每页返回条数，最大100，默认20
     * key	string	是	应用APPKEY(应用详细页查询)
     * dtype	string	否	返回数据的格式,xml或json，默认json
     */
    public static void getJokeList(int page, int pagesize, String key, JokeCallback jokeCallback) {
        OkHttpUtils.get().url(Params.JOKEURL).addParams("page", String.valueOf(page))
                .addParams("pagesize", String.valueOf(pagesize)).addParams("key", key).build().execute(jokeCallback);
    }


    /**
     * 获取图片
     *
     * @param num
     * @param rand
     * @param word
     * @param page
     */
    public static <T> void getPicList(int num, int rand, String word, int page, onRequestCallback<T> callback) {
        Map<String, String> params = new HashMap<>();
        params.put("key", Params.TYKEY);
        params.put("num", String.valueOf(num));
        params.put("rand", String.valueOf(rand));
        params.put("word", word);
        params.put("page", String.valueOf(page));
        Type type = new TypeToken<PhotoEntity>() {
        }.getType();
        get(params, callback, type);
    }

    /**
     * GET方式请求
     *
     * @param params
     */
    private static <T> void get(Map<String, String> params, final onRequestCallback<T> callback, final Type type) {
        OkHttpUtils.get().url(Params.TYURL).params(params).build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e) {
                if (callback != null) {
                    callback.onError(call, e);
                }
            }

            @Override
            public void onResponse(String response) {
                if (callback != null) {
                    PhotoEntity entity = new Gson().fromJson(response, type);
                    if (entity != null) {
                        try {
//                            callback.onSuccessful(entity);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });
    }

    /**
     * 请求结果回调接口
     *
     * @param <T>
     */
    public interface onRequestCallback<T> {
        void onSuccessful(T t);

        void onError(Call call, Exception e);
    }

}


