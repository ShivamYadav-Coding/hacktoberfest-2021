package com.example.time;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

public class splashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        new Handler().postDelayed(new Runnable() {

// Using handler with postDelayed called runnable run method

            @Override

            public void run() {

                Intent i = new Intent(splashActivity.this, MainActivity.class);

                startActivity(i);

                // close this activity

                finish();

            }

        }, 5*1000); // wait for 5 seconds
    }
}
