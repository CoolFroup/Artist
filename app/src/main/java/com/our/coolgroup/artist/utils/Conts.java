package com.our.coolgroup.artist.utils;

/**
 * Created by samsung on 2016/7/26.
 */
public class Conts {
    public final static String URL_SECOND_INDEX = "http://api.jiangwoo.com/api/v2/spaces?page=%d&per_page=10";
    //post
    /**
     * device	Android
     password	huzan0415
     email	18678198980
     version	1.3.0
     */
    public final static String URL_LOGIN = "http://api.jiangwoo.com/api/v1/users/login";
    /***
     * post
     phone	13643811924
     country	CN
     {
     "result": "ok"
     }
     */
    public final static String URL_GETCODE = "http://api.jiangwoo.com/api/v1/users/send_valid_code";
    /**
     *
     * {
     "device": "Android",
     "version": "1.3.0",
     "valid_code": "8763",
     "user": {
     "email": "13643811924",
     "password": "huzan0415",
     "username": "13643811924",
     "country": "CN"
     }
     }
     *
     */
    public final static String URL_REGIST = "http://api.jiangwoo.com/api/v1/users/signup";



    public final static String URL_SECOND_HEAD = "http://www.jiangwoo.com/jiangwoo_space.html";

    public final static String URL_SECOND_DETAIL = "http://api.jiangwoo.com/api/v1/spaces/%d";

    public final static String URL_SECOND_COMMENT = "http://api.jiangwoo.com/api/v2/comments?target_id=%d&target_type=Space&page=1";
}
