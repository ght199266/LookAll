package com.lly.lookall.module;

import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.lly.lookall.R;
import com.lly.lookall.entity.ChicenessEntity;

import java.util.List;

/**
 * ChoicenessAdapter[v 1.0.0]
 * classes:com.lly.lookall.module.ChoicenessAdapter
 *
 * @author lileiyi
 * @date 2016/5/3
 * @time 11:05
 * @description
 */
public class ChoicenessAdapter extends RecyclerView.Adapter<ChoicenessAdapter.ViewHolder> {

    public List<ChicenessEntity.ResultEntity.ListEntity> mList;

    public ChoicenessAdapter(List<ChicenessEntity.ResultEntity.ListEntity> datas) {
        this.mList = datas;
    }

    //创建新View，被LayoutManager所调用
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.fragment_choiceness_item, viewGroup, false);
        ViewHolder vh = new ViewHolder(view);
        return vh;
    }

    //将数据与界面进行绑定的操作
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        viewHolder.tv_title.setText(mList.get(position).getTitle());
        viewHolder.img_pic.setImageURI(Uri.parse(mList.get(position).getFirstImg()));
    }

    //获取数据的数量
    @Override
    public int getItemCount() {
        return mList.size();
    }

    //自定义的ViewHolder，持有每个Item的的所有界面元素
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public SimpleDraweeView img_pic;
        private TextView tv_title;

        public ViewHolder(View view) {
            super(view);
            img_pic = (SimpleDraweeView) view.findViewById(R.id.img_pic);
            tv_title = (TextView) view.findViewById(R.id.tv_title);
        }
    }
}
