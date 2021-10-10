package com.example.convertor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

public class volume extends AppCompatActivity {

    Button convert;
    String[] convertarray;
    EditText editText;
    Spinner fromspinner;
    TextView result;
    Spinner tospinner;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volume);
        editText = findViewById(R.id.edittext);
        convert = findViewById(R.id.convert);
        result = findViewById(R.id.result);
        fromspinner = findViewById(R.id.from);
        tospinner = findViewById(R.id.to);
        convertarray = new String[]{"kilometer³", "cm³", "m³", "inch³"};
        ArrayAdapter from = new ArrayAdapter(this, (int) R.layout.support_simple_spinner_dropdown_item,convertarray);
        fromspinner.setAdapter(from);
        ArrayAdapter to = new ArrayAdapter(this, (int) R.layout.support_simple_spinner_dropdown_item,convertarray);
        tospinner.setAdapter(to);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        convert.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                if (   fromspinner.getSelectedItem().toString() == "kilometer³") {
                    if (   tospinner.getSelectedItem().toString() == "cm³") {
                        result.setText(String.valueOf(1.0E15d * Double.parseDouble(   editText.getText().toString())));
                    } else if (   tospinner.getSelectedItem().toString() == "m³") {
                        result.setText(String.valueOf(Double.parseDouble(   editText.getText().toString()) * 1.0E9d));
                    } else if (   tospinner.getSelectedItem().toString() == "inch³") {
                        result.setText(String.valueOf(Double.parseDouble(   editText.getText().toString()) * 6.102E13d));
                    }
                }
                if (   fromspinner.getSelectedItem().toString() == "cm³") {
                    if (   tospinner.getSelectedItem().toString() == "km³") {
                        result.setText(String.valueOf(Double.parseDouble(   editText.getText().toString()) / 1000000.0d));
                    } else if (   tospinner.getSelectedItem().toString() == "m³") {
                        result.setText(String.valueOf(Double.parseDouble(   editText.getText().toString()) / 1000000.0d));
                    } else if (   tospinner.getSelectedItem().toString() == "inch³") {
                        result.setText(String.valueOf(Double.parseDouble(   editText.getText().toString()) / 16.387d));
                    }
                }
                if (   fromspinner.getSelectedItem().toString() == "m³") {
                    if (   tospinner.getSelectedItem().toString() == "km³") {
                        result.setText(String.valueOf(Double.parseDouble(   editText.getText().toString()) / 1.0E9d));
                    } else if (   tospinner.getSelectedItem().toString() == "cm³") {
                        result.setText(String.valueOf(1000000.0d * Double.parseDouble(   editText.getText().toString())));
                    } else if (   tospinner.getSelectedItem().toString() == "inch³") {
                        result.setText(String.valueOf(Double.parseDouble(   editText.getText().toString()) * 61024.0d));
                    }
                }
                if (   fromspinner.getSelectedItem().toString() != "inch³") {
                    return;
                }
                if (   tospinner.getSelectedItem().toString() == "km³") {
                    result.setText(String.valueOf(Double.parseDouble(   editText.getText().toString()) / 6.102E13d));
                } else if (   tospinner.getSelectedItem().toString() == "m³") {
                    result.setText(String.valueOf(Double.parseDouble(   editText.getText().toString()) / 61024.0d));
                } else if (   tospinner.getSelectedItem().toString() == "cm³") {
                    result.setText(String.valueOf(16.387d * Double.parseDouble(   editText.getText().toString())));
                }
            }
        });
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        onBackPressed();
        return true;
    }
}