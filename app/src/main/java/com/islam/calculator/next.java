package com.islam.calculator;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class next extends AppCompatActivity implements View.OnClickListener{
   Button next  ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.next);
        next=findViewById(R.id.next1);
        next.setOnClickListener(this) ;
    }

    @Override
    public void onClick(View view) {
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}
