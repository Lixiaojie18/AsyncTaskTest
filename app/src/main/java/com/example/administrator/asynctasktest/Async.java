package com.example.administrator.asynctasktest;

import android.os.AsyncTask;
import android.util.Log;

/**
 * Created by ${Administrator} on 2016/11/18 0018.
 */

public class Async extends AsyncTask<Void,Void,Void> {
    @Override
    protected Void doInBackground(Void... params) {//耗时操作
        Log.d("x", "doInBackground: **************");
        publishProgress();
        return null;
    }

    @Override
    protected void onPreExecute() {//准备，比如：初始化控件
        super.onPreExecute();
        Log.d("x", "onPreExecute: ***************");
    }

    @Override
    protected void onPostExecute(Void aVoid) {//发送
        super.onPostExecute(aVoid);
        Log.d("x", "onPostExecute: ***************");
    }

    @Override
    protected void onProgressUpdate(Void... values) {//任务的进度
        super.onProgressUpdate(values);
        Log.d("x", "onProgressUpdate: **************");
    }
}
