package com.example.blogapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Viewpost extends AppCompatActivity {
    EditText e1;
    AppCompatButton b1,b2,b3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_viewpost);
        e1=(EditText) findViewById(R.id.title);
        b1=(AppCompatButton) findViewById(R.id.viewbtn);
        b2=(AppCompatButton) findViewById(R.id.backbtn);
        b3=(AppCompatButton) findViewById(R.id.signoutoutbtn);
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences preference = getSharedPreferences("blogapp", MODE_PRIVATE);
                SharedPreferences.Editor editor = preference.edit();
                editor.clear();
                editor.apply();
                Intent i8=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i8);

            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1=new Intent(getApplicationContext(),Menu.class);
                startActivity(i1);
            }
        });

    }
}