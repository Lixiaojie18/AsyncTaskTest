package com.example.administrator.asynctasktest;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class Image_Test extends Activity {
    private static String URL = "http://img.my.csdn.net/uploads/201504/12/1428806103_9476.png";
    private ImageView image;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image__test);
        image = (ImageView) findViewById(R.id.image);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        new AsyncTask_new().execute(URL);//启动异步任务处理
    }
    //匿名内部类
    class AsyncTask_new extends AsyncTask<String,Void,Bitmap>{

        @Override
        protected void onPreExecute() {//准备，初始化一些控件
            super.onPreExecute();
            progressBar.setVisibility(View.VISIBLE);
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {//发送
            super.onPostExecute(bitmap);
            progressBar.setVisibility(View.GONE);
            image.setImageBitmap(bitmap);
        }

        @Override
        protected Bitmap doInBackground(String... params) {//耗时任务处理
            String url = params[0];
            Bitmap bitmap = null;
            URLConnection connection;
            InputStream input;
            try {
                connection = new URL(url).openConnection();
                input = connection.getInputStream();
                BufferedInputStream bis = new BufferedInputStream(input);
                Thread.sleep(3000);
                bitmap = BitmapFactory.decodeStream(bis);
                input.close();
                bis.close();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return bitmap;
        }

        @Override
        protected void onProgressUpdate(Void... values) {//耗时操作的进度
            super.onProgressUpdate(values);
        }
    }
}