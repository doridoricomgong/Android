package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button button1, button2;
    EditText text1, text2;

    String ID, PWD;

    Intent mIntent ;
    JoinActivity value = new JoinActivity();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Login test!");

        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);

        text1 = findViewById(R.id.mainid);
        text2 = findViewById(R.id.mainpwd);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ID = text1.getText().toString();
                PWD = text2.getText().toString();

                String id = getIntent().getStringExtra("ID");
                String pwd = getIntent().getStringExtra("PWD");

                if(ID.equals(id)){
                    if(PWD.equals(pwd)){
                        //Toast.makeText(getApplicationContext(), "login successful!", Toast.LENGTH_LONG).show();
                        mIntent = new Intent(MainActivity.this, LoginActivity.class);
                        startActivity(mIntent);
                    }else{
                        Toast.makeText(getApplicationContext(), "login failed..", Toast.LENGTH_LONG).show();
                    }
                }else{
                    Toast.makeText(getApplicationContext(), "login failed..", Toast.LENGTH_LONG).show();
                }
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mIntent = new Intent(MainActivity.this, JoinActivity.class);
                startActivity(mIntent);
            }
        });
    }
}