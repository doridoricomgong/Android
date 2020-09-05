package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class JoinActivity extends AppCompatActivity {
    private String ID, PWD;

    Button button3;
    EditText text1, text2, text3;

    Intent mIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join);
        setTitle("create ID/PASSWD");

        button3 = findViewById(R.id.button3);
        text1 = findViewById(R.id.joinid);
        text2 = findViewById(R.id.joinpwd);
        text3 = findViewById(R.id.joinpwdcheck);

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ID = text1.getText().toString();

                if(text2.getText().toString().equals(text3.getText().toString())){
                    PWD = text2.getText().toString();
                    Toast.makeText(getApplicationContext(), "successful", Toast.LENGTH_LONG).show();
                    mIntent = new Intent(JoinActivity.this, MainActivity.class);
                    mIntent.putExtra("ID", ID);
                    mIntent.putExtra("PWD", PWD);

                    startActivity(mIntent);
                }else{
                    ID = null;
                    Toast.makeText(getApplicationContext(), "check again", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}