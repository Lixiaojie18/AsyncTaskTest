package com.example.administrator.asynctasktest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Async async = new Async();
        async.execute();
    }

    public void click(View view) {
        startActivity(new Intent(this,Image_Test.class));
    }

    public void loadingImage(View view) {
        startActivity(new Intent(this,ProgressActivity.class));
    }
}
