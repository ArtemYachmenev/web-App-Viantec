package com.viantec.web;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class WebActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);

        TextView title=findViewById(R.id.titleTextView);


        Intent intent=getIntent();
        if (intent!=null){
            title.setText(intent.getStringExtra("title"));

        }
    }
}