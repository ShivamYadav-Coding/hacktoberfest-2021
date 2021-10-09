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

public class temerature extends AppCompatActivity {
    Button convert;
    String[] convertarray;
    EditText editText;
    Spinner fromspinner;
    TextView result;
    Spinner tospinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temerature);
        editText= (EditText) findViewById(R.id.edittext);
        convert = (Button) findViewById(R.id.convert);
        result = (TextView) findViewById(R.id.result);
        fromspinner = (Spinner) findViewById(R.id.from);
        tospinner = (Spinner) findViewById(R.id.to);
        convertarray = new String[]{"f", "k", "r", "re", "c"};
        ArrayAdapter from = new ArrayAdapter(this, (int) R.layout.support_simple_spinner_dropdown_item, convertarray);
        fromspinner.setAdapter((SpinnerAdapter) from);
        ArrayAdapter to = new ArrayAdapter(this, (int) R.layout.support_simple_spinner_dropdown_item, convertarray);
        tospinner.setAdapter((SpinnerAdapter) to);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        convert.setOnClickListener(new View.OnClickListener() {
            /* class com.prateek.convertor.temp.AnonymousClass1 */

            public void onClick(View v) {
                if (fromspinner.getSelectedItem().toString() == "f") {
                    if (tospinner.getSelectedItem().toString() == "k") {
                        result.setText(String.valueOf((Double.parseDouble(editText.getText().toString()) + 459.67d) / 1.8d));
                    } else if (tospinner.getSelectedItem().toString() == "c") {
                        result.setText(String.valueOf((Double.parseDouble(  editText.getText().toString()) - 32.0d) / 1.8d));
                    } else if (  tospinner.getSelectedItem().toString() == "re") {
                        result.setText(String.valueOf((Double.parseDouble(  editText.getText().toString()) - 32.0d) / 2.25d));
                    } else if (  tospinner.getSelectedItem().toString() == "r") {
                        result.setText(String.valueOf(Double.parseDouble(  editText.getText().toString()) + 459.67d));
                    }
                }
                if (  fromspinner.getSelectedItem().toString() == "k") {
                    if (  tospinner.getSelectedItem().toString() == "f") {
                        result.setText(String.valueOf((Double.parseDouble(  editText.getText().toString()) * 1.8d) - 459.67d));
                    } else if (  tospinner.getSelectedItem().toString() == "c") {
                        result.setText(String.valueOf(Double.parseDouble(  editText.getText().toString()) - 273.15d));
                    } else if (  tospinner.getSelectedItem().toString() == "re") {
                        result.setText(String.valueOf((Double.parseDouble(  editText.getText().toString()) - 273.15d) * 0.8d));
                    } else if (  tospinner.getSelectedItem().toString() == "r") {
                        result.setText(String.valueOf(Double.parseDouble(  editText.getText().toString()) * 1.8d));
                    }
                }
                if (  fromspinner.getSelectedItem().toString() == "re") {
                    if (  tospinner.getSelectedItem().toString() == "f") {
                        result.setText(String.valueOf((Double.parseDouble(  editText.getText().toString()) * 2.25d) + 32.0d));
                    } else if (  tospinner.getSelectedItem().toString() == "c") {
                        result.setText(String.valueOf(1.25d * Double.parseDouble(  editText.getText().toString())));
                    } else if (  tospinner.getSelectedItem().toString() == "k") {
                        result.setText(String.valueOf((1.25d * Double.parseDouble(  editText.getText().toString())) + 273.15d));
                    } else if (  tospinner.getSelectedItem().toString() == "r") {
                        result.setText(String.valueOf((Double.parseDouble(  editText.getText().toString()) * 2.25d) + 32.0d + 459.67d));
                    }
                }
                if (  fromspinner.getSelectedItem().toString() == "r") {
                    if (  tospinner.getSelectedItem().toString() == "f") {
                        result.setText(String.valueOf(Double.parseDouble(  editText.getText().toString()) - 459.67d));
                    } else if (  tospinner.getSelectedItem().toString() == "c") {
                        result.setText(String.valueOf(((Double.parseDouble(  editText.getText().toString()) - 32.0d) - 459.67d) / 1.8d));
                    } else if (  tospinner.getSelectedItem().toString() == "re") {
                        result.setText(String.valueOf(((Double.parseDouble(  editText.getText().toString()) - 32.0d) - 459.67d) / 2.25d));
                    } else if (  tospinner.getSelectedItem().toString() == "k") {
                        result.setText(String.valueOf(Double.parseDouble(  editText.getText().toString()) / 1.8d));
                    }
                }
                if (  fromspinner.getSelectedItem().toString() != "c") {
                    return;
                }
                if (  tospinner.getSelectedItem().toString() == "f") {
                    result.setText(String.valueOf((Double.parseDouble(  editText.getText().toString()) * 1.8d) + 32.0d));
                } else if (  tospinner.getSelectedItem().toString() == "r") {
                    result.setText(String.valueOf((Double.parseDouble(  editText.getText().toString()) * 1.8d) + 32.0d + 459.67d));
                } else if (  tospinner.getSelectedItem().toString() == "re") {
                    result.setText(String.valueOf(Double.parseDouble(  editText.getText().toString()) * 0.8d));
                } else if (  tospinner.getSelectedItem().toString() == "k") {
                    result.setText(String.valueOf(273.15d + Double.parseDouble(  editText.getText().toString())));
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