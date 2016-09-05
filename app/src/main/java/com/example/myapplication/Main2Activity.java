package com.example.myapplication;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONObject;

import java.util.ArrayList;

public class Main2Activity extends ActionBarActivity {
    String pas = "http://118.244.212.82:9092/newsClient/news_list?ver=1&subid=1&dir=1&nid=1&stamp=20140321&cnt=20";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        text4();
    }

    private void text5() {
        RequestQueue queue = Volley.newRequestQueue(this);
        ImageRequest request = new ImageRequest(pas, new Response.Listener<Bitmap>() {
            @Override
            public void onResponse(Bitmap bitmap) {
                Log.e("qqq", bitmap.toString());
            }
        }, 0, 0, Bitmap.Config.RGB_565, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Log.e("qqq", "服务器连接不成功");
            }
        });
        queue.add(request);
    }

    private void text4() {
        RequestQueue queue = Volley.newRequestQueue(this);
        JsonObjectRequest request = new JsonObjectRequest(pas, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject jsonObject) {
                Log.e("sss", jsonObject.toString());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Log.e("sss", "服务器连接不成功");
            }
        });
        queue.add(request);
    }

    private void text3() {
        RequestQueue queue = Volley.newRequestQueue(this);
        StringRequest sReq = new StringRequest(Request.Method.GET, pas, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                Log.e("eee", s);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Log.e("eee", "连接不成功");
            }
        });
        queue.add(sReq);
    }

    private void text2() {
        Gson gson = new Gson();
        ZongClass.book book = new ZongClass.book("java", 30);
        ZongClass.xuesheng xuesheng = new ZongClass.xuesheng("zs", 23);
        ArrayList<ZongClass.xuesheng> lis = new ArrayList<ZongClass.xuesheng>();
        lis.add(xuesheng);
        ZongClass aClass = new ZongClass(book, lis);
        String s = gson.toJson(aClass);
        TextView byId = (TextView) findViewById(R.id.gao);
//        byId.setText(s);
        ZongClass o = gson.fromJson(s, new TypeToken<ZongClass>() {
        }.getType());
        byId.setText(o.toString());
    }

    private void text1() {
        Gson gson = new Gson();
        News xinwen1 = new News("xinwen1");
        Ren ren = new Ren("ok", 1, xinwen1);
        String a = gson.toJson(ren);
        TextView byId = (TextView) findViewById(R.id.gao);
//        byId.setText(a);
        Ren fromJson = gson.fromJson(a, new TypeToken<Ren>() {
        }.getType());
        byId.setText(fromJson.toString());
    }

}
