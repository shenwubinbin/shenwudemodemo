package com.example.myapplication;

/**
 * Created by 神武斌斌 on 2016/8/4.
 */
public class News {
        String xinWen;

    public News(String xinWen) {
        this.xinWen = xinWen;
    }

    @Override
    public String toString() {
        return "News{" +
                "xinWen='" + xinWen + '\'' +
                '}';
    }
}
