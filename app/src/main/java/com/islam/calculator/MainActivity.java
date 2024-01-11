package com.islam.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView text1 ;
    Button butDot;
    boolean isEqual=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text1 = findViewById(R.id.text1);
        butDot=findViewById(R.id.button19);

    }
    public void onClickDigit(View view){
            Button clickButton = ((Button) view);
        if (isEqual) {
            text1.setText(clickButton.getText().toString());
            isEqual=false;
        }else {
            text1.append(clickButton.getText());
    }}
    String savedOperator="";
    String savedResult="";


    public void onOperatorClick (View view) {
        if (!savedOperator.isEmpty() || !text1.getText().toString().isEmpty()){
            String num2 = "";
        if (view instanceof Button) {
            Button clickOperator = ((Button) view);
            if (savedOperator.isEmpty()) {
                savedOperator = clickOperator.getText().toString();
                savedResult = text1.getText().toString();
                text1.setText(null);

            } else {
                num2 = text1.getText().toString();
                savedResult = calculator(savedResult, savedOperator, num2);
                savedOperator = clickOperator.getText().toString();
                text1.setText(null);
            }
        }
        isDot = true;
    }
    }
     private String calculator(String num1 , String operation , String num2){
        if (num1.isEmpty()||operation.isEmpty()||num2.isEmpty()){
            Toast.makeText(this, "Invalid Calculation", Toast.LENGTH_SHORT).show();
            return "";
        }
            double number1=Double.parseDouble(num1);
            double number2=Double.parseDouble(num2);
            double result =0.0;
            if (operation.equals("+")){
                result=number1+number2;

         }else if (operation.equals("-")){
                result=number1-number2;
            }else if (operation.equals("*")){
                result=number1*number2;
            }else if (operation.equals("/")){
                result=number1/number2;
            }else if (operation.equals("%")){
                result=number1%number2;
            }
            return result+"";
     }
    public void onEqualClick (View view){

            String num2 = text1.getText().toString();
            savedResult=calculator(savedResult ,savedOperator ,num2);
            text1.setText(savedResult);
            savedOperator="";
            savedResult="";
            isEqual=true;
            isDot=true;
    }
    boolean isDot=true;
    public void onDotClick (View view){
        Button clickDot= ((Button) view);
        if (isDot){

            if (text1.getText().toString().isEmpty()){
                text1.setText("0");
            }
            text1.append(clickDot.getText().toString());
        }
        isDot=false;
    }
    public void onRemove(View view){
        if (!text1.getText().toString().isEmpty()){
        String tmp = text1.getText().toString();
        tmp=tmp.substring(0,tmp.length()-1);
        text1.setText(tmp);
    }}
    public void onClearClick (View view){
        text1.setText("");
        savedOperator="";
        savedResult="";
        isDot=true;
    }
    public void history(View view){

    }
}