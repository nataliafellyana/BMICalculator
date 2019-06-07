package com.example.bmicounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText height;
    private EditText weight;
    private TextView result;
    private Button calculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        height = (EditText)findViewById(R.id.height);
        weight = (EditText)findViewById(R.id.weight);
        result = (TextView)findViewById(R.id.result);
        calculate = (Button)findViewById(R.id.calculate);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateBMI();
            }
        });

    }
    public void calculateBMI(){
        String heightS = height.getText().toString();
        String weightS = weight.getText().toString();

        if(heightS != null && !"".equals(heightS) && weightS!=null && !"".equals(weightS)){
            float heightVal = Float.parseFloat(heightS)/100;
            float weightVal = Float.parseFloat(weightS);

            float hasil = weightVal / (heightVal * heightVal);

            displayBMI(hasil);
        }
    }

    public void displayBMI(float hasil){
        String bmiName="";

        if(Float.compare(hasil, 15f)<=0){
            bmiName= "Very Severely Underweight";
        }
        else if(Float.compare(hasil, 15f)>0 && Float.compare(hasil, 16f)<=0){
            bmiName="Severely Underweight";
        }
        else if(Float.compare(hasil, 16f)>0 && Float.compare(hasil, 18.5f)<=0){
            bmiName="Underweight";
        }
        else if(Float.compare(hasil, 18.5f)>0 && Float.compare(hasil, 25f)<=0){
            bmiName="Normal";
        }
        else if(Float.compare(hasil, 25f)>0 && Float.compare(hasil, 30f)<=0){
            bmiName="Overweight";
        }
        else if(Float.compare(hasil, 30f)>0 && Float.compare(hasil, 35f)<=0){
            bmiName="Obese Class I";
        }
        else if(Float.compare(hasil, 35f)>0 && Float.compare(hasil, 40f)<=0){
            bmiName="Obese Class II";
        }
        else {
            bmiName="Obese Class III";
        }

        bmiName = hasil + "\n" + bmiName;
        result.setText(bmiName);

    }
}