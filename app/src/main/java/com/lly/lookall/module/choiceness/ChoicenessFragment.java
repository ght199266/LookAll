package com.lly.lookall.module.choiceness;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.lly.lookall.R;
import com.lly.lookall.entity.ChicenessEntity;
import com.lly.lookall.home.BaseFragment;
import com.lly.lookall.http.ChoicenessCallback;
import com.lly.lookall.http.HttpRequestUtils;
import com.lly.lookall.params.Params;
import com.lly.lookall.view.CircleProgress;
import com.lly.lookall.view.DividerItemDecoration;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;

/**
 * ChoicenessFragment[v 1.0.0]
 * classes:com.lly.lookall.module.choiceness.ChoicenessFragment
 *
 * @author lileiyi
 * @date 2016/4/28
 * @time 9:47
 * @description 精选
 */
public class ChoicenessFragment extends BaseFragment {

    private XRecyclerView mXRecyclerView;
    private ChoicenessAdapter mChoicenessAdapter;
    private CircleProgress circle_progress;
    private int no = 1;
    private int ps = 20;
    private List<ChicenessEntity.ResultEntity.ListEntity> mlist;
    private boolean isLoadmore;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_choiceness_layout, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mXRecyclerView = (XRecyclerView) view.findViewById(R.id.xrecyclerview);
        circle_progress = (CircleProgress) view.findViewById(R.id.circle_progress);
        circle_progress.startAnim();
//        mXRecyclerView.setLoadingMoreEnabled(false);
        setListener();
        circle_progress.postDelayed(new Runnable() {
            @Override
            public void run() {
                getData();
            }
        }, 1500);
    }

    private void setListener() {
        mXRecyclerView.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                no = 1;
                isLoadmore = false;
                getData();
            }

            @Override
            public void onLoadMore() {
                no++;
                isLoadmore = true;
                getData();
            }
        });
    }

    /**
     * 请求数据
     */
    private void getData() {
        HttpRequestUtils.getWXChoicenessList(no, ps, Params.KEY, new ChoicenessCallback() {
            @Override
            public void onError(Call call, Exception e) {
                showToast(e.toString() + "");
            }

            @Override
            public void onResponse(ChicenessEntity response) {
                if (response.getError_code() == 0) {
                    setAdapter(response.getResult().getList());
                }
            }
        });
    }

    private void setAdapter(List<ChicenessEntity.ResultEntity.ListEntity> list) {
//        circle_progress.stopAnim();
        circle_progress.reset();
        circle_progress.setVisibility(View.GONE);
        mXRecyclerView.setVisibility(View.VISIBLE);
        if (mChoicenessAdapter == null) {
            mlist = new ArrayList<>();
            mlist.addAll(list);
            LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
            layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
            mXRecyclerView.setLayoutManager(layoutManager);
            mChoicenessAdapter = new ChoicenessAdapter(mlist);
            mXRecyclerView.setAdapter(mChoicenessAdapter);
            mXRecyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), LinearLayoutManager.VERTICAL));
        } else {
            if (!isLoadmore) {
                mlist.clear();
            }
            mlist.addAll(list);
            mChoicenessAdapter.notifyDataSetChanged();
        }
        mXRecyclerView.refreshComplete();
        if (isLoadmore) {
            mXRecyclerView.loadMoreComplete();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.v("leizi", "onDestroy");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.v("leizi", "onDestroyView");
    }
}
