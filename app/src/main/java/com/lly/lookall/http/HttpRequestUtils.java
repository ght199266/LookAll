package com.lly.lookall.http;

import com.lly.lookall.params.Params;
import com.zhy.http.okhttp.OkHttpUtils;

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
}


