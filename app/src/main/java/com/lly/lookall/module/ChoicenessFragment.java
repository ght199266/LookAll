package com.lly.lookall.module;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
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

import java.util.List;

import okhttp3.Call;

/**
 * ChoicenessFragment[v 1.0.0]
 * classes:com.lly.lookall.module.ChoicenessFragment
 *
 * @author lileiyi
 * @date 2016/4/28
 * @time 9:47
 * @description 精选
 */
public class ChoicenessFragment extends BaseFragment {

    private XRecyclerView mXRecyclerView;

    private int no = 1;
    private int ps = 20;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_choiceness_layout, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mXRecyclerView = (XRecyclerView) view.findViewById(R.id.xrecyclerview);
        mXRecyclerView.setLoadingMoreEnabled(false);
        getData();
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
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mXRecyclerView.setLayoutManager(layoutManager);
        ChoicenessAdapter choicenessAdapter = new ChoicenessAdapter(list);
        mXRecyclerView.setAdapter(choicenessAdapter);
    }

}
