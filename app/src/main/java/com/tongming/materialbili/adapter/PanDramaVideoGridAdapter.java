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
        return imgPath.size();
    }

    @Override
    public Object getItem(int position) {
        return imgPath.get(position);
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
        Glide.with(BaseApplication.getInstance()).
                load(imgPath.get(position))
                .placeholder(R.drawable.bili_drawerbg_logined)
                .centerCrop()
                .crossFade()
                .skipMemoryCache(true)
                .diskCacheStrategy(DiskCacheStrategy.RESULT)
                .into(holder.iv_pic);
        holder.tv_name.setText(titles.get(position));
        if (flag) {
            //从title中提取出第几话
            String reg = "\\d{2,3}";
            Pattern pattern = Pattern.compile(reg);
            Matcher matcher = pattern.matcher(titles.get(position));
            if (matcher.find()) {
                holder.tv_num.setText("第" + matcher.group(0).toString() + "话");
                //LogUtil.i("Pan",matcher.group(0));
            }
        } else {
            holder.tv_num.setText("第" + count.get(position) + "话");
        }
        String[] str = date.get(position).split(" ");
        holder.tv_date.setText(str[1]);
        return convertView;
    }
}
