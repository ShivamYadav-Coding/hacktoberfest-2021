package com.example.convertor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.length).setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                MainActivity.this.lengthinput();
            }
        });
        findViewById(R.id.Area).setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                MainActivity.this.areainput();
            }
        });
        findViewById(R.id.Volume).setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                MainActivity.this.volumeinput();
            }
        });
        findViewById(R.id.Currency).setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                MainActivity.this.currencyinput();
            }
        });
        findViewById(R.id.Temp).setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                MainActivity.this.tempinput();
            }
        });
    }
    private void tempinput() {
        startActivity(new Intent(this, temerature.class));
    }
    private void volumeinput() {
        startActivity(new Intent(this, volume.class));
    }
    private void areainput() {
        startActivity(new Intent(this, area.class));
    }
    private void lengthinput() {
        startActivity(new Intent(this, length.class));
    }
    private void currencyinput() {
        startActivity(new Intent(this, currency.class));
    }
}