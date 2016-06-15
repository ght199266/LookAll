package com.lly.lookall.module.joke;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.lly.lookall.R;
import com.lly.lookall.entity.JokeEntity;
import com.lly.lookall.home.BaseFragment;
import com.lly.lookall.http.HttpRequestUtils;
import com.lly.lookall.http.JokeCallback;
import com.lly.lookall.params.Params;
import com.lly.lookall.view.CircleProgress;
import com.lly.lookall.view.DividerItemDecoration;

import java.util.List;

import okhttp3.Call;

/**
 * JokeFragment[v 1.0.0]
 * classes:com.lly.lookall.module.joke.JokeFragment
 *
 * @author lileiyi
 * @date 2016/4/28
 * @time 9:51
 * @description
 */
public class JokeFragment extends BaseFragment {

    private XRecyclerView mXRecyclerView;
    private CircleProgress circle_progress;
    private int page = 1;
    private int pageSize = 20;
    private boolean isfrist = true;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_jokefragment_layout, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mXRecyclerView = (XRecyclerView) view.findViewById(R.id.joke_recyclerview);
        circle_progress = (CircleProgress) view.findViewById(R.id.circle_progress);
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser && isfrist) {
            circle_progress.startAnim();
            getData();
            isfrist = false;
        }
    }

    private void getData() {
        HttpRequestUtils.getJokeList(1, 20, Params.JOKEKEY, new JokeCallback() {
            @Override
            public void onError(Call call, Exception e) {
                showToast("" + e.toString());
            }

            @Override
            public void onResponse(JokeEntity response) {
                showToast("" + response.getError_code());
                mXRecyclerView.setVisibility(View.VISIBLE);
                circle_progress.reset();
                circle_progress.setVisibility(View.GONE);
                setAdapter(response.getResult().getData());
            }
        });
    }

    private void setAdapter(List<JokeEntity.ResultEntity.DataEntity> list) {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mXRecyclerView.setLayoutManager(layoutManager);
        JokeAdapter jokeAdapter = new JokeAdapter(list);
        mXRecyclerView.setAdapter(jokeAdapter);
        mXRecyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), LinearLayoutManager.VERTICAL));
    }
}
