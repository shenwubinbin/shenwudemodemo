package com.example.myapplication;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

public class TextActivity extends ActionBarActivity {
    String js="{'name':'zs','age':23,'sex':'男','fu':{'name':'zsf','age':43,'sex':'男'},'mu':['lyf',40,'女']}";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text);
        try {
            JSONObject object = new JSONObject(js);
            String a= object.getString("name");
            String c= object.getString("sex");
            int b=object.getInt("age");
            JSONObject d= object.getJSONObject("fu");
            String e= d.getString("name");
            String f= d.getString("age");
            String g= d.getString("sex");
            Log.e("ssssss",a+b+c+e+f+g+"");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

}
