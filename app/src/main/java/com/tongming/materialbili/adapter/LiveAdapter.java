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
import com.tongming.materialbili.model.LiveVideo;
import com.tongming.materialbili.view.GlideGircleTransform;

import java.util.List;

/**
 * Created by Tongming on 2016/3/26.
 */
public class LiveAdapter extends BaseAdapter {
    private List<String> uname;
    private List<String> title;
    private List<String> cover;
    private List<String> face;
    private List<Integer> online;
    private List<LiveVideo.DataEntity.PartitionsEntity.LivesEntity> lives;
    private Context context;

    public LiveAdapter(List<LiveVideo.DataEntity.PartitionsEntity.LivesEntity> lives, Context context) {
        /*this.uname = uname;
        this.title = title;
        this.cover = cover;
        this.face = face;
        this.online = online;*/
        this.lives = lives;
        this.context = context;
    }

    private class ViewHolder {
        public ImageView iv_live;
        public ImageView iv_face;
        public TextView tv_author;
        public TextView tv_online;
        public TextView tv_title;

        public ViewHolder(View v) {
            iv_live = (ImageView) v.findViewById(R.id.iv_live);
            iv_face = (ImageView) v.findViewById(R.id.avatar);
            tv_author = (TextView) v.findViewById(R.id.userName);
            tv_online = (TextView) v.findViewById(R.id.watcher_num);
            tv_title = (TextView) v.findViewById(R.id.live_title);
        }
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public Object getItem(int position) {
        return lives.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder = null;
        if (convertView == null) {
            convertView = convertView.inflate(context, R.layout.item_live_card, null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        Glide.with(BaseApplication.getInstance())
                .load(lives.get(position).getCover().getSrc())
                .diskCacheStrategy(DiskCacheStrategy.RESULT)
                .placeholder(R.drawable.bili_drawerbg_logined)
                .centerCrop()
                .crossFade()
                .into(holder.iv_live);
        Glide.with(BaseApplication.getInstance()).
                load(lives.get(position).getOwner().getFace()).
                diskCacheStrategy(DiskCacheStrategy.RESULT).
                transform(new GlideGircleTransform(BaseApplication.getInstance())).
                into(holder.iv_face);
        holder.tv_author.setText(lives.get(position).getOwner().getName());
        holder.tv_online.setText(lives.get(position).getOnline() + "");
        holder.tv_title.setText(lives.get(position).getTitle());
        return convertView;
    }
}
