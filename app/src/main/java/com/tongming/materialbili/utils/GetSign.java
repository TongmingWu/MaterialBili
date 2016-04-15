package com.tongming.materialbili.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by Tongming on 2016/2/13.
 * md5加密
 */
class GetSign {

    private static String appkey = BilibiliKeyUtil.APP_KEY;
    private static String secretKey = BilibiliKeyUtil.SECRETKEY;
    public static String encode(String cid){
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] digest = md.digest(("appkey="+appkey
                    +"&cid="+cid+secretKey).getBytes());

            StringBuilder sign_this = new StringBuilder();
            for(byte b : digest){
                int i = b & 0xff;
                String hex = Integer.toHexString(i);

                if(hex.length()<2){
                    hex = "0" + hex;
                }
                sign_this.append(hex);
            }
            return "http://interface.bilibili.com/playurl?appkey="+
                    appkey+"&cid="+cid+"&sign="+sign_this.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }
}
