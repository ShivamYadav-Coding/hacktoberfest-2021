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

public class length extends AppCompatActivity {
    Button convert;
    String[] convertarray;
    EditText editText;
    Spinner fromspinner;
    TextView result;
    Spinner tospinner;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_length);
        setContentView(R.layout.activity_length);
        editText = (EditText) findViewById(R.id.edittext);
        convert = (Button) findViewById(R.id.convert);
        result = (TextView) findViewById(R.id.result);
        fromspinner = (Spinner) findViewById(R.id.from);
        tospinner = (Spinner) findViewById(R.id.to);
        convertarray = new String[]{"km", "inch", "cm", "m"};
        ArrayAdapter from = new ArrayAdapter(this, (int) R.layout.support_simple_spinner_dropdown_item,    convertarray);
        fromspinner.setAdapter((SpinnerAdapter) from);
        ArrayAdapter to = new ArrayAdapter(this, (int) R.layout.support_simple_spinner_dropdown_item,    convertarray);
        tospinner.setAdapter((SpinnerAdapter) to);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        convert.setOnClickListener(new View.OnClickListener() {
            /* class com.prateek.convertor.length.AnonymousClass1 */

            public void onClick(View v) {
                if (   fromspinner.getSelectedItem().toString() == "km") {
                    if (   tospinner.getSelectedItem().toString() == "cm") {
                        result.setText(String.valueOf(Double.parseDouble(   editText.getText().toString()) * 100000.0d));
                    } else if (   tospinner.getSelectedItem().toString() == "m") {
                        result.setText(String.valueOf(Double.parseDouble(   editText.getText().toString()) * 1000.0d));
                    } else if (   tospinner.getSelectedItem().toString() == "inch") {
                        result.setText(String.valueOf(39370.1d * Double.parseDouble(   editText.getText().toString())));
                    }
                }
                if (   fromspinner.getSelectedItem().toString() == "cm") {
                    if (   tospinner.getSelectedItem().toString() == "km") {
                        result.setText(String.valueOf(Double.parseDouble(   editText.getText().toString()) / 100000.0d));
                    } else if (   tospinner.getSelectedItem().toString() == "m") {
                        result.setText(String.valueOf(Double.parseDouble(   editText.getText().toString()) / 100.0d));
                    } else if (   tospinner.getSelectedItem().toString() == "inch") {
                        result.setText(String.valueOf(Double.parseDouble(   editText.getText().toString()) / 2.54d));
                    }
                }
                if (   fromspinner.getSelectedItem().toString() == "m") {
                    if (   tospinner.getSelectedItem().toString() == "km") {
                        result.setText(String.valueOf(Double.parseDouble(   editText.getText().toString()) / 1000.0d));
                    } else if (   tospinner.getSelectedItem().toString() == "cm") {
                        result.setText(String.valueOf(100.0d * Double.parseDouble(   editText.getText().toString())));
                    } else if (   tospinner.getSelectedItem().toString() == "inch") {
                        result.setText(String.valueOf(Double.parseDouble(   editText.getText().toString()) * 39.37d));
                    }
                }
                if (   fromspinner.getSelectedItem().toString() != "inch") {
                    return;
                }
                if (   tospinner.getSelectedItem().toString() == "km") {
                    result.setText(String.valueOf(Double.parseDouble(   editText.getText().toString()) / 39370.0d));
                } else if (   tospinner.getSelectedItem().toString() == "m") {
                    result.setText(String.valueOf(Double.parseDouble(   editText.getText().toString()) / 39.37d));
                } else if (   tospinner.getSelectedItem().toString() == "cm") {
                    result.setText(String.valueOf(2.54d * Double.parseDouble(   editText.getText().toString())));
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