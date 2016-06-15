package com.lly.lookall.module.picture;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lly.lookall.R;
import com.lly.lookall.home.BaseFragment;
import com.lly.lookall.http.HttpRequestUtils;

import okhttp3.Call;

/**
 * PhotoFragment[v 1.0.0]
 * classes:com.lly.lookall.module.picture.PhotoFragment
 *
 * @author lileiyi
 * @date 2016/4/28
 * @time 9:52
 * @description
 */
public class PhotoFragment extends BaseFragment {


    private RecyclerView mRecyclerView;

    //返回数量
    private int num = 20;
    //获取方式，1:随机获取
    private int rand = 1;
    //搜索关键词
    private String word = "性感";
    private int page = 1;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.photo_fragment_layout, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
        getData();
    }

    /**
     * 获取数据
     */
    private void getData() {
        HttpRequestUtils.getPicList(num, rand, word, page, new HttpRequestUtils.onRequestCallback<PhotoEntity>() {
            @Override
            public void onSuccessful(PhotoEntity jokeEntity) {

            }

            @Override
            public void onError(Call call, Exception e) {

            }
        });
    }

    /**
     * 初始化View
     *
     * @param v
     */
    public void initView(View v) {
        mRecyclerView = (RecyclerView) v.findViewById(R.id.recy_view);
    }
}
