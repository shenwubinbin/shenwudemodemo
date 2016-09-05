package com.example.myapplication;

import java.util.List;

/**
 * Created by 神武斌斌 on 2016/8/4.
 */
public class ZongClass {
    book book;
//    xuesheng xuesheng;
    List<xuesheng> list;

    public ZongClass(ZongClass.book book,  List<xuesheng> list) {
        this.book = book;
        this.list = list;
    }

    @Override
    public String toString() {
        return "ZongClass{" +
                "book=" + book +
                ", xuesheng=" + list +
                '}';
    }

    public static  class book{
        String name;
        int   price;

        public book(String name, int price) {
            this.name = name;
            this.price = price;
        }

        @Override
        public String toString() {
            return "book{" +
                    "name='" + name + '\'' +
                    ", price=" + price +
                    '}';
        }
    }
    public static class xuesheng{
        String name;
        int age;

        public xuesheng(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "xuesheng{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
}
