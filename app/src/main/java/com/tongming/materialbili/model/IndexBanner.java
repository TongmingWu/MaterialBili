package com.tongming.materialbili.model;

import java.util.List;

/**
 * 首页轮播图实例
 * Created by Tongming on 2016/3/14.
 */
public class IndexBanner{

    private List<Banner> banners;

    public void setBanners(List<Banner> banners) {
        this.banners = banners;
    }

    public List<Banner> getBanners() {
        return banners;
    }

    public static class Banner {
        private int aid;
        private String img;
        private String link;
        private int pid;
        private int platform;
        private String simg;
        private String title;
        private String type;

        public void setAid(int aid) {
            this.aid = aid;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public void setLink(String link) {
            this.link = link;
        }

        public void setPid(int pid) {
            this.pid = pid;
        }

        public void setPlatform(int platform) {
            this.platform = platform;
        }

        public void setSimg(String simg) {
            this.simg = simg;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public void setType(String type) {
            this.type = type;
        }

        public int getAid() {
            return aid;
        }

        public String getImg() {
            return img;
        }

        public String getLink() {
            return link;
        }

        public int getPid() {
            return pid;
        }

        public int getPlatform() {
            return platform;
        }

        public String getSimg() {
            return simg;
        }

        public String getTitle() {
            return title;
        }

        public String getType() {
            return type;
        }
    }
}
