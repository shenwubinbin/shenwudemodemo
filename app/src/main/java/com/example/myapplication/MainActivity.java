package com.example.myapplication;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


public class MainActivity extends ActionBarActivity {
    TextView txt;
    TextView txt1;
    TextView txt2;
    ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         txt = (TextView) this.findViewById(R.id.txt);
         txt1 = (TextView) this.findViewById(R.id.txt1);
         txt2 = (TextView) this.findViewById(R.id.txt2);
         img = (ImageView) this.findViewById(R.id.img);
        Shenwu shenwu = new Shenwu(txt,txt1,txt2,img);
        shenwu.execute("http://localhost:8080/shenw/servlet/binbin");
        /*new Thread() {
            @Override
            public void run() {
                super.run();
                wangGET();
            }
        }.start();*/
    }

    public void wangGET() {
        HttpURLConnection http = null;
        // File it=null;
        String it = null;
        try {
            URL url = new URL("http://192.168.1.124:8080/login/Fly?name=swbb&age=23");
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
                    //  it=new File("E:\\aa\\as.txt");
                    it = new String(by, 0, lin);
                    strb.append(it);
                }
                Log.e("aa", strb.toString() + "");
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            http.disconnect();
        }

    }

    public void wangPOST() {
        HttpURLConnection urle = null;
        try {
            URL url = new URL("http://192.168.1.124:8080/login/Fly");
            urle = (HttpURLConnection) url.openConnection();
            urle.setConnectTimeout(5000);
            urle.setReadTimeout(5000);
            urle.setDoOutput(true);
            urle.setRequestMethod("POST");
            OutputStream outputStream = urle.getOutputStream();
            outputStream.write("name=swbb&age=23".getBytes());
            int code = urle.getResponseCode();
            if (code == 200) {
                InputStream stream = urle.getInputStream();
                byte[] bytes = new byte[1024];
                StringBuffer buffer = new StringBuffer();
                int sw;
                while ((sw = stream.read(bytes)) != -1) {
                    String s = new String(bytes, 0, sw);
                    buffer.append(s);
                }
                Log.e("zzz", buffer.toString());
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            urle.disconnect();
        }

    }


}
