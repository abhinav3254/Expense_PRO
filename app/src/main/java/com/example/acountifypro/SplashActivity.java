package com.example.acountifypro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import com.example.acountifypro.databinding.ActivitySplashBinding;

public class SplashActivity extends AppCompatActivity {

    ActivitySplashBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_splash);

        binding = ActivitySplashBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        getSupportActionBar().hide();

//        int secondsDelayed = 1;
//        new Handler().postDelayed(new Runnable() {
//            public void run() {
//                startActivity(new Intent(Splash.this, ActivityB.class));
//                finish();
//            }
//        }, secondsDelayed * 1000);

        int secondsDelayed = 2000;
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashActivity.this,HomeActivity.class));
                finish();
            }
        }, secondsDelayed);

    }
}