package com.example.blogapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SignUp extends AppCompatActivity {
    EditText e1,e2,e3,e4;
    AppCompatButton b1,b2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sign_up);
        e1=(EditText) findViewById(R.id.uname);
        e2=(EditText) findViewById(R.id.email);
        e3=(EditText) findViewById(R.id.passw);
        e4=(EditText) findViewById(R.id.passwd);
        b1=(AppCompatButton) findViewById(R.id.signupbtn);
        b2=(AppCompatButton) findViewById(R.id.signoutoutbtn);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View V) {

                String getName=e1.getText().toString();
                String getEmai=e2.getText().toString();
                String getPas=e3.getText().toString();

                Toast.makeText(getApplicationContext(),getName+" "+getName+" "+getEmai+" "+getPas+" ",Toast.LENGTH_LONG).show();



            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences preference = getSharedPreferences("blogapp", MODE_PRIVATE);
                SharedPreferences.Editor editor = preference.edit();
                editor.clear();
                editor.apply();
                Intent i2=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i2);

            }
        });

    }
}