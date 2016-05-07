package com.tongming.materialbili.model;

import java.util.List;

/**
 * Created by Tongming on 2016/5/6.
 */
public class PanDetail {


    /**
     * img : http://i0.hdslb.com/bfs/bangumi/dc006f316dcca104efadf16c15752a881e39817b.jpg
     * play_date : 2016年4月
     * finish : false
     * desc : 小南今天开始就是高中生了。吃着早餐最喜欢的面包，开始了最棒的一天。和同班的“面包友”在一起的她，每天都十分开心！可爱而又轻飘飘的面包短篇动画！
     * pan_count : 5
     * fans_num : 9.4万
     * play_count : 98.3万
     * style : 16年四月新番 日常 治愈 萌萌哒 连载中 校园 吃吃喝喝
     * update_date : 每周日19:55更新
     * results : [{"index":"5","aid":"4523244"},{"index":"4","aid":"4457083"},{"index":"3","aid":"4392478"},{"index":"2","aid":"4328782"},{"index":"1","aid":"4260787"}]
     * name : 面包带来和平！
     */

    private String img;
    private String play_date;
    private boolean finish;
    private String desc;
    private int pan_count;
    private String fans_num;
    private String play_count;
    private String style;
    private String update_date;
    private String name;
    /**
     * index : 5
     * aid : 4523244
     */

    private List<ResultsEntity> results;

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getPlay_date() {
        return play_date;
    }

    public void setPlay_date(String play_date) {
        this.play_date = play_date;
    }

    public boolean isFinish() {
        return finish;
    }

    public void setFinish(boolean finish) {
        this.finish = finish;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getPan_count() {
        return pan_count;
    }

    public void setPan_count(int pan_count) {
        this.pan_count = pan_count;
    }

    public String getFans_num() {
        return fans_num;
    }

    public void setFans_num(String fans_num) {
        this.fans_num = fans_num;
    }

    public String getPlay_count() {
        return play_count;
    }

    public void setPlay_count(String play_count) {
        this.play_count = play_count;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getUpdate_date() {
        return update_date;
    }

    public void setUpdate_date(String update_date) {
        this.update_date = update_date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ResultsEntity> getResults() {
        return results;
    }

    public void setResults(List<ResultsEntity> results) {
        this.results = results;
    }

    public static class ResultsEntity {
        private String index;
        private String aid;

        public String getIndex() {
            return index;
        }

        public void setIndex(String index) {
            this.index = index;
        }

        public String getAid() {
            return aid;
        }

        public void setAid(String aid) {
            this.aid = aid;
        }
    }
}
