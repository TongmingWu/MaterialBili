package com.tongming.materialbili.model;

import java.util.List;

/**
 * Created by Tongming on 2016/4/23.
 */
public class LiveDanmaku {

    private int code;
    private String msg;
    private DataEntity data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public DataEntity getData() {
        return data;
    }

    public void setData(DataEntity data) {
        this.data = data;
    }

    public static class DataEntity {

        private List<RoomEntity> room;

        private List<AdminEntity> admin;

        public List<RoomEntity> getRoom() {
            return room;
        }

        public void setRoom(List<RoomEntity> room) {
            this.room = room;
        }

        public List<AdminEntity> getAdmin() {
            return admin;
        }

        public void setAdmin(List<AdminEntity> admin) {
            this.admin = admin;
        }

        public static class RoomEntity {
            private String text;
            private int uid;
            private String nickname;
            private String timeline;
            private int isadmin;
            private int vip;
            private int svip;
            private String rnd;
            private List<Integer> medal;
            private List<?> title;
            private List<Integer> user_level;

            public String getText() {
                return text;
            }

            public void setText(String text) {
                this.text = text;
            }

            public int getUid() {
                return uid;
            }

            public void setUid(int uid) {
                this.uid = uid;
            }

            public String getNickname() {
                return nickname;
            }

            public void setNickname(String nickname) {
                this.nickname = nickname;
            }

            public String getTimeline() {
                return timeline;
            }

            public void setTimeline(String timeline) {
                this.timeline = timeline;
            }

            public int getIsadmin() {
                return isadmin;
            }

            public void setIsadmin(int isadmin) {
                this.isadmin = isadmin;
            }

            public int getVip() {
                return vip;
            }

            public void setVip(int vip) {
                this.vip = vip;
            }

            public int getSvip() {
                return svip;
            }

            public void setSvip(int svip) {
                this.svip = svip;
            }

            public String getRnd() {
                return rnd;
            }

            public void setRnd(String rnd) {
                this.rnd = rnd;
            }

            public List<Integer> getMedal() {
                return medal;
            }

            public void setMedal(List<Integer> medal) {
                this.medal = medal;
            }

            public List<?> getTitle() {
                return title;
            }

            public void setTitle(List<?> title) {
                this.title = title;
            }

            public List<Integer> getUser_level() {
                return user_level;
            }

            public void setUser_level(List<Integer> user_level) {
                this.user_level = user_level;
            }
        }

        public static class AdminEntity {
            private String text;
            private int uid;
            private String nickname;
            private String timeline;
            private int isadmin;
            private int vip;
            private int svip;
            private String rnd;
            private List<Integer> medal;
            private List<?> title;
            private List<Integer> user_level;

            public String getText() {
                return text;
            }

            public void setText(String text) {
                this.text = text;
            }

            public int getUid() {
                return uid;
            }

            public void setUid(int uid) {
                this.uid = uid;
            }

            public String getNickname() {
                return nickname;
            }

            public void setNickname(String nickname) {
                this.nickname = nickname;
            }

            public String getTimeline() {
                return timeline;
            }

            public void setTimeline(String timeline) {
                this.timeline = timeline;
            }

            public int getIsadmin() {
                return isadmin;
            }

            public void setIsadmin(int isadmin) {
                this.isadmin = isadmin;
            }

            public int getVip() {
                return vip;
            }

            public void setVip(int vip) {
                this.vip = vip;
            }

            public int getSvip() {
                return svip;
            }

            public void setSvip(int svip) {
                this.svip = svip;
            }

            public String getRnd() {
                return rnd;
            }

            public void setRnd(String rnd) {
                this.rnd = rnd;
            }

            public List<Integer> getMedal() {
                return medal;
            }

            public void setMedal(List<Integer> medal) {
                this.medal = medal;
            }

            public List<?> getTitle() {
                return title;
            }

            public void setTitle(List<?> title) {
                this.title = title;
            }

            public List<Integer> getUser_level() {
                return user_level;
            }

            public void setUser_level(List<Integer> user_level) {
                this.user_level = user_level;
            }
        }
    }
}
