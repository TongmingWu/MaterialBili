package com.tongming.materialbili.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Tongming on 2016/3/7.
 */
public class HotVideo implements Serializable{

    @SerializedName("动画")
    private List<AnimeVideo> animeVideos;
    @SerializedName("娱乐")
    private List<FunnyVideo> funnyVideos;
    @SerializedName("游戏")
    private List<GameVideo> gameVideos;
    @SerializedName("电影")
    private List<Movie> movies;
    @SerializedName("电视剧")
    private List<TV> tvs;
    @SerializedName("番剧")
    private List<PanDrama> panDramas;
    @SerializedName("科技")
    private List<TechnologyVideo> technologyVideos;
    @SerializedName("舞蹈")
    private List<DanceVideo> danceVideos;
    @SerializedName("音乐")
    private List<Music> musics;
    @SerializedName("鬼畜")
    private List<GhotVideo> ghotVideos;


    public void setanimeVideos(List<AnimeVideo> animeVideos) {
        this.animeVideos = animeVideos;
    }

    public void setfunnyVideos(List<FunnyVideo> funnyVideos) {
        this.funnyVideos = funnyVideos;
    }

    public void setgameVideos(List<GameVideo> gameVideos) {
        this.gameVideos = gameVideos;
    }

    public void setmovies(List<Movie> movies) {
        this.movies = movies;
    }

    public void settvs(List<TV> tvs) {
        this.tvs = tvs;
    }

    public void setpanDramas(List<PanDrama> panDramas) {
        this.panDramas = panDramas;
    }

    public void settechnologyVideos(List<TechnologyVideo> technologyVideos) {
        this.technologyVideos = technologyVideos;
    }

    public void setdanceVideos(List<DanceVideo> danceVideos) {
        this.danceVideos = danceVideos;
    }

    public void setmusics(List<Music> musics) {
        this.musics = musics;
    }

    public void setghotVideos(List<GhotVideo> ghotVideos) {
        this.ghotVideos = ghotVideos;
    }

    public List<AnimeVideo> getanimeVideos() {
        return animeVideos;
    }

    public List<FunnyVideo> getfunnyVideos() {
        return funnyVideos;
    }

    public List<GameVideo> getgameVideos() {
        return gameVideos;
    }

    public List<Movie> getmovies() {
        return movies;
    }

    public List<TV> gettvs() {
        return tvs;
    }

    public List<PanDrama> getpanDramas() {
        return panDramas;
    }

    public List<TechnologyVideo> gettechnologyVideos() {
        return technologyVideos;
    }

    public List<DanceVideo> getdanceVideos() {
        return danceVideos;
    }

    public List<Music> getmusics() {
        return musics;
    }

    public List<GhotVideo> getghotVideos() {
        return ghotVideos;
    }

    public static class AnimeVideo {
        private String aid;
        private String author;
        private boolean badgepay;
        private int coins;
        private int comment;
        private String copyright;
        private String create;
        private int credit;
        private String description;
        private String duration;
        private int favorites;
        private int mid;
        private String pic;
        private String play;
        private String review;
        private String subtitle;
        private String title;
        private String typeid;
        private String typename;
        private String video_review;

        public void setAid(String aid) {
            this.aid = aid;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public void setBadgepay(boolean badgepay) {
            this.badgepay = badgepay;
        }

        public void setCoins(int coins) {
            this.coins = coins;
        }

        public void setComment(int comment) {
            this.comment = comment;
        }

        public void setCopyright(String copyright) {
            this.copyright = copyright;
        }

        public void setCreate(String create) {
            this.create = create;
        }

        public void setCredit(int credit) {
            this.credit = credit;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public void setDuration(String duration) {
            this.duration = duration;
        }

        public void setFavorites(int favorites) {
            this.favorites = favorites;
        }

        public void setMid(int mid) {
            this.mid = mid;
        }

        public void setPic(String pic) {
            this.pic = pic;
        }

        public void setPlay(String play) {
            this.play = play;
        }

        public void setReview(String review) {
            this.review = review;
        }

        public void setSubtitle(String subtitle) {
            this.subtitle = subtitle;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public void setTypeid(String typeid) {
            this.typeid = typeid;
        }

        public void setTypename(String typename) {
            this.typename = typename;
        }

        public void setVideo_review(String video_review) {
            this.video_review = video_review;
        }

        public String getAid() {
            return aid;
        }

        public String getAuthor() {
            return author;
        }

        public boolean isBadgepay() {
            return badgepay;
        }

        public int getCoins() {
            return coins;
        }

        public int getComment() {
            return comment;
        }

        public String getCopyright() {
            return copyright;
        }

        public String getCreate() {
            return create;
        }

        public int getCredit() {
            return credit;
        }

        public String getDescription() {
            return description;
        }

        public String getDuration() {
            return duration;
        }

        public int getFavorites() {
            return favorites;
        }

        public int getMid() {
            return mid;
        }

        public String getPic() {
            return pic;
        }

        public String getPlay() {
            return play;
        }

        public String getReview() {
            return review;
        }

        public String getSubtitle() {
            return subtitle;
        }

        public String getTitle() {
            return title;
        }

        public String getTypeid() {
            return typeid;
        }

        public String getTypename() {
            return typename;
        }

        public String getVideo_review() {
            return video_review;
        }
    }

    public static class FunnyVideo {
        private String aid;
        private String author;
        private boolean badgepay;
        private int coins;
        private int comment;
        private String copyright;
        private String create;
        private int credit;
        private String description;
        private String duration;
        private int favorites;
        private int mid;
        private String pic;
        private String play;
        private String review;
        private String subtitle;
        private String title;
        private String typeid;
        private String typename;
        private String video_review;

        public void setAid(String aid) {
            this.aid = aid;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public void setBadgepay(boolean badgepay) {
            this.badgepay = badgepay;
        }

        public void setCoins(int coins) {
            this.coins = coins;
        }

        public void setComment(int comment) {
            this.comment = comment;
        }

        public void setCopyright(String copyright) {
            this.copyright = copyright;
        }

        public void setCreate(String create) {
            this.create = create;
        }

        public void setCredit(int credit) {
            this.credit = credit;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public void setDuration(String duration) {
            this.duration = duration;
        }

        public void setFavorites(int favorites) {
            this.favorites = favorites;
        }

        public void setMid(int mid) {
            this.mid = mid;
        }

        public void setPic(String pic) {
            this.pic = pic;
        }

        public void setPlay(String play) {
            this.play = play;
        }

        public void setReview(String review) {
            this.review = review;
        }

        public void setSubtitle(String subtitle) {
            this.subtitle = subtitle;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public void setTypeid(String typeid) {
            this.typeid = typeid;
        }

        public void setTypename(String typename) {
            this.typename = typename;
        }

        public void setVideo_review(String video_review) {
            this.video_review = video_review;
        }

        public String getAid() {
            return aid;
        }

        public String getAuthor() {
            return author;
        }

        public boolean isBadgepay() {
            return badgepay;
        }

        public int getCoins() {
            return coins;
        }

        public int getComment() {
            return comment;
        }

        public String getCopyright() {
            return copyright;
        }

        public String getCreate() {
            return create;
        }

        public int getCredit() {
            return credit;
        }

        public String getDescription() {
            return description;
        }

        public String getDuration() {
            return duration;
        }

        public int getFavorites() {
            return favorites;
        }

        public int getMid() {
            return mid;
        }

        public String getPic() {
            return pic;
        }

        public String getPlay() {
            return play;
        }

        public String getReview() {
            return review;
        }

        public String getSubtitle() {
            return subtitle;
        }

        public String getTitle() {
            return title;
        }

        public String getTypeid() {
            return typeid;
        }

        public String getTypename() {
            return typename;
        }

        public String getVideo_review() {
            return video_review;
        }
    }

    public static class GameVideo {
        private String aid;
        private String author;
        private boolean badgepay;
        private int coins;
        private int comment;
        private String copyright;
        private String create;
        private int credit;
        private String description;
        private String duration;
        private int favorites;
        private int mid;
        private String pic;
        private String play;
        private String review;
        private String subtitle;
        private String title;
        private String typeid;
        private String typename;
        private String video_review;

        public void setAid(String aid) {
            this.aid = aid;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public void setBadgepay(boolean badgepay) {
            this.badgepay = badgepay;
        }

        public void setCoins(int coins) {
            this.coins = coins;
        }

        public void setComment(int comment) {
            this.comment = comment;
        }

        public void setCopyright(String copyright) {
            this.copyright = copyright;
        }

        public void setCreate(String create) {
            this.create = create;
        }

        public void setCredit(int credit) {
            this.credit = credit;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public void setDuration(String duration) {
            this.duration = duration;
        }

        public void setFavorites(int favorites) {
            this.favorites = favorites;
        }

        public void setMid(int mid) {
            this.mid = mid;
        }

        public void setPic(String pic) {
            this.pic = pic;
        }

        public void setPlay(String play) {
            this.play = play;
        }

        public void setReview(String review) {
            this.review = review;
        }

        public void setSubtitle(String subtitle) {
            this.subtitle = subtitle;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public void setTypeid(String typeid) {
            this.typeid = typeid;
        }

        public void setTypename(String typename) {
            this.typename = typename;
        }

        public void setVideo_review(String video_review) {
            this.video_review = video_review;
        }

        public String getAid() {
            return aid;
        }

        public String getAuthor() {
            return author;
        }

        public boolean isBadgepay() {
            return badgepay;
        }

        public int getCoins() {
            return coins;
        }

        public int getComment() {
            return comment;
        }

        public String getCopyright() {
            return copyright;
        }

        public String getCreate() {
            return create;
        }

        public int getCredit() {
            return credit;
        }

        public String getDescription() {
            return description;
        }

        public String getDuration() {
            return duration;
        }

        public int getFavorites() {
            return favorites;
        }

        public int getMid() {
            return mid;
        }

        public String getPic() {
            return pic;
        }

        public String getPlay() {
            return play;
        }

        public String getReview() {
            return review;
        }

        public String getSubtitle() {
            return subtitle;
        }

        public String getTitle() {
            return title;
        }

        public String getTypeid() {
            return typeid;
        }

        public String getTypename() {
            return typename;
        }

        public String getVideo_review() {
            return video_review;
        }
    }

    public static class Movie {
        private String aid;
        private String author;
        private boolean badgepay;
        private int coins;
        private int comment;
        private String copyright;
        private String create;
        private int credit;
        private String description;
        private String duration;
        private int favorites;
        private int mid;
        private String pic;
        private String play;
        private String review;
        private String subtitle;
        private String title;
        private String typeid;
        private String typename;
        private String video_review;

        public void setAid(String aid) {
            this.aid = aid;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public void setBadgepay(boolean badgepay) {
            this.badgepay = badgepay;
        }

        public void setCoins(int coins) {
            this.coins = coins;
        }

        public void setComment(int comment) {
            this.comment = comment;
        }

        public void setCopyright(String copyright) {
            this.copyright = copyright;
        }

        public void setCreate(String create) {
            this.create = create;
        }

        public void setCredit(int credit) {
            this.credit = credit;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public void setDuration(String duration) {
            this.duration = duration;
        }

        public void setFavorites(int favorites) {
            this.favorites = favorites;
        }

        public void setMid(int mid) {
            this.mid = mid;
        }

        public void setPic(String pic) {
            this.pic = pic;
        }

        public void setPlay(String play) {
            this.play = play;
        }

        public void setReview(String review) {
            this.review = review;
        }

        public void setSubtitle(String subtitle) {
            this.subtitle = subtitle;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public void setTypeid(String typeid) {
            this.typeid = typeid;
        }

        public void setTypename(String typename) {
            this.typename = typename;
        }

        public void setVideo_review(String video_review) {
            this.video_review = video_review;
        }

        public String getAid() {
            return aid;
        }

        public String getAuthor() {
            return author;
        }

        public boolean isBadgepay() {
            return badgepay;
        }

        public int getCoins() {
            return coins;
        }

        public int getComment() {
            return comment;
        }

        public String getCopyright() {
            return copyright;
        }

        public String getCreate() {
            return create;
        }

        public int getCredit() {
            return credit;
        }

        public String getDescription() {
            return description;
        }

        public String getDuration() {
            return duration;
        }

        public int getFavorites() {
            return favorites;
        }

        public int getMid() {
            return mid;
        }

        public String getPic() {
            return pic;
        }

        public String getPlay() {
            return play;
        }

        public String getReview() {
            return review;
        }

        public String getSubtitle() {
            return subtitle;
        }

        public String getTitle() {
            return title;
        }

        public String getTypeid() {
            return typeid;
        }

        public String getTypename() {
            return typename;
        }

        public String getVideo_review() {
            return video_review;
        }
    }

    public static class TV {
        private String aid;
        private String author;
        private boolean badgepay;
        private int coins;
        private int comment;
        private String copyright;
        private String create;
        private int credit;
        private String description;
        private String duration;
        private int favorites;
        private int mid;
        private String pic;
        private String play;
        private String review;
        private String subtitle;
        private String title;
        private String typeid;
        private String typename;
        private String video_review;

        public void setAid(String aid) {
            this.aid = aid;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public void setBadgepay(boolean badgepay) {
            this.badgepay = badgepay;
        }

        public void setCoins(int coins) {
            this.coins = coins;
        }

        public void setComment(int comment) {
            this.comment = comment;
        }

        public void setCopyright(String copyright) {
            this.copyright = copyright;
        }

        public void setCreate(String create) {
            this.create = create;
        }

        public void setCredit(int credit) {
            this.credit = credit;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public void setDuration(String duration) {
            this.duration = duration;
        }

        public void setFavorites(int favorites) {
            this.favorites = favorites;
        }

        public void setMid(int mid) {
            this.mid = mid;
        }

        public void setPic(String pic) {
            this.pic = pic;
        }

        public void setPlay(String play) {
            this.play = play;
        }

        public void setReview(String review) {
            this.review = review;
        }

        public void setSubtitle(String subtitle) {
            this.subtitle = subtitle;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public void setTypeid(String typeid) {
            this.typeid = typeid;
        }

        public void setTypename(String typename) {
            this.typename = typename;
        }

        public void setVideo_review(String video_review) {
            this.video_review = video_review;
        }

        public String getAid() {
            return aid;
        }

        public String getAuthor() {
            return author;
        }

        public boolean isBadgepay() {
            return badgepay;
        }

        public int getCoins() {
            return coins;
        }

        public int getComment() {
            return comment;
        }

        public String getCopyright() {
            return copyright;
        }

        public String getCreate() {
            return create;
        }

        public int getCredit() {
            return credit;
        }

        public String getDescription() {
            return description;
        }

        public String getDuration() {
            return duration;
        }

        public int getFavorites() {
            return favorites;
        }

        public int getMid() {
            return mid;
        }

        public String getPic() {
            return pic;
        }

        public String getPlay() {
            return play;
        }

        public String getReview() {
            return review;
        }

        public String getSubtitle() {
            return subtitle;
        }

        public String getTitle() {
            return title;
        }

        public String getTypeid() {
            return typeid;
        }

        public String getTypename() {
            return typename;
        }

        public String getVideo_review() {
            return video_review;
        }
    }

    public static class PanDrama {
        private String aid;
        private String author;
        private boolean badgepay;
        private int coins;
        private int comment;
        private String copyright;
        private String create;
        private int credit;
        private String description;
        private String duration;
        private int favorites;
        private int mid;
        private String pic;
        private String play;
        private String review;
        private String subtitle;
        private String title;
        private String typeid;
        private String typename;
        private String video_review;

        public void setAid(String aid) {
            this.aid = aid;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public void setBadgepay(boolean badgepay) {
            this.badgepay = badgepay;
        }

        public void setCoins(int coins) {
            this.coins = coins;
        }

        public void setComment(int comment) {
            this.comment = comment;
        }

        public void setCopyright(String copyright) {
            this.copyright = copyright;
        }

        public void setCreate(String create) {
            this.create = create;
        }

        public void setCredit(int credit) {
            this.credit = credit;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public void setDuration(String duration) {
            this.duration = duration;
        }

        public void setFavorites(int favorites) {
            this.favorites = favorites;
        }

        public void setMid(int mid) {
            this.mid = mid;
        }

        public void setPic(String pic) {
            this.pic = pic;
        }

        public void setPlay(String play) {
            this.play = play;
        }

        public void setReview(String review) {
            this.review = review;
        }

        public void setSubtitle(String subtitle) {
            this.subtitle = subtitle;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public void setTypeid(String typeid) {
            this.typeid = typeid;
        }

        public void setTypename(String typename) {
            this.typename = typename;
        }

        public void setVideo_review(String video_review) {
            this.video_review = video_review;
        }

        public String getAid() {
            return aid;
        }

        public String getAuthor() {
            return author;
        }

        public boolean isBadgepay() {
            return badgepay;
        }

        public int getCoins() {
            return coins;
        }

        public int getComment() {
            return comment;
        }

        public String getCopyright() {
            return copyright;
        }

        public String getCreate() {
            return create;
        }

        public int getCredit() {
            return credit;
        }

        public String getDescription() {
            return description;
        }

        public String getDuration() {
            return duration;
        }

        public int getFavorites() {
            return favorites;
        }

        public int getMid() {
            return mid;
        }

        public String getPic() {
            return pic;
        }

        public String getPlay() {
            return play;
        }

        public String getReview() {
            return review;
        }

        public String getSubtitle() {
            return subtitle;
        }

        public String getTitle() {
            return title;
        }

        public String getTypeid() {
            return typeid;
        }

        public String getTypename() {
            return typename;
        }

        public String getVideo_review() {
            return video_review;
        }
    }

    public static class TechnologyVideo {
        private String aid;
        private String author;
        private boolean badgepay;
        private int coins;
        private int comment;
        private String copyright;
        private String create;
        private int credit;
        private String description;
        private String duration;
        private int favorites;
        private int mid;
        private String pic;
        private String play;
        private String review;
        private String subtitle;
        private String title;
        private String typeid;
        private String typename;
        private String video_review;

        public void setAid(String aid) {
            this.aid = aid;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public void setBadgepay(boolean badgepay) {
            this.badgepay = badgepay;
        }

        public void setCoins(int coins) {
            this.coins = coins;
        }

        public void setComment(int comment) {
            this.comment = comment;
        }

        public void setCopyright(String copyright) {
            this.copyright = copyright;
        }

        public void setCreate(String create) {
            this.create = create;
        }

        public void setCredit(int credit) {
            this.credit = credit;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public void setDuration(String duration) {
            this.duration = duration;
        }

        public void setFavorites(int favorites) {
            this.favorites = favorites;
        }

        public void setMid(int mid) {
            this.mid = mid;
        }

        public void setPic(String pic) {
            this.pic = pic;
        }

        public void setPlay(String play) {
            this.play = play;
        }

        public void setReview(String review) {
            this.review = review;
        }

        public void setSubtitle(String subtitle) {
            this.subtitle = subtitle;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public void setTypeid(String typeid) {
            this.typeid = typeid;
        }

        public void setTypename(String typename) {
            this.typename = typename;
        }

        public void setVideo_review(String video_review) {
            this.video_review = video_review;
        }

        public String getAid() {
            return aid;
        }

        public String getAuthor() {
            return author;
        }

        public boolean isBadgepay() {
            return badgepay;
        }

        public int getCoins() {
            return coins;
        }

        public int getComment() {
            return comment;
        }

        public String getCopyright() {
            return copyright;
        }

        public String getCreate() {
            return create;
        }

        public int getCredit() {
            return credit;
        }

        public String getDescription() {
            return description;
        }

        public String getDuration() {
            return duration;
        }

        public int getFavorites() {
            return favorites;
        }

        public int getMid() {
            return mid;
        }

        public String getPic() {
            return pic;
        }

        public String getPlay() {
            return play;
        }

        public String getReview() {
            return review;
        }

        public String getSubtitle() {
            return subtitle;
        }

        public String getTitle() {
            return title;
        }

        public String getTypeid() {
            return typeid;
        }

        public String getTypename() {
            return typename;
        }

        public String getVideo_review() {
            return video_review;
        }
    }

    public static class DanceVideo {
        private String aid;
        private String author;
        private boolean badgepay;
        private int coins;
        private int comment;
        private String copyright;
        private String create;
        private int credit;
        private String description;
        private String duration;
        private int favorites;
        private int mid;
        private String pic;
        private String play;
        private String review;
        private String subtitle;
        private String title;
        private String typeid;
        private String typename;
        private String video_review;

        public void setAid(String aid) {
            this.aid = aid;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public void setBadgepay(boolean badgepay) {
            this.badgepay = badgepay;
        }

        public void setCoins(int coins) {
            this.coins = coins;
        }

        public void setComment(int comment) {
            this.comment = comment;
        }

        public void setCopyright(String copyright) {
            this.copyright = copyright;
        }

        public void setCreate(String create) {
            this.create = create;
        }

        public void setCredit(int credit) {
            this.credit = credit;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public void setDuration(String duration) {
            this.duration = duration;
        }

        public void setFavorites(int favorites) {
            this.favorites = favorites;
        }

        public void setMid(int mid) {
            this.mid = mid;
        }

        public void setPic(String pic) {
            this.pic = pic;
        }

        public void setPlay(String play) {
            this.play = play;
        }

        public void setReview(String review) {
            this.review = review;
        }

        public void setSubtitle(String subtitle) {
            this.subtitle = subtitle;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public void setTypeid(String typeid) {
            this.typeid = typeid;
        }

        public void setTypename(String typename) {
            this.typename = typename;
        }

        public void setVideo_review(String video_review) {
            this.video_review = video_review;
        }

        public String getAid() {
            return aid;
        }

        public String getAuthor() {
            return author;
        }

        public boolean isBadgepay() {
            return badgepay;
        }

        public int getCoins() {
            return coins;
        }

        public int getComment() {
            return comment;
        }

        public String getCopyright() {
            return copyright;
        }

        public String getCreate() {
            return create;
        }

        public int getCredit() {
            return credit;
        }

        public String getDescription() {
            return description;
        }

        public String getDuration() {
            return duration;
        }

        public int getFavorites() {
            return favorites;
        }

        public int getMid() {
            return mid;
        }

        public String getPic() {
            return pic;
        }

        public String getPlay() {
            return play;
        }

        public String getReview() {
            return review;
        }

        public String getSubtitle() {
            return subtitle;
        }

        public String getTitle() {
            return title;
        }

        public String getTypeid() {
            return typeid;
        }

        public String getTypename() {
            return typename;
        }

        public String getVideo_review() {
            return video_review;
        }
    }

    public static class Music {
        private String aid;
        private String author;
        private boolean badgepay;
        private int coins;
        private int comment;
        private String copyright;
        private String create;
        private int credit;
        private String description;
        private String duration;
        private int favorites;
        private int mid;
        private String pic;
        private String play;
        private String review;
        private String subtitle;
        private String title;
        private String typeid;
        private String typename;
        private String video_review;

        public void setAid(String aid) {
            this.aid = aid;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public void setBadgepay(boolean badgepay) {
            this.badgepay = badgepay;
        }

        public void setCoins(int coins) {
            this.coins = coins;
        }

        public void setComment(int comment) {
            this.comment = comment;
        }

        public void setCopyright(String copyright) {
            this.copyright = copyright;
        }

        public void setCreate(String create) {
            this.create = create;
        }

        public void setCredit(int credit) {
            this.credit = credit;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public void setDuration(String duration) {
            this.duration = duration;
        }

        public void setFavorites(int favorites) {
            this.favorites = favorites;
        }

        public void setMid(int mid) {
            this.mid = mid;
        }

        public void setPic(String pic) {
            this.pic = pic;
        }

        public void setPlay(String play) {
            this.play = play;
        }

        public void setReview(String review) {
            this.review = review;
        }

        public void setSubtitle(String subtitle) {
            this.subtitle = subtitle;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public void setTypeid(String typeid) {
            this.typeid = typeid;
        }

        public void setTypename(String typename) {
            this.typename = typename;
        }

        public void setVideo_review(String video_review) {
            this.video_review = video_review;
        }

        public String getAid() {
            return aid;
        }

        public String getAuthor() {
            return author;
        }

        public boolean isBadgepay() {
            return badgepay;
        }

        public int getCoins() {
            return coins;
        }

        public int getComment() {
            return comment;
        }

        public String getCopyright() {
            return copyright;
        }

        public String getCreate() {
            return create;
        }

        public int getCredit() {
            return credit;
        }

        public String getDescription() {
            return description;
        }

        public String getDuration() {
            return duration;
        }

        public int getFavorites() {
            return favorites;
        }

        public int getMid() {
            return mid;
        }

        public String getPic() {
            return pic;
        }

        public String getPlay() {
            return play;
        }

        public String getReview() {
            return review;
        }

        public String getSubtitle() {
            return subtitle;
        }

        public String getTitle() {
            return title;
        }

        public String getTypeid() {
            return typeid;
        }

        public String getTypename() {
            return typename;
        }

        public String getVideo_review() {
            return video_review;
        }
    }

    public static class GhotVideo {
        private String aid;
        private String author;
        private boolean badgepay;
        private int coins;
        private int comment;
        private String copyright;
        private String create;
        private int credit;
        private String description;
        private String duration;
        private int favorites;
        private int mid;
        private String pic;
        private String play;
        private String review;
        private String subtitle;
        private String title;
        private String typeid;
        private String typename;
        private String video_review;

        public void setAid(String aid) {
            this.aid = aid;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public void setBadgepay(boolean badgepay) {
            this.badgepay = badgepay;
        }

        public void setCoins(int coins) {
            this.coins = coins;
        }

        public void setComment(int comment) {
            this.comment = comment;
        }

        public void setCopyright(String copyright) {
            this.copyright = copyright;
        }

        public void setCreate(String create) {
            this.create = create;
        }

        public void setCredit(int credit) {
            this.credit = credit;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public void setDuration(String duration) {
            this.duration = duration;
        }

        public void setFavorites(int favorites) {
            this.favorites = favorites;
        }

        public void setMid(int mid) {
            this.mid = mid;
        }

        public void setPic(String pic) {
            this.pic = pic;
        }

        public void setPlay(String play) {
            this.play = play;
        }

        public void setReview(String review) {
            this.review = review;
        }

        public void setSubtitle(String subtitle) {
            this.subtitle = subtitle;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public void setTypeid(String typeid) {
            this.typeid = typeid;
        }

        public void setTypename(String typename) {
            this.typename = typename;
        }

        public void setVideo_review(String video_review) {
            this.video_review = video_review;
        }

        public String getAid() {
            return aid;
        }

        public String getAuthor() {
            return author;
        }

        public boolean isBadgepay() {
            return badgepay;
        }

        public int getCoins() {
            return coins;
        }

        public int getComment() {
            return comment;
        }

        public String getCopyright() {
            return copyright;
        }

        public String getCreate() {
            return create;
        }

        public int getCredit() {
            return credit;
        }

        public String getDescription() {
            return description;
        }

        public String getDuration() {
            return duration;
        }

        public int getFavorites() {
            return favorites;
        }

        public int getMid() {
            return mid;
        }

        public String getPic() {
            return pic;
        }

        public String getPlay() {
            return play;
        }

        public String getReview() {
            return review;
        }

        public String getSubtitle() {
            return subtitle;
        }

        public String getTitle() {
            return title;
        }

        public String getTypeid() {
            return typeid;
        }

        public String getTypename() {
            return typename;
        }

        public String getVideo_review() {
            return video_review;
        }
    }
}
