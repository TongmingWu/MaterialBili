package com.tongming.materialbili.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;

import com.tongming.materialbili.R;
import com.tongming.materialbili.activity.LivePlayActivity;
import com.tongming.materialbili.activity.VideoPlayActivity;
import com.tongming.materialbili.model.Bangumi;
import com.tongming.materialbili.model.HotVideo;
import com.tongming.materialbili.model.LiveVideo;
import com.tongming.materialbili.view.VideoItemView;

import java.util.List;

/**
 * Created by Tongming on 2016/4/13.
 */
public class GridInListAdapter extends BaseAdapter {

    private Context context;
    private List<LiveVideo.DataEntity.PartitionsEntity> partitionsEntity;
    private HotVideo hotVideo;
    private Bangumi bangumi;

    public GridInListAdapter(Context context, List<LiveVideo.DataEntity.PartitionsEntity> partitionsEntity) {
        this.context = context;
        this.partitionsEntity = partitionsEntity;
    }

    public GridInListAdapter(Context context, HotVideo hotVideo) {
        this.context = context;
        this.hotVideo = hotVideo;
    }

    @Override
    public int getCount() {
        if (partitionsEntity != null) {
            return partitionsEntity.size();
        } else if (hotVideo != null) {
            //return hotVideo.getanimeVideos().size();
            return 7;
        }
        return 0;
    }

    @Override
    public Object getItem(int position) {
        if (partitionsEntity != null) {
            return partitionsEntity.get(position);
        } else if (hotVideo != null) {
            return hotVideo.getanimeVideos().get(position);
        }
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    private static class ViewHolder {
        public VideoItemView itemView;
        public GridView gv;

        public ViewHolder(View v) {
            itemView = (VideoItemView) v.findViewById(R.id.list_video);
            gv = itemView.getGvView();
        }
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            convertView = View.inflate(context, R.layout.item_listview, null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        if (parent.getChildCount() == position) {
            if (partitionsEntity != null) {
                final List<LiveVideo.DataEntity.PartitionsEntity.LivesEntity> lives = partitionsEntity.get(position).getLives();
                LiveAdapter liveAdapter = new LiveAdapter(lives);
                switch (position) {
                    case 0:
                        holder.itemView.setIvView(R.drawable.live_8);
                        holder.itemView.setTvDesc("萌宅推荐");
                        break;
                    case 1:
                        holder.itemView.setIvView(R.drawable.live_0);
                        holder.itemView.setTvDesc("热门直播");
                        break;
                    case 2:
                        holder.itemView.setIvView(R.drawable.live_9);
                        holder.itemView.setTvDesc("绘画专区");
                        break;
                    case 3:
                        holder.itemView.setIvView(R.drawable.live_2);
                        holder.itemView.setTvDesc("御宅文化");
                        break;
                    case 4:
                        holder.itemView.setIvView(R.drawable.live_6);
                        holder.itemView.setTvDesc("生活娱乐");
                        break;
                    case 5:
                        holder.itemView.setIvView(R.drawable.live_1);
                        holder.itemView.setTvDesc("单机联机");
                        break;
                    case 6:
                        holder.itemView.setIvView(R.drawable.live_3);
                        holder.itemView.setTvDesc("网络游戏");
                        break;
                    case 7:
                        holder.itemView.setIvView(R.drawable.live_4);
                        holder.itemView.setTvDesc("电子竞技");
                        break;
                    case 8:
                        holder.itemView.setIvView(R.drawable.live_7);
                        holder.itemView.setTvDesc("放映厅");
                        break;
                }
                holder.itemView.setTvMore("查看更多");
                if (holder.gv.getAdapter() == null) {
                    holder.gv.setAdapter(liveAdapter);
                    holder.gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            Intent intent = new Intent(context, LivePlayActivity.class);
                            Bundle bundle = new Bundle();
                            bundle.putParcelable("live", lives.get(position));
                            intent.putExtras(bundle);
                            context.startActivity(intent);
                        }
                    });
                }
            } else if (hotVideo != null) {
                switch (position) {
                    case 0:
                        holder.itemView.setIvView(R.drawable.ic_category_t3);
                        holder.itemView.setTvDesc("动画区");
                        holder.itemView.setTvMore("更多动画");
                        if (holder.gv.getAdapter() == null) {
                            holder.gv.setAdapter(new VideoGridAdapter(hotVideo.getanimeVideos(), 0));
                            holder.gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                @Override
                                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                    Intent intent = new Intent(context, VideoPlayActivity.class);
                                    Bundle bundle = new Bundle();
                                    bundle.putString("aid", hotVideo.getanimeVideos().get(position).getAid());
                                    intent.putExtras(bundle);
                                    context.startActivity(intent);
                                }
                            });
                        }
                        break;
                    case 1:
                        holder.itemView.setIvView(R.drawable.ic_category_t4);
                        holder.itemView.setTvDesc("音乐区");
                        holder.itemView.setTvMore("更多音乐");
                        if (holder.gv.getAdapter() == null) {
                            holder.gv.setAdapter(new VideoGridAdapter(hotVideo.getmusics(), 1));
                            holder.gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                @Override
                                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                    Intent intent = new Intent(context, VideoPlayActivity.class);
                                    Bundle bundle = new Bundle();
                                    bundle.putString("aid", hotVideo.getmusics().get(position).getAid());
                                    intent.putExtras(bundle);
                                    context.startActivity(intent);
                                }
                            });
                        }
                        break;
                    case 2:
                        holder.itemView.setIvView(R.drawable.ic_category_t5);
                        holder.itemView.setTvDesc("舞蹈区");
                        holder.itemView.setTvMore("更多舞蹈");
                        if (holder.gv.getAdapter() == null) {
                            holder.gv.setAdapter(new VideoGridAdapter(hotVideo.getdanceVideos(), 2));
                            holder.gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                @Override
                                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                    Intent intent = new Intent(context, VideoPlayActivity.class);
                                    Bundle bundle = new Bundle();
                                    bundle.putString("aid", hotVideo.getdanceVideos().get(position).getAid());
                                    intent.putExtras(bundle);
                                    context.startActivity(intent);
                                }
                            });
                        }
                        break;
                    case 3:
                        holder.itemView.setIvView(R.drawable.ic_category_t6);
                        holder.itemView.setTvDesc("游戏区");
                        holder.itemView.setTvMore("更多游戏");
                        if (holder.gv.getAdapter() == null) {
                            holder.gv.setAdapter(new VideoGridAdapter(hotVideo.getgameVideos(), 3));
                            holder.gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                @Override
                                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                    Intent intent = new Intent(context, VideoPlayActivity.class);
                                    Bundle bundle = new Bundle();
                                    bundle.putString("aid", hotVideo.getgameVideos().get(position).getAid());
                                    intent.putExtras(bundle);
                                    context.startActivity(intent);
                                }
                            });
                        }
                        break;
                    case 4:
                        holder.itemView.setIvView(R.drawable.ic_category_t7);
                        holder.itemView.setTvDesc("科技区");
                        holder.itemView.setTvMore("更多科技");
                        if (holder.gv.getAdapter() == null) {
                            holder.gv.setAdapter(new VideoGridAdapter(hotVideo.gettechnologyVideos(), 4));
                            holder.gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                @Override
                                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                    Intent intent = new Intent(context, VideoPlayActivity.class);
                                    Bundle bundle = new Bundle();
                                    bundle.putString("aid", hotVideo.gettechnologyVideos().get(position).getAid());
                                    intent.putExtras(bundle);
                                    context.startActivity(intent);
                                }
                            });
                        }
                        break;
                    case 5:
                        holder.itemView.setIvView(R.drawable.ic_category_t8);
                        holder.itemView.setTvDesc("娱乐区");
                        holder.itemView.setTvMore("更多娱乐");
                        if (holder.gv.getAdapter() == null) {
                            holder.gv.setAdapter(new VideoGridAdapter(hotVideo.getfunnyVideos(), 5));
                            holder.gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                @Override
                                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                    Intent intent = new Intent(context, VideoPlayActivity.class);
                                    Bundle bundle = new Bundle();
                                    bundle.putString("aid", hotVideo.getfunnyVideos().get(position).getAid());
                                    intent.putExtras(bundle);
                                    context.startActivity(intent);
                                }
                            });
                        }
                        break;
                    case 6:
                        holder.itemView.setIvView(R.drawable.ic_category_t9);
                        holder.itemView.setTvDesc("鬼畜区");
                        holder.itemView.setTvMore("更多鬼畜");
                        if (holder.gv.getAdapter() == null) {
                            holder.gv.setAdapter(new VideoGridAdapter(hotVideo.getghotVideos(), 6));
                            holder.gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                @Override
                                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                    Intent intent = new Intent(context, VideoPlayActivity.class);
                                    Bundle bundle = new Bundle();
                                    bundle.putString("aid", hotVideo.getghotVideos().get(position).getAid());
                                    intent.putExtras(bundle);
                                    context.startActivity(intent);
                                }
                            });
                        }
                        break;
                }
            }
        }
        return convertView;
    }
}
