package com.tongming.materialbili.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * 番剧实例
 * Created by Tongming on 2016/3/23.
 */
public class Bangumi {
    
    @SerializedName("0")
    private List<Sunday> sundays;
    @SerializedName("1")
    private List<Monday> mondays;
    @SerializedName("2")
    private List<Tuesday> tuesdays;
    @SerializedName("3")
    private List<Wednesday> wednesdays;
    @SerializedName("4")
    private List<Thursday> thursdays;
    @SerializedName("5")
    private List<Friday> fridays;
    @SerializedName("6")
    private List<Saturday> saturdays;

    public List<Sunday> getsundays() {
        return sundays;
    }

    public void setsundays(List<Sunday> sundays) {
        this.sundays = sundays;
    }

    public List<Monday> getmondays() {
        return mondays;
    }

    public void setmondays(List<Monday> mondays) {
        this.mondays = mondays;
    }

    public List<Tuesday> gettuesdays() {
        return tuesdays;
    }

    public void settuesdays(List<Tuesday> tuesdays) {
        this.tuesdays = tuesdays;
    }

    public List<Wednesday> getwednesdays() {
        return wednesdays;
    }

    public void setwednesdays(List<Wednesday> wednesdays) {
        this.wednesdays = wednesdays;
    }

    public List<Thursday> getthursdays() {
        return thursdays;
    }

    public void setthursdays(List<Thursday> thursdays) {
        this.thursdays = thursdays;
    }

    public List<Friday> getfridays() {
        return fridays;
    }

    public void setfridays(List<Friday> fridays) {
        this.fridays = fridays;
    }

    public List<Saturday> getsaturdays() {
        return saturdays;
    }

    public void setsaturdays(List<Saturday> saturdays) {
        this.saturdays = saturdays;
    }

    public static class Sunday {
        private String area;
        private int arealimit;
        private int attention;
        private int bangumi_id;
        private String bgmcount;
        private Object brief;
        private String cover;
        private int danmaku_count;
        private int favorites;
        private int is_finish;
        private int lastupdate;
        private String lastupdate_at;
        @SerializedName("new")
        private boolean newX;
        private int play_count;
        private String pub_time;
        private String season_id;
        private int spid;
        private String square_cover;
        private String title;
        private String url;
        private int weekday;

        public String getArea() {
            return area;
        }

        public void setArea(String area) {
            this.area = area;
        }

        public int getArealimit() {
            return arealimit;
        }

        public void setArealimit(int arealimit) {
            this.arealimit = arealimit;
        }

        public int getAttention() {
            return attention;
        }

        public void setAttention(int attention) {
            this.attention = attention;
        }

        public int getBangumi_id() {
            return bangumi_id;
        }

        public void setBangumi_id(int bangumi_id) {
            this.bangumi_id = bangumi_id;
        }

        public String getBgmcount() {
            return bgmcount;
        }

        public void setBgmcount(String bgmcount) {
            this.bgmcount = bgmcount;
        }

        public Object getBrief() {
            return brief;
        }

        public void setBrief(Object brief) {
            this.brief = brief;
        }

        public String getCover() {
            return cover;
        }

        public void setCover(String cover) {
            this.cover = cover;
        }

        public int getDanmaku_count() {
            return danmaku_count;
        }

        public void setDanmaku_count(int danmaku_count) {
            this.danmaku_count = danmaku_count;
        }

        public int getFavorites() {
            return favorites;
        }

        public void setFavorites(int favorites) {
            this.favorites = favorites;
        }

        public int getIs_finish() {
            return is_finish;
        }

        public void setIs_finish(int is_finish) {
            this.is_finish = is_finish;
        }

        public int getLastupdate() {
            return lastupdate;
        }

        public void setLastupdate(int lastupdate) {
            this.lastupdate = lastupdate;
        }

        public String getLastupdate_at() {
            return lastupdate_at;
        }

        public void setLastupdate_at(String lastupdate_at) {
            this.lastupdate_at = lastupdate_at;
        }

        public boolean isNewX() {
            return newX;
        }

        public void setNewX(boolean newX) {
            this.newX = newX;
        }

        public int getPlay_count() {
            return play_count;
        }

        public void setPlay_count(int play_count) {
            this.play_count = play_count;
        }

        public String getPub_time() {
            return pub_time;
        }

        public void setPub_time(String pub_time) {
            this.pub_time = pub_time;
        }

        public String getSeason_id() {
            return season_id;
        }

        public void setSeason_id(String season_id) {
            this.season_id = season_id;
        }

        public int getSpid() {
            return spid;
        }

        public void setSpid(int spid) {
            this.spid = spid;
        }

        public String getSquare_cover() {
            return square_cover;
        }

        public void setSquare_cover(String square_cover) {
            this.square_cover = square_cover;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public int getWeekday() {
            return weekday;
        }

        public void setWeekday(int weekday) {
            this.weekday = weekday;
        }
    }

    public static class Monday {
        private String area;
        private int arealimit;
        private int attention;
        private int bangumi_id;
        private String bgmcount;
        private Object brief;
        private String cover;
        private int danmaku_count;
        private int favorites;
        private int is_finish;
        private int lastupdate;
        private String lastupdate_at;
        @SerializedName("new")
        private boolean newX;
        private int play_count;
        private String pub_time;
        private String season_id;
        private int spid;
        private String square_cover;
        private String title;
        private String url;
        private int weekday;

        public String getArea() {
            return area;
        }

        public void setArea(String area) {
            this.area = area;
        }

        public int getArealimit() {
            return arealimit;
        }

        public void setArealimit(int arealimit) {
            this.arealimit = arealimit;
        }

        public int getAttention() {
            return attention;
        }

        public void setAttention(int attention) {
            this.attention = attention;
        }

        public int getBangumi_id() {
            return bangumi_id;
        }

        public void setBangumi_id(int bangumi_id) {
            this.bangumi_id = bangumi_id;
        }

        public String getBgmcount() {
            return bgmcount;
        }

        public void setBgmcount(String bgmcount) {
            this.bgmcount = bgmcount;
        }

        public Object getBrief() {
            return brief;
        }

        public void setBrief(Object brief) {
            this.brief = brief;
        }

        public String getCover() {
            return cover;
        }

        public void setCover(String cover) {
            this.cover = cover;
        }

        public int getDanmaku_count() {
            return danmaku_count;
        }

        public void setDanmaku_count(int danmaku_count) {
            this.danmaku_count = danmaku_count;
        }

        public int getFavorites() {
            return favorites;
        }

        public void setFavorites(int favorites) {
            this.favorites = favorites;
        }

        public int getIs_finish() {
            return is_finish;
        }

        public void setIs_finish(int is_finish) {
            this.is_finish = is_finish;
        }

        public int getLastupdate() {
            return lastupdate;
        }

        public void setLastupdate(int lastupdate) {
            this.lastupdate = lastupdate;
        }

        public String getLastupdate_at() {
            return lastupdate_at;
        }

        public void setLastupdate_at(String lastupdate_at) {
            this.lastupdate_at = lastupdate_at;
        }

        public boolean isNewX() {
            return newX;
        }

        public void setNewX(boolean newX) {
            this.newX = newX;
        }

        public int getPlay_count() {
            return play_count;
        }

        public void setPlay_count(int play_count) {
            this.play_count = play_count;
        }

        public String getPub_time() {
            return pub_time;
        }

        public void setPub_time(String pub_time) {
            this.pub_time = pub_time;
        }

        public String getSeason_id() {
            return season_id;
        }

        public void setSeason_id(String season_id) {
            this.season_id = season_id;
        }

        public int getSpid() {
            return spid;
        }

        public void setSpid(int spid) {
            this.spid = spid;
        }

        public String getSquare_cover() {
            return square_cover;
        }

        public void setSquare_cover(String square_cover) {
            this.square_cover = square_cover;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public int getWeekday() {
            return weekday;
        }

        public void setWeekday(int weekday) {
            this.weekday = weekday;
        }
    }

    public static class Tuesday {
        private String area;
        private int arealimit;
        private int attention;
        private int bangumi_id;
        private String bgmcount;
        private Object brief;
        private String cover;
        private int danmaku_count;
        private int favorites;
        private int is_finish;
        private int lastupdate;
        private String lastupdate_at;
        @SerializedName("new")
        private boolean newX;
        private int play_count;
        private String pub_time;
        private String season_id;
        private int spid;
        private String square_cover;
        private String title;
        private String url;
        private int weekday;

        public String getArea() {
            return area;
        }

        public void setArea(String area) {
            this.area = area;
        }

        public int getArealimit() {
            return arealimit;
        }

        public void setArealimit(int arealimit) {
            this.arealimit = arealimit;
        }

        public int getAttention() {
            return attention;
        }

        public void setAttention(int attention) {
            this.attention = attention;
        }

        public int getBangumi_id() {
            return bangumi_id;
        }

        public void setBangumi_id(int bangumi_id) {
            this.bangumi_id = bangumi_id;
        }

        public String getBgmcount() {
            return bgmcount;
        }

        public void setBgmcount(String bgmcount) {
            this.bgmcount = bgmcount;
        }

        public Object getBrief() {
            return brief;
        }

        public void setBrief(Object brief) {
            this.brief = brief;
        }

        public String getCover() {
            return cover;
        }

        public void setCover(String cover) {
            this.cover = cover;
        }

        public int getDanmaku_count() {
            return danmaku_count;
        }

        public void setDanmaku_count(int danmaku_count) {
            this.danmaku_count = danmaku_count;
        }

        public int getFavorites() {
            return favorites;
        }

        public void setFavorites(int favorites) {
            this.favorites = favorites;
        }

        public int getIs_finish() {
            return is_finish;
        }

        public void setIs_finish(int is_finish) {
            this.is_finish = is_finish;
        }

        public int getLastupdate() {
            return lastupdate;
        }

        public void setLastupdate(int lastupdate) {
            this.lastupdate = lastupdate;
        }

        public String getLastupdate_at() {
            return lastupdate_at;
        }

        public void setLastupdate_at(String lastupdate_at) {
            this.lastupdate_at = lastupdate_at;
        }

        public boolean isNewX() {
            return newX;
        }

        public void setNewX(boolean newX) {
            this.newX = newX;
        }

        public int getPlay_count() {
            return play_count;
        }

        public void setPlay_count(int play_count) {
            this.play_count = play_count;
        }

        public String getPub_time() {
            return pub_time;
        }

        public void setPub_time(String pub_time) {
            this.pub_time = pub_time;
        }

        public String getSeason_id() {
            return season_id;
        }

        public void setSeason_id(String season_id) {
            this.season_id = season_id;
        }

        public int getSpid() {
            return spid;
        }

        public void setSpid(int spid) {
            this.spid = spid;
        }

        public String getSquare_cover() {
            return square_cover;
        }

        public void setSquare_cover(String square_cover) {
            this.square_cover = square_cover;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public int getWeekday() {
            return weekday;
        }

        public void setWeekday(int weekday) {
            this.weekday = weekday;
        }
    }

    public static class Wednesday {
        private String area;
        private int arealimit;
        private int attention;
        private int bangumi_id;
        private String bgmcount;
        private Object brief;
        private String cover;
        private int danmaku_count;
        private int favorites;
        private int is_finish;
        private int lastupdate;
        private String lastupdate_at;
        @SerializedName("new")
        private boolean newX;
        private int play_count;
        private String pub_time;
        private String season_id;
        private int spid;
        private String square_cover;
        private String title;
        private String url;
        private int weekday;

        public String getArea() {
            return area;
        }

        public void setArea(String area) {
            this.area = area;
        }

        public int getArealimit() {
            return arealimit;
        }

        public void setArealimit(int arealimit) {
            this.arealimit = arealimit;
        }

        public int getAttention() {
            return attention;
        }

        public void setAttention(int attention) {
            this.attention = attention;
        }

        public int getBangumi_id() {
            return bangumi_id;
        }

        public void setBangumi_id(int bangumi_id) {
            this.bangumi_id = bangumi_id;
        }

        public String getBgmcount() {
            return bgmcount;
        }

        public void setBgmcount(String bgmcount) {
            this.bgmcount = bgmcount;
        }

        public Object getBrief() {
            return brief;
        }

        public void setBrief(Object brief) {
            this.brief = brief;
        }

        public String getCover() {
            return cover;
        }

        public void setCover(String cover) {
            this.cover = cover;
        }

        public int getDanmaku_count() {
            return danmaku_count;
        }

        public void setDanmaku_count(int danmaku_count) {
            this.danmaku_count = danmaku_count;
        }

        public int getFavorites() {
            return favorites;
        }

        public void setFavorites(int favorites) {
            this.favorites = favorites;
        }

        public int getIs_finish() {
            return is_finish;
        }

        public void setIs_finish(int is_finish) {
            this.is_finish = is_finish;
        }

        public int getLastupdate() {
            return lastupdate;
        }

        public void setLastupdate(int lastupdate) {
            this.lastupdate = lastupdate;
        }

        public String getLastupdate_at() {
            return lastupdate_at;
        }

        public void setLastupdate_at(String lastupdate_at) {
            this.lastupdate_at = lastupdate_at;
        }

        public boolean isNewX() {
            return newX;
        }

        public void setNewX(boolean newX) {
            this.newX = newX;
        }

        public int getPlay_count() {
            return play_count;
        }

        public void setPlay_count(int play_count) {
            this.play_count = play_count;
        }

        public String getPub_time() {
            return pub_time;
        }

        public void setPub_time(String pub_time) {
            this.pub_time = pub_time;
        }

        public String getSeason_id() {
            return season_id;
        }

        public void setSeason_id(String season_id) {
            this.season_id = season_id;
        }

        public int getSpid() {
            return spid;
        }

        public void setSpid(int spid) {
            this.spid = spid;
        }

        public String getSquare_cover() {
            return square_cover;
        }

        public void setSquare_cover(String square_cover) {
            this.square_cover = square_cover;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public int getWeekday() {
            return weekday;
        }

        public void setWeekday(int weekday) {
            this.weekday = weekday;
        }
    }

    public static class Thursday {
        private String area;
        private int arealimit;
        private int attention;
        private int bangumi_id;
        private String bgmcount;
        private Object brief;
        private String cover;
        private int danmaku_count;
        private int favorites;
        private int is_finish;
        private int lastupdate;
        private String lastupdate_at;
        @SerializedName("new")
        private boolean newX;
        private int play_count;
        private String pub_time;
        private String season_id;
        private int spid;
        private String square_cover;
        private String title;
        private String url;
        private int weekday;

        public String getArea() {
            return area;
        }

        public void setArea(String area) {
            this.area = area;
        }

        public int getArealimit() {
            return arealimit;
        }

        public void setArealimit(int arealimit) {
            this.arealimit = arealimit;
        }

        public int getAttention() {
            return attention;
        }

        public void setAttention(int attention) {
            this.attention = attention;
        }

        public int getBangumi_id() {
            return bangumi_id;
        }

        public void setBangumi_id(int bangumi_id) {
            this.bangumi_id = bangumi_id;
        }

        public String getBgmcount() {
            return bgmcount;
        }

        public void setBgmcount(String bgmcount) {
            this.bgmcount = bgmcount;
        }

        public Object getBrief() {
            return brief;
        }

        public void setBrief(Object brief) {
            this.brief = brief;
        }

        public String getCover() {
            return cover;
        }

        public void setCover(String cover) {
            this.cover = cover;
        }

        public int getDanmaku_count() {
            return danmaku_count;
        }

        public void setDanmaku_count(int danmaku_count) {
            this.danmaku_count = danmaku_count;
        }

        public int getFavorites() {
            return favorites;
        }

        public void setFavorites(int favorites) {
            this.favorites = favorites;
        }

        public int getIs_finish() {
            return is_finish;
        }

        public void setIs_finish(int is_finish) {
            this.is_finish = is_finish;
        }

        public int getLastupdate() {
            return lastupdate;
        }

        public void setLastupdate(int lastupdate) {
            this.lastupdate = lastupdate;
        }

        public String getLastupdate_at() {
            return lastupdate_at;
        }

        public void setLastupdate_at(String lastupdate_at) {
            this.lastupdate_at = lastupdate_at;
        }

        public boolean isNewX() {
            return newX;
        }

        public void setNewX(boolean newX) {
            this.newX = newX;
        }

        public int getPlay_count() {
            return play_count;
        }

        public void setPlay_count(int play_count) {
            this.play_count = play_count;
        }

        public String getPub_time() {
            return pub_time;
        }

        public void setPub_time(String pub_time) {
            this.pub_time = pub_time;
        }

        public String getSeason_id() {
            return season_id;
        }

        public void setSeason_id(String season_id) {
            this.season_id = season_id;
        }

        public int getSpid() {
            return spid;
        }

        public void setSpid(int spid) {
            this.spid = spid;
        }

        public String getSquare_cover() {
            return square_cover;
        }

        public void setSquare_cover(String square_cover) {
            this.square_cover = square_cover;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public int getWeekday() {
            return weekday;
        }

        public void setWeekday(int weekday) {
            this.weekday = weekday;
        }
    }

    public static class Friday {
        private String area;
        private int arealimit;
        private int attention;
        private int bangumi_id;
        private String bgmcount;
        private Object brief;
        private String cover;
        private int danmaku_count;
        private int favorites;
        private int is_finish;
        private int lastupdate;
        private String lastupdate_at;
        @SerializedName("new")
        private boolean newX;
        private int play_count;
        private String pub_time;
        private String season_id;
        private int spid;
        private String square_cover;
        private String title;
        private String url;
        private int weekday;

        public String getArea() {
            return area;
        }

        public void setArea(String area) {
            this.area = area;
        }

        public int getArealimit() {
            return arealimit;
        }

        public void setArealimit(int arealimit) {
            this.arealimit = arealimit;
        }

        public int getAttention() {
            return attention;
        }

        public void setAttention(int attention) {
            this.attention = attention;
        }

        public int getBangumi_id() {
            return bangumi_id;
        }

        public void setBangumi_id(int bangumi_id) {
            this.bangumi_id = bangumi_id;
        }

        public String getBgmcount() {
            return bgmcount;
        }

        public void setBgmcount(String bgmcount) {
            this.bgmcount = bgmcount;
        }

        public Object getBrief() {
            return brief;
        }

        public void setBrief(Object brief) {
            this.brief = brief;
        }

        public String getCover() {
            return cover;
        }

        public void setCover(String cover) {
            this.cover = cover;
        }

        public int getDanmaku_count() {
            return danmaku_count;
        }

        public void setDanmaku_count(int danmaku_count) {
            this.danmaku_count = danmaku_count;
        }

        public int getFavorites() {
            return favorites;
        }

        public void setFavorites(int favorites) {
            this.favorites = favorites;
        }

        public int getIs_finish() {
            return is_finish;
        }

        public void setIs_finish(int is_finish) {
            this.is_finish = is_finish;
        }

        public int getLastupdate() {
            return lastupdate;
        }

        public void setLastupdate(int lastupdate) {
            this.lastupdate = lastupdate;
        }

        public String getLastupdate_at() {
            return lastupdate_at;
        }

        public void setLastupdate_at(String lastupdate_at) {
            this.lastupdate_at = lastupdate_at;
        }

        public boolean isNewX() {
            return newX;
        }

        public void setNewX(boolean newX) {
            this.newX = newX;
        }

        public int getPlay_count() {
            return play_count;
        }

        public void setPlay_count(int play_count) {
            this.play_count = play_count;
        }

        public String getPub_time() {
            return pub_time;
        }

        public void setPub_time(String pub_time) {
            this.pub_time = pub_time;
        }

        public String getSeason_id() {
            return season_id;
        }

        public void setSeason_id(String season_id) {
            this.season_id = season_id;
        }

        public int getSpid() {
            return spid;
        }

        public void setSpid(int spid) {
            this.spid = spid;
        }

        public String getSquare_cover() {
            return square_cover;
        }

        public void setSquare_cover(String square_cover) {
            this.square_cover = square_cover;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public int getWeekday() {
            return weekday;
        }

        public void setWeekday(int weekday) {
            this.weekday = weekday;
        }
    }

    public static class Saturday {
        private String area;
        private int arealimit;
        private int attention;
        private int bangumi_id;
        private String bgmcount;
        private Object brief;
        private String cover;
        private int danmaku_count;
        private int favorites;
        private int is_finish;
        private int lastupdate;
        private String lastupdate_at;
        @SerializedName("new")
        private boolean newX;
        private int play_count;
        private String pub_time;
        private String season_id;
        private int spid;
        private String square_cover;
        private String title;
        private String url;
        private int weekday;

        public String getArea() {
            return area;
        }

        public void setArea(String area) {
            this.area = area;
        }

        public int getArealimit() {
            return arealimit;
        }

        public void setArealimit(int arealimit) {
            this.arealimit = arealimit;
        }

        public int getAttention() {
            return attention;
        }

        public void setAttention(int attention) {
            this.attention = attention;
        }

        public int getBangumi_id() {
            return bangumi_id;
        }

        public void setBangumi_id(int bangumi_id) {
            this.bangumi_id = bangumi_id;
        }

        public String getBgmcount() {
            return bgmcount;
        }

        public void setBgmcount(String bgmcount) {
            this.bgmcount = bgmcount;
        }

        public Object getBrief() {
            return brief;
        }

        public void setBrief(Object brief) {
            this.brief = brief;
        }

        public String getCover() {
            return cover;
        }

        public void setCover(String cover) {
            this.cover = cover;
        }

        public int getDanmaku_count() {
            return danmaku_count;
        }

        public void setDanmaku_count(int danmaku_count) {
            this.danmaku_count = danmaku_count;
        }

        public int getFavorites() {
            return favorites;
        }

        public void setFavorites(int favorites) {
            this.favorites = favorites;
        }

        public int getIs_finish() {
            return is_finish;
        }

        public void setIs_finish(int is_finish) {
            this.is_finish = is_finish;
        }

        public int getLastupdate() {
            return lastupdate;
        }

        public void setLastupdate(int lastupdate) {
            this.lastupdate = lastupdate;
        }

        public String getLastupdate_at() {
            return lastupdate_at;
        }

        public void setLastupdate_at(String lastupdate_at) {
            this.lastupdate_at = lastupdate_at;
        }

        public boolean isNewX() {
            return newX;
        }

        public void setNewX(boolean newX) {
            this.newX = newX;
        }

        public int getPlay_count() {
            return play_count;
        }

        public void setPlay_count(int play_count) {
            this.play_count = play_count;
        }

        public String getPub_time() {
            return pub_time;
        }

        public void setPub_time(String pub_time) {
            this.pub_time = pub_time;
        }

        public String getSeason_id() {
            return season_id;
        }

        public void setSeason_id(String season_id) {
            this.season_id = season_id;
        }

        public int getSpid() {
            return spid;
        }

        public void setSpid(int spid) {
            this.spid = spid;
        }

        public String getSquare_cover() {
            return square_cover;
        }

        public void setSquare_cover(String square_cover) {
            this.square_cover = square_cover;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public int getWeekday() {
            return weekday;
        }

        public void setWeekday(int weekday) {
            this.weekday = weekday;
        }
    }
}
