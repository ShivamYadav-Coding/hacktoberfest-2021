package com.example.convertor;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class currency extends AppCompatActivity {

    Button convert;
    String[] convertarray;
    EditText editText;
    Spinner fromspinner;
    TextView result;
    Spinner tospinner;

    /* access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currency);
        fromspinner = (Spinner) findViewById(R.id.from);
        tospinner = (Spinner) findViewById(R.id.to);
        editText = (EditText) findViewById(R.id.edittext);
        result = (TextView) findViewById(R.id.result);
        convert = (Button) findViewById(R.id.convert);
        convertarray = new String[]{"USD", "INR", "EUR", "NZD"};
        ArrayAdapter from = new ArrayAdapter(this, (int) R.layout.support_simple_spinner_dropdown_item,convertarray);
        fromspinner.setAdapter(from);
        ArrayAdapter to = new ArrayAdapter(this, (int) R.layout.support_simple_spinner_dropdown_item,convertarray);
        tospinner.setAdapter(to);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        convert.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                retrofitinterface retrofitinterface=retrofitbuilder.getRetrofitInstance().create(com.example.convertor.retrofitinterface.class);
                Call<JsonObject> call=retrofitinterface.getExchangeCurrency(fromspinner.getSelectedItem().toString());
                call.enqueue(new Callback<JsonObject>() {
                    @Override
                    public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                        JsonObject res = response.body();
                        JsonObject rates = res.getAsJsonObject("rates");
                        double currency = Double.valueOf(editText.getText().toString());
                        double multiplier = Double.valueOf(rates.get(tospinner.getSelectedItem().toString()).toString());
                        double res1 = currency * multiplier;
                        result.setText(String.valueOf(res1));
                    }

                    @Override
                    public void onFailure(Call<JsonObject> call, Throwable t) {
                    }
                });
            }
        });
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        onBackPressed();
        return true;
    }
}