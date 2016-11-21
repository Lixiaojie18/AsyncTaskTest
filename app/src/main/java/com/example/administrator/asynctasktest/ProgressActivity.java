package com.example.administrator.asynctasktest;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ProgressBar;

public class ProgressActivity extends Activity {
    private ProgressBar pg;
    Progressbar pro;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress);
        pg = (ProgressBar) findViewById(R.id.pg);
        pro = new Progressbar();
        pro.execute();
    }

    @Override
    protected void onPause() {

        super.onPause();
        if (pro != null &&
                pro.getStatus() == AsyncTask.Status.RUNNING) {
            //cancel只是将对应的AsyncTask标记为cancel状态，并不是真正的取消线程的执行。
            pro.cancel(true);
        }
    }

    class Progressbar extends AsyncTask<Void, Integer, Void> {

        @Override
        protected Void doInBackground(Void... params) {
            for (int i = 0; i < 100; i++) {
                if (isCancelled()) {
                    break;
                }
                publishProgress(i);
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            if (isCancelled()) {
                return;
            }
            pg.setProgress(values[0]);
        }
    }
}
