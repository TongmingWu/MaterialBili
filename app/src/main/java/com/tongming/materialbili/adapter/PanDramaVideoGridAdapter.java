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
import com.tongming.materialbili.model.Bangumi;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 番剧推荐GridView适配器
 * Created by Tongming on 2016/3/7.
 */
public class PanDramaVideoGridAdapter extends BaseAdapter {
    private List<String> imgPath;
    private List<String> titles;
    private List<String> date;
    private List<String> count;
    private Boolean flag = true;

    private List<Bangumi.Sunday> sun;
    private List<Bangumi.Monday> mon;
    private List<Bangumi.Tuesday> tue;
    private List<Bangumi.Wednesday> wed;
    private List<Bangumi.Thursday> thur;
    private List<Bangumi.Friday> fri;
    private List<Bangumi.Saturday> sat;

    public PanDramaVideoGridAdapter(List<?> list, int type) {
        flag = false;
        switch (type) {
            case 0:
                sun = (List<Bangumi.Sunday>) list;
                break;
            case 1:
                mon = (List<Bangumi.Monday>) list;
                break;
            case 2:
                tue = (List<Bangumi.Tuesday>) list;
                break;
            case 3:
                wed = (List<Bangumi.Wednesday>) list;
                break;
            case 4:
                thur = (List<Bangumi.Thursday>) list;
                break;
            case 5:
                fri = (List<Bangumi.Friday>) list;
                break;
            case 6:
                sat = (List<Bangumi.Saturday>) list;
                break;
        }
    }


    public PanDramaVideoGridAdapter(List<String> imgPath, List<String> titles, List<String> date) {
        this.imgPath = imgPath;
        this.titles = titles;
        this.date = date;
    }

    public PanDramaVideoGridAdapter(List<String> imgPath, List<String> titles, List<String> date, List<String> count) {
        this.imgPath = imgPath;
        this.titles = titles;
        this.date = date;
        this.count = count;
        flag = false;
    }


    private static class ViewHolder {
        public ImageView iv_pic;
        public TextView tv_name;
        public TextView tv_num;
        public TextView tv_date;
    }

    @Override
    public int getCount() {
        if (sun != null) {
            return sun.size();
        } else if (mon != null) {
            return mon.size();
        } else if (tue != null) {
            return tue.size();
        } else if (wed != null) {
            return wed.size();
        } else if (thur != null) {
            return thur.size();
        } else if (fri != null) {
            return fri.size();
        } else if (sat != null) {
            return sat.size();
        } else {
            return 4;
        }
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
            holder = new ViewHolder();
            convertView = View.inflate(BaseApplication.getInstance(), R.layout.item_pan_card, null);
            holder.iv_pic = (ImageView) convertView.findViewById(R.id.iv_pan);
            holder.tv_name = (TextView) convertView.findViewById(R.id.pan_name);
            holder.tv_num = (TextView) convertView.findViewById(R.id.pan_num);
            holder.tv_date = (TextView) convertView.findViewById(R.id.tv_date);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        if (parent.getChildCount() == position) {
            if (sun != null) {
                Glide.with(BaseApplication.getInstance()).
                        load(sun.get(position).getCover())
                        .placeholder(R.drawable.bili_drawerbg_logined)
                        .centerCrop()
                        .crossFade()
                        .skipMemoryCache(true)
                        .diskCacheStrategy(DiskCacheStrategy.RESULT)
                        .into(holder.iv_pic);
                holder.tv_name.setText(sun.get(position).getTitle());
                holder.tv_num.setText("第" + sun.get(position).getBgmcount() + "话");
                String[] str = sun.get(position).getLastupdate_at().split(" ");
                holder.tv_date.setText(str[1]);
            } else if (mon != null) {
                Glide.with(BaseApplication.getInstance()).
                        load(mon.get(position).getCover())
                        .placeholder(R.drawable.bili_drawerbg_logined)
                        .centerCrop()
                        .crossFade()
                        .skipMemoryCache(true)
                        .diskCacheStrategy(DiskCacheStrategy.RESULT)
                        .into(holder.iv_pic);
                holder.tv_name.setText(mon.get(position).getTitle());
                holder.tv_num.setText("第" + mon.get(position).getBgmcount() + "话");
                String[] str = mon.get(position).getLastupdate_at().split(" ");
                holder.tv_date.setText(str[1]);
            } else if (tue != null) {
                Glide.with(BaseApplication.getInstance()).
                        load(tue.get(position).getCover())
                        .placeholder(R.drawable.bili_drawerbg_logined)
                        .centerCrop()
                        .crossFade()
                        .skipMemoryCache(true)
                        .diskCacheStrategy(DiskCacheStrategy.RESULT)
                        .into(holder.iv_pic);
                holder.tv_name.setText(tue.get(position).getTitle());
                holder.tv_num.setText("第" + tue.get(position).getBgmcount() + "话");
                String[] str = tue.get(position).getLastupdate_at().split(" ");
                holder.tv_date.setText(str[1]);
            } else if (wed != null) {
                Glide.with(BaseApplication.getInstance()).
                        load(wed.get(position).getCover())
                        .placeholder(R.drawable.bili_drawerbg_logined)
                        .centerCrop()
                        .crossFade()
                        .skipMemoryCache(true)
                        .diskCacheStrategy(DiskCacheStrategy.RESULT)
                        .into(holder.iv_pic);
                holder.tv_name.setText(wed.get(position).getTitle());
                holder.tv_num.setText("第" + wed.get(position).getBgmcount() + "话");
                String[] str = wed.get(position).getLastupdate_at().split(" ");
                holder.tv_date.setText(str[1]);
            } else if (thur != null) {
                Glide.with(BaseApplication.getInstance()).
                        load(thur.get(position).getCover())
                        .placeholder(R.drawable.bili_drawerbg_logined)
                        .centerCrop()
                        .crossFade()
                        .skipMemoryCache(true)
                        .diskCacheStrategy(DiskCacheStrategy.RESULT)
                        .into(holder.iv_pic);
                holder.tv_name.setText(thur.get(position).getTitle());
                holder.tv_num.setText("第" + thur.get(position).getBgmcount() + "话");
                String[] str = thur.get(position).getLastupdate_at().split(" ");
                holder.tv_date.setText(str[1]);
            } else if (fri != null) {
                Glide.with(BaseApplication.getInstance()).
                        load(fri.get(position).getCover())
                        .placeholder(R.drawable.bili_drawerbg_logined)
                        .centerCrop()
                        .crossFade()
                        .skipMemoryCache(true)
                        .diskCacheStrategy(DiskCacheStrategy.RESULT)
                        .into(holder.iv_pic);
                holder.tv_name.setText(fri.get(position).getTitle());
                holder.tv_num.setText("第" + fri.get(position).getBgmcount() + "话");
                String[] str = fri.get(position).getLastupdate_at().split(" ");
                holder.tv_date.setText(str[1]);
            } else if (sat != null) {
                Glide.with(BaseApplication.getInstance()).
                        load(sat.get(position).getCover())
                        .placeholder(R.drawable.bili_drawerbg_logined)
                        .centerCrop()
                        .crossFade()
                        .skipMemoryCache(true)
                        .diskCacheStrategy(DiskCacheStrategy.RESULT)
                        .into(holder.iv_pic);
                holder.tv_name.setText(sat.get(position).getTitle());
                holder.tv_num.setText("第" + sat.get(position).getBgmcount() + "话");
                String[] str = sat.get(position).getLastupdate_at().split(" ");
                holder.tv_date.setText(str[1]);
            }
            if (flag) {
                Glide.with(BaseApplication.getInstance()).
                        load(imgPath.get(position))
                        .placeholder(R.drawable.bili_drawerbg_logined)
                        .centerCrop()
                        .crossFade()
                        .skipMemoryCache(true)
                        .diskCacheStrategy(DiskCacheStrategy.RESULT)
                        .into(holder.iv_pic);
                holder.tv_name.setText(titles.get(position));
                //从title中提取出第几话
                String reg = "\\d{2,3}";
                Pattern pattern = Pattern.compile(reg);
                Matcher matcher = pattern.matcher(titles.get(position));
                if (matcher.find()) {
                    holder.tv_num.setText("第" + matcher.group(0).toString() + "话");
                    //LogUtil.i("Pan",matcher.group(0));

                    String[] str = date.get(position).split(" ");
                    holder.tv_date.setText(str[1]);
                }

            }
        }
        return convertView;
    }
}

