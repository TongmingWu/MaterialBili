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
import com.tongming.materialbili.model.Comment;
import com.tongming.materialbili.view.GlideGircleTransform;

import java.util.List;

/**
 * Created by Tongming on 2016/4/19.
 */
public class CommentAdapter extends BaseAdapter {

    private List<Comment.HotListEntity> hot;

    private List<Comment.ListEntity> normal;

    public CommentAdapter(List<?> list, int type) {
        if (type == 0) {
            this.hot = (List<Comment.HotListEntity>) list;
        } else {
            this.normal = (List<Comment.ListEntity>) list;
        }
    }

    private static class ViewHolder {

        public ImageView face;
        public ImageView level;
        public TextView name;
        public TextView floor;
        public TextView date;
        public TextView msg;
        public TextView reply;
        public TextView good;

        public ViewHolder(View v) {
            face = (ImageView) v.findViewById(R.id.face_comment);
            level = (ImageView) v.findViewById(R.id.level_comment);
            name = (TextView) v.findViewById(R.id.user_comment);
            floor = (TextView) v.findViewById(R.id.floor_comment);
            date = (TextView) v.findViewById(R.id.date_comment);
            msg = (TextView) v.findViewById(R.id.msg_comment);
            reply = (TextView) v.findViewById(R.id.tv_reply);
            good = (TextView) v.findViewById(R.id.tv_good);
        }
    }

    @Override
    public int getCount() {
        if (hot != null) {
            return 2;
        } else {
            return normal.size();
        }
    }

    @Override
    public Object getItem(int position) {
        if (hot != null) {
            return hot.get(position).getNick();
        } else {
            return normal.get(position).getNick();
        }
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            convertView = View.inflate(BaseApplication.getInstance(), R.layout.item_comment, null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        if (parent.getChildCount() == position) {
            if (hot != null) {
                Glide.with(BaseApplication.getInstance())
                        .load(hot.get(position).getFace())
                        .transform(new GlideGircleTransform(BaseApplication.getInstance()))
                        .diskCacheStrategy(DiskCacheStrategy.NONE)
                        .into(holder.face);
                int level = hot.get(position).getLevel_info().getCurrent_level();
                switch (level) {
                    case 0:
                        Glide.with(BaseApplication.getInstance())
                                .load(R.drawable.ic_lv0)
                                .into(holder.level);
                        break;
                    case 1:
                        Glide.with(BaseApplication.getInstance())
                                .load(R.drawable.ic_lv1)
                                .into(holder.level);
                        break;
                    case 2:
                        Glide.with(BaseApplication.getInstance())
                                .load(R.drawable.ic_lv2)
                                .into(holder.level);
                        break;
                    case 3:
                        Glide.with(BaseApplication.getInstance())
                                .load(R.drawable.ic_lv3)
                                .into(holder.level);
                        break;
                    case 4:
                        Glide.with(BaseApplication.getInstance())
                                .load(R.drawable.ic_lv4)
                                .into(holder.level);
                        break;
                    case 5:
                        Glide.with(BaseApplication.getInstance())
                                .load(R.drawable.ic_lv5)
                                .into(holder.level);
                        break;
                    case 6:
                        Glide.with(BaseApplication.getInstance())
                                .load(R.drawable.ic_lv6)
                                .into(holder.level);
                        break;
                }
                holder.name.setText(hot.get(position).getNick());
                holder.floor.setText("#" + hot.get(position).getLv() + "");
                holder.date.setText(hot.get(position).getCreate_at());
                holder.msg.setText(hot.get(position).getMsg());
                holder.reply.setText(hot.get(position).getReply_count() + "");
                holder.good.setText(hot.get(position).getGood() + "");
            } else {
                Glide.with(BaseApplication.getInstance())
                        .load(normal.get(position).getFace())
                        .transform(new GlideGircleTransform(BaseApplication.getInstance()))
                        .diskCacheStrategy(DiskCacheStrategy.NONE)
                        .into(holder.face);
                int level = normal.get(position).getLevel_info().getCurrent_level();
                switch (level) {
                    case 0:
                        Glide.with(BaseApplication.getInstance())
                                .load(R.drawable.ic_lv0)
                                .into(holder.level);
                        break;
                    case 1:
                        Glide.with(BaseApplication.getInstance())
                                .load(R.drawable.ic_lv1)
                                .into(holder.level);
                        break;
                    case 2:
                        Glide.with(BaseApplication.getInstance())
                                .load(R.drawable.ic_lv2)
                                .into(holder.level);
                        break;
                    case 3:
                        Glide.with(BaseApplication.getInstance())
                                .load(R.drawable.ic_lv3)
                                .into(holder.level);
                        break;
                    case 4:
                        Glide.with(BaseApplication.getInstance())
                                .load(R.drawable.ic_lv4)
                                .into(holder.level);
                        break;
                    case 5:
                        Glide.with(BaseApplication.getInstance())
                                .load(R.drawable.ic_lv5)
                                .into(holder.level);
                        break;
                    case 6:
                        Glide.with(BaseApplication.getInstance())
                                .load(R.drawable.ic_lv6)
                                .into(holder.level);
                        break;
                }
                holder.name.setText(normal.get(position).getNick());
                holder.floor.setText("#"+normal.get(position).getLv() + "");
                holder.date.setText(normal.get(position).getCreate_at());
                holder.msg.setText(normal.get(position).getMsg());
                holder.reply.setText(normal.get(position).getReply_count() + "");
                holder.good.setText(normal.get(position).getGood() + "");
            }
        }
        return convertView;
    }
}
