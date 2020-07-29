package com.example.lifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i("lifecycle", "onCreate()");
        Toast.makeText(this, "onCreate()", Toast.LENGTH_SHORT).show();

        button = (Button) findViewById(R.id.button);    // Activity의 구성요소를 초기화 하는 코드
    }

    @Override
    protected void onStart() {
        super.onStart();

        Log.i("lifecycle", "onStart()");
        Toast.makeText(this, "onStart()", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();

        Log.i("lifecycle", "onRestart()");
        Toast.makeText(this, "onRestart()", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();

        Log.i("lifecycle", "onStop()");
        Toast.makeText(this, "onStop()", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Log.i("lifecycle", "onDestroy()");
        Toast.makeText(this, "onDestroy()", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();

        Log.i("lifecycle", "onPause()");
        Toast.makeText(this, "onPause()", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {     // 사용자와 상호작용하는 코드 작성 ex) Touch event
        super.onResume();

        Log.i("lifecycle", "onResume()");
        Toast.makeText(this, "onResume()", Toast.LENGTH_SHORT).show();

        button.setOnClickListener(new View.OnClickListener() {  // button을 클릭하는 경우
            @Override
            public void onClick(View view) {
                // 다음 화면으로 넘어가는 코드 구현
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(intent);
            }
        });
    }
}