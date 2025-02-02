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

public class MainActivity extends AppCompatActivity {
    EditText e1,e2;
    AppCompatButton b1,b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        SharedPreferences preference = getSharedPreferences("blogapp", MODE_PRIVATE);
        String username= preference.getString("user",null);
        if(username!=null)
        {
            Intent i2=new Intent(getApplicationContext(),Menu.class);
            startActivity(i2);
        }

        e1=(EditText) findViewById(R.id.uname);
        e2=(EditText) findViewById(R.id.pass);
        b1=(AppCompatButton) findViewById(R.id.sinbtn);
        b2=(AppCompatButton) findViewById(R.id.supbtn);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1=new Intent(getApplicationContext(),SignUp.class);
                startActivity(i1);
            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String getUname = e1.getText().toString();
                    String getPass = e2.getText().toString();
                    if (getUname.equals("admin") && getPass.equals("12345")) {
                        SharedPreferences preference = getSharedPreferences("blogapp", MODE_PRIVATE);
                        SharedPreferences.Editor editor = preference.edit();
                        editor.putString("user", "admin");
                        editor.apply();
                        Intent i1 = new Intent(getApplicationContext(), Menu.class);
                        startActivity(i1);
                    }
                    else {
                        Toast.makeText(getApplicationContext(), "Invalid Credentials", Toast.LENGTH_LONG).show();
                    }
                }
                catch(Exception e)
                {
                    Toast.makeText(getApplicationContext(),e.toString(),Toast.LENGTH_LONG).show();
                }



            }
        });

    }
}