package com.tongming.materialbili.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.tongming.materialbili.R;
import com.tongming.materialbili.base.BaseApplication;

import java.util.List;

/**
 * Created by Tongming on 2016/4/4.
 */
public class SearchVideoAdapter extends BaseAdapter {

    private List<String> pic ;
    private List<String> title;
    private List<String> up;
    private List<String> play;
    private List<String> review;
    private Context context;

    public SearchVideoAdapter(List<String> pic, List<String> title, List<String> up, List<String> play, List<String> review,Context context) {
        this.pic = pic;
        this.title = title;
        this.up = up;
        this.play = play;
        this.review = review;
        this.context = context;
    }

    private static class ViewHolder{
        public ImageView img;
        public TextView title;
        public TextView up;
        public TextView play;
        public TextView review;
    }

    @Override
    public int getCount() {
        return pic.size();
    }

    @Override
    public Object getItem(int position) {
        return pic.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if(convertView==null){
            holder = new ViewHolder();
            convertView = View.inflate(context, R.layout.item_search_result,null);
            holder.img = (ImageView) convertView.findViewById(R.id.iv_result);
            holder.title = (TextView) convertView.findViewById(R.id.tv_result_desc);
            holder.up = (TextView) convertView.findViewById(R.id.up);
            holder.play = (TextView) convertView.findViewById(R.id.tv_result_play);
            holder.review = (TextView) convertView.findViewById(R.id.tv_result_comm);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }
        Glide.with(BaseApplication.getInstance())
                .load(pic.get(position))
                .placeholder(R.drawable.bili_drawerbg_logined)
                .centerCrop()
                .crossFade()
                .skipMemoryCache(true)
                .diskCacheStrategy(DiskCacheStrategy.RESULT)
                .into(holder.img);
        holder.title.setText(title.get(position));
        holder.up.setText(up.get(position));
        holder.play.setText(play.get(position));
        holder.review.setText(review.get(position));
        return convertView;
    }
}
