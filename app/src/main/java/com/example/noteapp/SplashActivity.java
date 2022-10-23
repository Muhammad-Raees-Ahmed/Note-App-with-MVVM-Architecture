package com.example.noteapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;
import com.example.noteapp.Activity.MainActivity;

public class SplashActivity extends AppCompatActivity {

    Handler handler;
    LottieAnimationView lottieAnimationView;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        lottieAnimationView = findViewById(R.id.animationView);
        textView = findViewById(R.id.textView);


        // hide action bar
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        lottieAnimationView.animate().translationX(1900).setDuration(1500).setStartDelay(2400);
        handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, 3000);
    }
}