package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;

import android.widget.TextView;
import android.widget.Toast;

import android.os.Bundle;

import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {
    private Button clearButton;
    private Button calculateButton;
    private TextInputEditText height;
    private TextInputEditText weight;
    private TextView  BMI_display;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        calculateButton = findViewById(R.id.btnCalculate);
        clearButton = findViewById(R.id.btnclear);
        height = findViewById(R.id.height);
        weight = findViewById(R.id.weight);
        BMI_display = findViewById(R.id.BMI);

        calculateButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                double BMI_result = 0.0;
                String h = height.getText().toString().trim();
                String w = weight.getText().toString().trim();
                if (h.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Input Incomplete", Toast.LENGTH_SHORT).show();
                   height.setError("Height required");    return;
                }
                if (w.isEmpty()) {Toast.makeText(MainActivity.this, "Input Incomplete", Toast.LENGTH_SHORT).show();
                    weight.setError("Weight required");    return;}

                  double  input_height = Double.parseDouble(height.getText().toString());
                  double  input_weight = Double.parseDouble(weight.getText().toString());

                 double result = input_weight/(input_height*input_height);
                       result =result*10000;
                String formatted_result= String.format("%.4f", result);
                BMI_display.setText(formatted_result);



            }

        });

        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               height.setText("");
                weight.setText("");
                BMI_display.setText("BMI");

                height.setError(null);
                weight.setError(null);


            }
        });
    }
}
