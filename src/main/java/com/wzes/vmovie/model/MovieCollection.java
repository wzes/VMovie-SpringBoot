package com.wzes.vmovie.model;

import com.alibaba.fastjson.JSON;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Create by xuantang
 * @date on 10/31/17
 */

public class MovieCollection {

    private String username;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    private String data;

    public String getMovie_id() {
        return movie_id;
    }

    public void setMovie_id(String movie_id) {
        this.movie_id = movie_id;
    }

    private String movie_id;

    public MovieCollection(String username, String movie_id, String data) {
        this.username = username;
        this.movie_id = movie_id;
        this.data = data;
    }

    public MovieCollection() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }



    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
