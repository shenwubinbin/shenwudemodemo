package com.example.myapplication;


import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by 神武斌斌 on 2016/7/28.
 */
public class Shenwu extends AsyncTask<String,Void,String> {
    TextView txt;
    TextView txt1;
    TextView txt2;
    ImageView img;
public Shenwu(TextView txt,TextView txt1,TextView txt2,ImageView img){
    this.txt=txt;
    this.txt1=txt1;
    this.txt2=txt2;
    this.img=img;
}
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        txt.setTextSize(25);
    }

    @Override
    protected String doInBackground(String... params) {
        HttpURLConnection http = null;
               String it = null;
        try {
            URL url = new URL(params[0]);
            http = (HttpURLConnection) url.openConnection();
            http.setConnectTimeout(500);
            http.setReadTimeout(500);
            http.setRequestMethod("GET");
            Log.e("bbb", "=====" + http);
            int code = http.getResponseCode();
            Log.e("ccc", code + "");
            if (code == HttpURLConnection.HTTP_OK) {
                InputStream ins = http.getInputStream();
                byte[] by = new byte[1024];

                StringBuffer strb = new StringBuffer();
                int lin;
                while ((lin = ins.read(by)) != -1) {
                    it = new String(by, 0, lin);
                    strb.append(it);
                }
                Log.e("aa", strb.toString() + "");
                return  strb.toString();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            http.disconnect();
        }
        return "错误";
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        try {
            JSONObject object = new JSONObject(s);
           String name= object.getString("name");
            String age= object.getString("age");
            String sex= object.getString("sex");
            JSONArray aihao = object.getJSONArray("aihao");
             String ah= aihao.getString(0);
             String ah1= aihao.getString(1);
            txt.setText(name);
            txt.setText(ah1);
            txt.setText(sex);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
