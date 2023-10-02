package com.example.loginregister;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;

public class splashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

         new Handler().postDelayed(new Runnable() {
             @Override
             public void run() {
                 Intent starts = new Intent(getApplicationContext(), Login.class);
                 startActivity(starts);
                 finish();
             }
         }, 3000);
    }
}