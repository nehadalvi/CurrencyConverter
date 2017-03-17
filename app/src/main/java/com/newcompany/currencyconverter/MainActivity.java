/*
Assignment # 1
File Name: HW1_Student800970459_.zip
Name: Neha Dalvi
*/
package com.newcompany.currencyconverter;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity{


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_new);

        final EditText input = (EditText) findViewById(R.id.inputAmount);
        final TextView output = (TextView) findViewById(R.id.resultAmount);
        final RadioGroup convertFromRg = (RadioGroup) findViewById(R.id.radioGroupConvertFrom);
        final RadioGroup convertToRg = (RadioGroup) findViewById(R.id.radioGroupConvertTo);
        Button convertBtn = (Button) findViewById(R.id.buttonConvert);

        convertBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                float result;
                int convertFrom = convertFromRg.getCheckedRadioButtonId();
                int convertTo = convertToRg.getCheckedRadioButtonId();

                Log.d("demo","Value is"+input.getText().toString());

                if(input.getText().toString().equals("") || input.getText().toString().equals(".")){
                    Context context = getApplicationContext();
                    CharSequence text = "Invalid input";
                    int duration = Toast.LENGTH_SHORT;

                    Toast.makeText(context,text,duration).show();
                }

                else {

                    if (convertFrom == R.id.radioAud) {
                        if (convertTo == R.id.radioUsd) {
                            result = (float) (Double.parseDouble(input.getText().toString()) / 1.34);
                            double roundOff = Math.round(result * 100.0) / 100.0;
                            Log.d("demo", "" + result);
                            output.setText(String.valueOf(roundOff));
                        } else if (convertTo == R.id.radioGbp) {
                            result = (float) (Double.parseDouble(input.getText().toString()) * 0.83 / 1.34);
                            double roundOff = Math.round(result * 100.0) / 100.0;
                            Log.d("demo", "" + result);
                            output.setText(String.valueOf(roundOff));
                        } else if (convertTo == -1) {
                            output.setText(String.valueOf(input.getText()));
                        }
                    } else if (convertFrom == R.id.radioCad) {
                        if (convertTo == R.id.radioUsd) {
                            result = (float) (Double.parseDouble(input.getText().toString()) / 1.32);
                            double roundOff = Math.round(result * 100.0) / 100.0;
                            Log.d("demo", "" + result);
                            output.setText(String.valueOf(roundOff));
                        } else if (convertTo == R.id.radioGbp) {
                            result = (float) (Double.parseDouble(input.getText().toString()) * 0.83 / 1.32);
                            double roundOff = Math.round(result * 100.0) / 100.0;
                            Log.d("demo", "" + result);
                            output.setText(String.valueOf(roundOff));
                        } else if (convertTo == -1) {
                            output.setText(String.valueOf(input.getText()));
                        }
                    } else if (convertFrom == R.id.radioInr) {
                        if (convertTo == R.id.radioUsd) {
                            result = (float) (Double.parseDouble(input.getText().toString()) / 68.14);
                            double roundOff = Math.round(result * 100.0) / 100.0;
                            Log.d("demo", "" + result);
                            output.setText(String.valueOf(roundOff));
                        } else if (convertTo == R.id.radioGbp) {
                            result = (float) (Double.parseDouble(input.getText().toString()) * 0.83 / 68.14);
                            double roundOff = Math.round(result * 100.0) / 100.0;
                            Log.d("demo", "" + result);
                            output.setText(String.valueOf(roundOff));
                        } else if (convertTo == -1) {
                            output.setText(String.valueOf(input.getText()));
                        }
                    } else if (convertFrom == -1 && convertTo == -1)
                        output.setText(" ");
                }
            }
        });
    }

    public void onClear(View v){
        EditText input = (EditText) findViewById(R.id.inputAmount);
        TextView output = (TextView) findViewById(R.id.resultAmount);
        RadioGroup convertFromRg = (RadioGroup) findViewById(R.id.radioGroupConvertFrom);
        RadioGroup convertToRg = (RadioGroup) findViewById(R.id.radioGroupConvertTo);
        input.setText(" ");
        input.setHint("Input Amount");
        output.setText(" ");
        if(convertFromRg != null)
            convertFromRg.clearCheck();
        if(convertToRg != null)
            convertToRg.clearCheck();
    }

}
