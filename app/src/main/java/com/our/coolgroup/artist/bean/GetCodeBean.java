package com.our.coolgroup.artist.bean;

/**
 * Created by ZAN on 2016/7/27.
 */
public class GetCodeBean {

    /**
     * error_code : 420
     * error : request_too_often_error
     * error_message : 请求过于频繁 验证码请求过于频繁
     */

    private int error_code;
    private String error;
    private String error_message;
    /**
     * result : ok
     */

    private String result;

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getError_message() {
        return error_message;
    }

    public void setError_message(String error_message) {
        this.error_message = error_message;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
