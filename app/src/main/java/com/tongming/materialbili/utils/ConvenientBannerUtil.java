package com.tongming.materialbili.utils;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;
import com.bigkoo.convenientbanner.holder.Holder;
import com.tongming.materialbili.R;

import java.util.ArrayList;

/**
 * 轮播图工具类
 * Created by Tongming on 2016/3/3.
 */
public class ConvenientBannerUtil {
    private final ConvenientBanner convenientBanner;
    private ArrayList<Integer> localImages;
    private int[] imagesId;
    public ConvenientBannerUtil(ArrayList<Integer> localImages, int[] imagesId,ConvenientBanner convenientBanner) {
        this.localImages = localImages;
        this.imagesId = imagesId;
        this.convenientBanner = convenientBanner;
        init();
    }

    private void init() {
        loadLocalData();
        convenientBanner.setPages(new CBViewHolderCreator() {
            @Override
            public LocalImageHolderView createHolder() {
                return new LocalImageHolderView();
            }
        }, localImages)
                //设置点作为翻页显示器
                .setPageIndicator(new int[]{R.drawable.point_bg_normal, R.drawable.point_bg_enable})
                //设置指示器的方向
                .setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.ALIGN_PARENT_RIGHT);
    }
    private void loadLocalData(){
        //本地图片集合
        for(int position : imagesId){
            localImages.add(position);
        }
    }
    public class LocalImageHolderView implements Holder<Integer> {
        private ImageView imageView;

        @Override
        public View createView(Context context) {
            imageView = new ImageView(context);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            return imageView;
        }

        @Override
        public void UpdateUI(Context context, int position, Integer data) {
            imageView.setImageResource(data);
        }
    }
}
