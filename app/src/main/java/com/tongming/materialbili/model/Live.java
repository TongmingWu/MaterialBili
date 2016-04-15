package com.tongming.materialbili.model;

import java.util.List;

/**
 * Created by Tongming on 2016/3/26.
 */
class Live {

    private List<LiveInfo> data;

    public List<LiveInfo> getData() {
        return data;
    }

    public void setData(List<LiveInfo> data) {
        this.data = data;
    }

    public static class LiveInfo {
        private String roomid;
        private String short_id;
        private String uname;
        private String uid;
        private String area;
        private String title;
        private String cover;
        private String live_time;
        private int online;
        private String user_cover;
        private String face;
        private int master_level;
        private String link;

        public String getRoomid() {
            return roomid;
        }

        public void setRoomid(String roomid) {
            this.roomid = roomid;
        }

        public String getShort_id() {
            return short_id;
        }

        public void setShort_id(String short_id) {
            this.short_id = short_id;
        }

        public String getUname() {
            return uname;
        }

        public void setUname(String uname) {
            this.uname = uname;
        }

        public String getUid() {
            return uid;
        }

        public void setUid(String uid) {
            this.uid = uid;
        }

        public String getArea() {
            return area;
        }

        public void setArea(String area) {
            this.area = area;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getCover() {
            return cover;
        }

        public void setCover(String cover) {
            this.cover = cover;
        }

        public String getLive_time() {
            return live_time;
        }

        public void setLive_time(String live_time) {
            this.live_time = live_time;
        }

        public int getOnline() {
            return online;
        }

        public void setOnline(int online) {
            this.online = online;
        }

        public String getUser_cover() {
            return user_cover;
        }

        public void setUser_cover(String user_cover) {
            this.user_cover = user_cover;
        }

        public String getFace() {
            return face;
        }

        public void setFace(String face) {
            this.face = face;
        }

        public int getMaster_level() {
            return master_level;
        }

        public void setMaster_level(int master_level) {
            this.master_level = master_level;
        }

        public String getLink() {
            return link;
        }

        public void setLink(String link) {
            this.link = link;
        }
    }
}
