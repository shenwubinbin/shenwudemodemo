package com.example.myapplication;

/**
 * Created by 神武斌斌 on 2016/8/4.
 */
public class Ren {
    String xinXi;
    int banBen;
    News news;

    public Ren(String xinXi, int banBen, News news) {
        this.xinXi = xinXi;
        this.banBen = banBen;
        this.news = news;
    }

    @Override
    public String toString() {
        return "Ren{" +
                "xinXi='" + xinXi + '\'' +
                ", banBen=" + banBen +
                ", news=" + news +
                '}';
    }
}
