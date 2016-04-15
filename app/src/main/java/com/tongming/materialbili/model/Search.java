package com.tongming.materialbili.model;

import java.util.List;

/**
 * Created by Tongming on 2016/4/3.
 */
public class Search {

    private int page;

    private PageInfoEntity page_info;
    private int pagesize;
    private ResultEntity result;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public PageInfoEntity getPage_info() {
        return page_info;
    }

    public void setPage_info(PageInfoEntity page_info) {
        this.page_info = page_info;
    }

    public int getPagesize() {
        return pagesize;
    }

    public void setPagesize(int pagesize) {
        this.pagesize = pagesize;
    }

    public ResultEntity getResult() {
        return result;
    }

    public void setResult(ResultEntity result) {
        this.result = result;
    }

    public static class PageInfoEntity {

        private BangumiEntity bangumi;

        private SpecialEntity special;

        private TopicEntity topic;

        private TvplayEntity tvplay;

        private UpuserEntity upuser;

        private VideoEntity video;

        public BangumiEntity getBangumi() {
            return bangumi;
        }

        public void setBangumi(BangumiEntity bangumi) {
            this.bangumi = bangumi;
        }

        public SpecialEntity getSpecial() {
            return special;
        }

        public void setSpecial(SpecialEntity special) {
            this.special = special;
        }

        public TopicEntity getTopic() {
            return topic;
        }

        public void setTopic(TopicEntity topic) {
            this.topic = topic;
        }

        public TvplayEntity getTvplay() {
            return tvplay;
        }

        public void setTvplay(TvplayEntity tvplay) {
            this.tvplay = tvplay;
        }

        public UpuserEntity getUpuser() {
            return upuser;
        }

        public void setUpuser(UpuserEntity upuser) {
            this.upuser = upuser;
        }

        public VideoEntity getVideo() {
            return video;
        }

        public void setVideo(VideoEntity video) {
            this.video = video;
        }

        public static class BangumiEntity {
            private int numResults;
            private int pages;
            private int total;

            public int getNumResults() {
                return numResults;
            }

            public void setNumResults(int numResults) {
                this.numResults = numResults;
            }

            public int getPages() {
                return pages;
            }

            public void setPages(int pages) {
                this.pages = pages;
            }

            public int getTotal() {
                return total;
            }

            public void setTotal(int total) {
                this.total = total;
            }
        }

        public static class SpecialEntity {
            private int numResults;
            private int pages;
            private int total;

            public int getNumResults() {
                return numResults;
            }

            public void setNumResults(int numResults) {
                this.numResults = numResults;
            }

            public int getPages() {
                return pages;
            }

            public void setPages(int pages) {
                this.pages = pages;
            }

            public int getTotal() {
                return total;
            }

            public void setTotal(int total) {
                this.total = total;
            }
        }

        public static class TopicEntity {
            private int numResults;
            private int pages;
            private int total;

            public int getNumResults() {
                return numResults;
            }

            public void setNumResults(int numResults) {
                this.numResults = numResults;
            }

            public int getPages() {
                return pages;
            }

            public void setPages(int pages) {
                this.pages = pages;
            }

            public int getTotal() {
                return total;
            }

            public void setTotal(int total) {
                this.total = total;
            }
        }

        public static class TvplayEntity {
            private int numResults;
            private int pages;
            private int total;

            public int getNumResults() {
                return numResults;
            }

            public void setNumResults(int numResults) {
                this.numResults = numResults;
            }

            public int getPages() {
                return pages;
            }

            public void setPages(int pages) {
                this.pages = pages;
            }

            public int getTotal() {
                return total;
            }

            public void setTotal(int total) {
                this.total = total;
            }
        }

        public static class UpuserEntity {
            private int numResults;
            private int pages;
            private int total;

            public int getNumResults() {
                return numResults;
            }

            public void setNumResults(int numResults) {
                this.numResults = numResults;
            }

            public int getPages() {
                return pages;
            }

            public void setPages(int pages) {
                this.pages = pages;
            }

            public int getTotal() {
                return total;
            }

            public void setTotal(int total) {
                this.total = total;
            }
        }

        public static class VideoEntity {
            private int numResults;
            private int pages;
            private int total;

            public int getNumResults() {
                return numResults;
            }

            public void setNumResults(int numResults) {
                this.numResults = numResults;
            }

            public int getPages() {
                return pages;
            }

            public void setPages(int pages) {
                this.pages = pages;
            }

            public int getTotal() {
                return total;
            }

            public void setTotal(int total) {
                this.total = total;
            }
        }
    }

    public static class ResultEntity {

        private List<VideoEntity> video;

        public List<VideoEntity> getVideo() {
            return video;
        }

        public void setVideo(List<VideoEntity> video) {
            this.video = video;
        }

        public static class VideoEntity {
            private String aid;
            private String arcrank;
            private String arcurl;
            private String author;
            private boolean badgepay;
            private String description;
            private String duration;
            private int favorites;
            private int id;
            private int mid;
            private String pic;
            private int play;
            private int pubdate;
            private int review;
            private int senddate;
            private String tag;
            private String title;
            private String type;
            private String typeid;
            private String typename;
            private int video_review;

            public String getAid() {
                return aid;
            }

            public void setAid(String aid) {
                this.aid = aid;
            }

            public String getArcrank() {
                return arcrank;
            }

            public void setArcrank(String arcrank) {
                this.arcrank = arcrank;
            }

            public String getArcurl() {
                return arcurl;
            }

            public void setArcurl(String arcurl) {
                this.arcurl = arcurl;
            }

            public String getAuthor() {
                return author;
            }

            public void setAuthor(String author) {
                this.author = author;
            }

            public boolean isBadgepay() {
                return badgepay;
            }

            public void setBadgepay(boolean badgepay) {
                this.badgepay = badgepay;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public String getDuration() {
                return duration;
            }

            public void setDuration(String duration) {
                this.duration = duration;
            }

            public int getFavorites() {
                return favorites;
            }

            public void setFavorites(int favorites) {
                this.favorites = favorites;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getMid() {
                return mid;
            }

            public void setMid(int mid) {
                this.mid = mid;
            }

            public String getPic() {
                return pic;
            }

            public void setPic(String pic) {
                this.pic = pic;
            }

            public int getPlay() {
                return play;
            }

            public void setPlay(int play) {
                this.play = play;
            }

            public int getPubdate() {
                return pubdate;
            }

            public void setPubdate(int pubdate) {
                this.pubdate = pubdate;
            }

            public int getReview() {
                return review;
            }

            public void setReview(int review) {
                this.review = review;
            }

            public int getSenddate() {
                return senddate;
            }

            public void setSenddate(int senddate) {
                this.senddate = senddate;
            }

            public String getTag() {
                return tag;
            }

            public void setTag(String tag) {
                this.tag = tag;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getTypeid() {
                return typeid;
            }

            public void setTypeid(String typeid) {
                this.typeid = typeid;
            }

            public String getTypename() {
                return typename;
            }

            public void setTypename(String typename) {
                this.typename = typename;
            }

            public int getVideo_review() {
                return video_review;
            }

            public void setVideo_review(int video_review) {
                this.video_review = video_review;
            }
        }
    }
}
