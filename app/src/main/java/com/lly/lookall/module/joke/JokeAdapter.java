package com.lly.lookall.module.joke;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.lly.lookall.R;
import com.lly.lookall.entity.JokeEntity;
import com.lly.lookall.module.choiceness.WebViewActivity;
import com.lly.lookall.params.BundleKey;

import java.util.List;

/**
 * JokeAdapter[v 1.0.0]
 * classes:com.lly.lookall.module.joke.JokeAdapter
 *
 * @author lileiyi
 * @date 2016/5/3
 * @time 15:26
 * @description
 */
public class JokeAdapter extends RecyclerView.Adapter<JokeAdapter.ViewHolder> {

    public List<JokeEntity.ResultEntity.DataEntity> mList;

    public JokeAdapter(List<JokeEntity.ResultEntity.DataEntity> datas) {
        this.mList = datas;
    }

    //创建新View，被LayoutManager所调用
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.fragment_joke_item, viewGroup, false);
        ViewHolder vh = new ViewHolder(view);
        return vh;
    }

    //将数据与界面进行绑定的操作
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        viewHolder.tv_title.setText(mList.get(position).getContent());
        viewHolder.position = position;
        DraweeController controller = Fresco.newDraweeControllerBuilder()
                .setUri(Uri.parse(mList.get(position).getUrl()))
                .setAutoPlayAnimations(true)
                .build();
        viewHolder.img_pic.setController(controller);
    }

    //获取数据的数量
    @Override
    public int getItemCount() {
        return mList.size();
    }

    //自定义的ViewHolder，持有每个Item的的所有界面元素
    public class ViewHolder extends RecyclerView.ViewHolder {
        public SimpleDraweeView img_pic;
        private TextView tv_title;
        private int position;

        public ViewHolder(View view) {
            super(view);
            img_pic = (SimpleDraweeView) view.findViewById(R.id.img_pic);
            tv_title = (TextView) view.findViewById(R.id.tv_title);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent();
                    intent.putExtra(BundleKey.URL, mList.get(position).getUrl());
                    intent.setClass(v.getContext(), WebViewActivity.class);
                    v.getContext().startActivity(intent);
                }
            });
        }
    }
}
