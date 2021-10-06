package com.example.time;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class HelpActivity extends AppCompatActivity {
    private TextView instruct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_helpactivity);
        instruct= (TextView)  findViewById(R.id.instruction);
        instruct.setText("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tWELCOME...! \n You have 2 buttons:  \n .(1)Start Time \n .(2)End Time \n  ............ When you click (Start time) button then an TimePicker is appear,select the time when you want to silent your phone\n\n\n\n ............And then when you click (End time) button then another TimePicker is appear,select the time when you want to turn your phone on normal mode.");

    }
}
