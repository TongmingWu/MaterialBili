package com.tongming.materialbili.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Tongming on 2016/4/6.
 */
public class AidVideo implements Parcelable {

    private int allow_bp;
    private int allow_download;
    private int allow_feed;
    private String arctype;
    private String author;
    private String coins;
    private int created;
    private String created_at;
    private String credit;
    private String description;
    private String face;
    private String favorites;
    private String instant_server;

    private ListEntity list;
    private String mid;
    private int pages;
    private String pic;
    private String play;
    private String review;
    private String src;
    private String tag;
    private int tid;
    private String title;
    private String typename;
    private String video_review;

    public int getAllow_bp() {
        return allow_bp;
    }

    public void setAllow_bp(int allow_bp) {
        this.allow_bp = allow_bp;
    }

    public int getAllow_download() {
        return allow_download;
    }

    public void setAllow_download(int allow_download) {
        this.allow_download = allow_download;
    }

    public int getAllow_feed() {
        return allow_feed;
    }

    public void setAllow_feed(int allow_feed) {
        this.allow_feed = allow_feed;
    }

    public String getArctype() {
        return arctype;
    }

    public void setArctype(String arctype) {
        this.arctype = arctype;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCoins() {
        return coins;
    }

    public void setCoins(String coins) {
        this.coins = coins;
    }

    public int getCreated() {
        return created;
    }

    public void setCreated(int created) {
        this.created = created;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getCredit() {
        return credit;
    }

    public void setCredit(String credit) {
        this.credit = credit;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFace() {
        return face;
    }

    public void setFace(String face) {
        this.face = face;
    }

    public String getFavorites() {
        return favorites;
    }

    public void setFavorites(String favorites) {
        this.favorites = favorites;
    }

    public String getInstant_server() {
        return instant_server;
    }

    public void setInstant_server(String instant_server) {
        this.instant_server = instant_server;
    }

    public ListEntity getList() {
        return list;
    }

    public void setList(ListEntity list) {
        this.list = list;
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getPlay() {
        return play;
    }

    public void setPlay(String play) {
        this.play = play;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }

    public String getVideo_review() {
        return video_review;
    }

    public void setVideo_review(String video_review) {
        this.video_review = video_review;
    }

    public static class ListEntity implements Parcelable {
        /**
         * cid : 2385493
         * page : 1
         * part :
         * type : youku
         */

        @SerializedName("0")
        private ListZero zero;

        public ListZero getZero() {
            return zero;
        }

        public void setZero(ListZero zero) {
            this.zero = zero;
        }

        public static class ListZero implements Parcelable{
            private int cid;
            private int page;
            private String part;
            private String type;

            public int getCid() {
                return cid;
            }

            public void setCid(int cid) {
                this.cid = cid;
            }

            public int getPage() {
                return page;
            }

            public void setPage(int page) {
                this.page = page;
            }

            public String getPart() {
                return part;
            }

            public void setPart(String part) {
                this.part = part;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeInt(this.cid);
                dest.writeInt(this.page);
                dest.writeString(this.part);
                dest.writeString(this.type);
            }

            public ListZero() {
            }

            ListZero(Parcel in) {
                this.cid = in.readInt();
                this.page = in.readInt();
                this.part = in.readString();
                this.type = in.readString();
            }

            public static final Creator<ListZero> CREATOR = new Creator<ListZero>() {
                @Override
                public ListZero createFromParcel(Parcel source) {
                    return new ListZero(source);
                }

                @Override
                public ListZero[] newArray(int size) {
                    return new ListZero[size];
                }
            };
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeParcelable(this.zero, flags);
        }

        public ListEntity() {
        }

        ListEntity(Parcel in) {
            this.zero = in.readParcelable(ListZero.class.getClassLoader());
        }

        public static final Creator<ListEntity> CREATOR = new Creator<ListEntity>() {
            @Override
            public ListEntity createFromParcel(Parcel source) {
                return new ListEntity(source);
            }

            @Override
            public ListEntity[] newArray(int size) {
                return new ListEntity[size];
            }
        };
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.allow_bp);
        dest.writeInt(this.allow_download);
        dest.writeInt(this.allow_feed);
        dest.writeString(this.arctype);
        dest.writeString(this.author);
        dest.writeString(this.coins);
        dest.writeInt(this.created);
        dest.writeString(this.created_at);
        dest.writeString(this.credit);
        dest.writeString(this.description);
        dest.writeString(this.face);
        dest.writeString(this.favorites);
        dest.writeString(this.instant_server);
        dest.writeParcelable(this.list, flags);
        dest.writeString(this.mid);
        dest.writeInt(this.pages);
        dest.writeString(this.pic);
        dest.writeString(this.play);
        dest.writeString(this.review);
        dest.writeString(this.src);
        dest.writeString(this.tag);
        dest.writeInt(this.tid);
        dest.writeString(this.title);
        dest.writeString(this.typename);
        dest.writeString(this.video_review);
    }

    public AidVideo() {
    }

    private AidVideo(Parcel in) {
        this.allow_bp = in.readInt();
        this.allow_download = in.readInt();
        this.allow_feed = in.readInt();
        this.arctype = in.readString();
        this.author = in.readString();
        this.coins = in.readString();
        this.created = in.readInt();
        this.created_at = in.readString();
        this.credit = in.readString();
        this.description = in.readString();
        this.face = in.readString();
        this.favorites = in.readString();
        this.instant_server = in.readString();
        this.list = in.readParcelable(ListEntity.class.getClassLoader());
        this.mid = in.readString();
        this.pages = in.readInt();
        this.pic = in.readString();
        this.play = in.readString();
        this.review = in.readString();
        this.src = in.readString();
        this.tag = in.readString();
        this.tid = in.readInt();
        this.title = in.readString();
        this.typename = in.readString();
        this.video_review = in.readString();
    }

    public static final Creator<AidVideo> CREATOR = new Creator<AidVideo>() {
        @Override
        public AidVideo createFromParcel(Parcel source) {
            return new AidVideo(source);
        }

        @Override
        public AidVideo[] newArray(int size) {
            return new AidVideo[size];
        }
    };
}
