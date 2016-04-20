package com.tongming.materialbili.utils;

/**
 * Created by Tongming on 2016/3/6.
 */
public class URLUtil {
    public static final String ANIME = "1";//动画
    public static final String MUSIC = "3";//音乐
    public static final String FUNNY = "5";//娱乐
    public static final String TV = "11";//电视剧
    public static final String PANDRAMA = "13";//番剧
    public static final String MOVIES = "23";//电影
    public static final String TECOHNOLGY = "36";//科技
    public static final String GHOT = "119";//鬼畜
    public static final String DANCE = "129";//舞蹈

    //获取用户信息
    public static String USER = "http://api.bilibili.cn/userinfo?mid=5125795";
    //public static String USER = "http://api.bilibili.cn/userinfo?user=莫到家了";

    //主要分类下的前9个热门视频
    public static final String HOT_VIEDO = "http://bilibili-service.daoapp.io/topinfo";
    //各分类下的排行
    //URL:/sort/tid 例如动画 /sort/13
    public static final String TYPE_VIEDO = "http://bilibili-service.daoapp.io/sort/";
    //视频信息获取
    //URL:/view/aid
    public static final String INFO_VIEDO = "http://bilibili-service.daoapp.io/view/";

    public String getVideoInfo(String av) {
        return INFO_VIEDO + av;
    }

    //番剧更新列表
    public static final String BANGUMI = "http://bilibili-service.daoapp.io/bangumi?btype=2";
    //视频地址解析
    public static final String VIDEODOWNLOAD = "http://bilibili-service.daoapp.io/videoflv/";

    //专题信息查看
    //URL   /spinfo/spid    /spinfo/title=""
    public String getTopics(int spid) {
        return BANGUMI + spid;
    }

    public String getTopics(String title) {
        return BANGUMI + "title=" + "[" + title + "]";
    }

    //专题视频获取
    //URL:/spvideos/spid
    private static final String SPVIDEOS = "http://bilibili-service.daoapp.io/spvideos/";

    public String getSpvideos(String spid) {
        return SPVIDEOS + spid;
    }

    //首页热点
    //URL:/indexinfo
    public static final String INDEXINFO = "http://bilibili-service.daoapp.io/indexinfo";

    //获取当前直播信息
    //URL:http://live.bilibili.com/all?ajax=1
    public static final String LIVEINFO = "http://live.bilibili.com/AppIndex/home?_device=android&_hwid=51e96f5f2f54d5f9&_ulv=10000&access_key=563d6046f06289cbdcb472601ce5a761&appkey=c1b107428d337928&build=410000&platform=android&scale=xxhdpi&sign=fbdcfe141853f7e2c84c4d401f6a8758";

    //获取key
    public static final String KEY = "https://passport.bilibili.com/login?act=getkey";

    //登录
    public static final String LOGIN_URL = "https://passport.bilibili.com/login/dologin";

    //搜索
    public static final String SEARCH_URL = "http://bilibili-service.daoapp.io/search";

    //获取弹幕
    public static String getDanmaku(String cid) {
        return "http://comment.bilibili.cn/" + cid + ".xml";
    }

    //获取评论
    public static String getReview(String aid){
        return "http://api.bilibili.cn/feedback?aid="+aid+"&ver=2";
    }

    //获取直播视频
    public static final String LIVEVIDEO = "http://live.bilibili.com/api/playurl?player=1&quality=0&cid=";
}
