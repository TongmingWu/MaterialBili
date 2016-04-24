package com.tongming.materialbili.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.tongming.materialbili.R;
import com.tongming.materialbili.base.BaseApplication;
import com.tongming.materialbili.model.Search;

/**
 * Created by Tongming on 2016/4/4.
 */
public class SearchVideoAdapter extends BaseAdapter {

    private Search mSearch;

    public SearchVideoAdapter(Search search) {
        mSearch = search;
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
        return mSearch.getResult().getVideo().size();
    }

    @Override
    public Object getItem(int position) {
        return mSearch.getResult().getVideo().get(position);
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
            convertView = View.inflate(BaseApplication.getInstance(), R.layout.item_search_result,null);
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
                .load(mSearch.getResult().getVideo().get(position).getPic())
                .placeholder(R.drawable.bili_drawerbg_logined)
                .centerCrop()
                .crossFade()
                .skipMemoryCache(true)
                .diskCacheStrategy(DiskCacheStrategy.RESULT)
                .into(holder.img);
        holder.title.setText(mSearch.getResult().getVideo().get(position).getTitle());
        holder.up.setText(mSearch.getResult().getVideo().get(position).getAuthor());
        holder.play.setText(mSearch.getResult().getVideo().get(position).getPlay()+"");
        holder.review.setText(mSearch.getResult().getVideo().get(position).getReview()+"");
        return convertView;
    }
}
