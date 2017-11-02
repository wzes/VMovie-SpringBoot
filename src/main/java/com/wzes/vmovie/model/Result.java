package com.wzes.vmovie.model;


import com.alibaba.fastjson.JSON;

/**
 * @author Create by xuantang
 * @date on 10/31/17
 */
public class Result {


    public Result(String code, String data) {
        this.code = code;
        this.data = data;
    }

    public Result() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    private String code;

    private String data;

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
