package com.tongming.materialbili.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.tongming.materialbili.R;
import com.tongming.materialbili.base.BaseApplication;

/**
 * Created by Tongming on 2016/3/3.
 */
public class IconGridAdapter extends BaseAdapter {
    private String[] mItems ;
    private int[] imagesId ;

    public IconGridAdapter(String[] mItems, int[] imagesId) {
        this.mItems = mItems;
        this.imagesId = imagesId;
    }

    @Override
    public int getCount() {
        return mItems.length;
    }

    @Override
    public Object getItem(int position) {
        return mItems[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = View.inflate(BaseApplication.getInstance(), R.layout.item_grid,null);
        ImageView iv_item = (ImageView) convertView.findViewById(R.id.iv_item);
        TextView tv_item = (TextView) convertView.findViewById(R.id.tv_item);
        iv_item.setImageResource(imagesId[position]);
        tv_item.setText(mItems[position]);
        return convertView;
    }
}
