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
import com.tongming.materialbili.model.HotVideo;

import java.util.List;

/**
 * 视频GridView适配器
 * Created by Tongming on 2016/3/7.
 */
public class VideoGridAdapter extends BaseAdapter {
    private List<String> imgPath;
    private List<String> plays;
    private List<String> comments;
    private List<String> titles;
    private List<HotVideo.AnimeVideo> animes;
    private List<HotVideo.Music> musics;
    private List<HotVideo.DanceVideo> dances;
    private List<HotVideo.GameVideo> games;
    private List<HotVideo.TechnologyVideo> tec;
    private List<HotVideo.FunnyVideo> fun;
    private List<HotVideo.GhotVideo> ghot;
    private List<HotVideo.TV> tvs;
    private int type;

    public VideoGridAdapter(List<?> list, int type) {

        switch (type) {
            case 0:
                this.animes = (List<HotVideo.AnimeVideo>) list;
                break;
            case 1:
                this.musics = (List<HotVideo.Music>) list;
                break;
            case 2:
                this.dances = (List<HotVideo.DanceVideo>) list;
                break;
            case 3:
                this.games = (List<HotVideo.GameVideo>) list;
                break;
            case 4:
                this.tec = (List<HotVideo.TechnologyVideo>) list;
                break;
            case 5:
                this.fun = (List<HotVideo.FunnyVideo>) list;
                break;
            case 6:
                this.ghot = (List<HotVideo.GhotVideo>) list;
                break;
            case 7:
                this.tvs = (List<HotVideo.TV>) list;
                break;
        }
        this.type = type;
    }

    public VideoGridAdapter(List<String> imgPath, List<String> titles, List<String> plays, List<String> comments) {
        this.imgPath = imgPath;
        this.titles = titles;
        this.plays = plays;
        this.comments = comments;
    }

    private static class ViewHolder {
        public ImageView iv_video;
        public TextView tv_desc;
        public TextView tv_play;
        public TextView tv_comment;

        public ViewHolder(View v) {
            iv_video = (ImageView) v.findViewById(R.id.pic);
            tv_desc = (TextView) v.findViewById(R.id.description);
            tv_play = (TextView) v.findViewById(R.id.play);
            tv_comment = (TextView) v.findViewById(R.id.comment);
        }
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            convertView = View.inflate(BaseApplication.getInstance(), R.layout.item_recommend_card, null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        if (parent.getChildCount() == position) {
            if (animes != null) {
                HotVideo.AnimeVideo animeVideo = animes.get(position);
                Glide.with(BaseApplication.getInstance())
                        .load(animeVideo.getPic())
                        .placeholder(R.drawable.bili_drawerbg_logined)
                        .centerCrop()
                        .crossFade()
                        .skipMemoryCache(true)
                        .diskCacheStrategy(DiskCacheStrategy.RESULT)
                        .into(holder.iv_video);
                holder.tv_desc.setText(animeVideo.getDescription());
                holder.tv_play.setText(animeVideo.getPlay());
                holder.tv_comment.setText(animeVideo.getComment() + "");
            } else if (musics != null) {
                HotVideo.Music music = musics.get(position);
                Glide.with(BaseApplication.getInstance())
                        .load(music.getPic())
                        .placeholder(R.drawable.bili_drawerbg_logined)
                        .centerCrop()
                        .crossFade()
                        .skipMemoryCache(true)
                        .diskCacheStrategy(DiskCacheStrategy.RESULT)
                        .into(holder.iv_video);
                holder.tv_desc.setText(music.getDescription());
                holder.tv_play.setText(music.getPlay());
                holder.tv_comment.setText(music.getComment() + "");
            } else if (dances != null) {
                HotVideo.DanceVideo danceVideo = dances.get(position);
                Glide.with(BaseApplication.getInstance())
                        .load(danceVideo.getPic())
                        .placeholder(R.drawable.bili_drawerbg_logined)
                        .centerCrop()
                        .crossFade()
                        .skipMemoryCache(true)
                        .diskCacheStrategy(DiskCacheStrategy.RESULT)
                        .into(holder.iv_video);
                holder.tv_desc.setText(danceVideo.getDescription());
                holder.tv_play.setText(danceVideo.getPlay());
                holder.tv_comment.setText(danceVideo.getComment() + "");
            } else if (games != null) {
                HotVideo.GameVideo gameVideo = games.get(position);
                Glide.with(BaseApplication.getInstance())
                        .load(gameVideo.getPic())
                        .placeholder(R.drawable.bili_drawerbg_logined)
                        .centerCrop()
                        .crossFade()
                        .skipMemoryCache(true)
                        .diskCacheStrategy(DiskCacheStrategy.RESULT)
                        .into(holder.iv_video);
                holder.tv_desc.setText(gameVideo.getDescription());
                holder.tv_play.setText(gameVideo.getPlay());
                holder.tv_comment.setText(gameVideo.getComment() + "");
            } else if (tec != null) {
                HotVideo.TechnologyVideo tecVideo = tec.get(position);
                Glide.with(BaseApplication.getInstance())
                        .load(tecVideo.getPic())
                        .placeholder(R.drawable.bili_drawerbg_logined)
                        .centerCrop()
                        .crossFade()
                        .skipMemoryCache(true)
                        .diskCacheStrategy(DiskCacheStrategy.RESULT)
                        .into(holder.iv_video);
                holder.tv_desc.setText(tecVideo.getDescription());
                holder.tv_play.setText(tecVideo.getPlay());
                holder.tv_comment.setText(tecVideo.getComment() + "");
            } else if (fun != null) {
                HotVideo.FunnyVideo funnyVideo = fun.get(position);
                Glide.with(BaseApplication.getInstance())
                        .load(funnyVideo.getPic())
                        .placeholder(R.drawable.bili_drawerbg_logined)
                        .centerCrop()
                        .crossFade()
                        .skipMemoryCache(true)
                        .diskCacheStrategy(DiskCacheStrategy.RESULT)
                        .into(holder.iv_video);
                holder.tv_desc.setText(funnyVideo.getDescription());
                holder.tv_play.setText(funnyVideo.getPlay());
                holder.tv_comment.setText(funnyVideo.getComment() + "");
            } else if (ghot != null) {
                HotVideo.GhotVideo ghotVideo = ghot.get(position);
                Glide.with(BaseApplication.getInstance())
                        .load(ghotVideo.getPic())
                        .placeholder(R.drawable.bili_drawerbg_logined)
                        .centerCrop()
                        .crossFade()
                        .skipMemoryCache(true)
                        .diskCacheStrategy(DiskCacheStrategy.RESULT)
                        .into(holder.iv_video);
                holder.tv_desc.setText(ghotVideo.getDescription());
                holder.tv_play.setText(ghotVideo.getPlay());
                holder.tv_comment.setText(ghotVideo.getComment() + "");
            } else if (tvs != null) {
                HotVideo.TV tv = tvs.get(position);
                Glide.with(BaseApplication.getInstance())
                        .load(tv.getPic())
                        .placeholder(R.drawable.bili_drawerbg_logined)
                        .centerCrop()
                        .crossFade()
                        .skipMemoryCache(true)
                        .diskCacheStrategy(DiskCacheStrategy.RESULT)
                        .into(holder.iv_video);
                holder.tv_desc.setText(tv.getDescription());
                holder.tv_play.setText(tv.getPlay());
                holder.tv_comment.setText(tv.getComment() + "");
            }
        }
        return convertView;
    }
}
