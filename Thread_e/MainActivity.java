package com.example.thread_ex;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView Thread1_Text;
    TextView Thread2_Text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Thread example!");


        Thread1_Text = findViewById(R.id.main);
        Thread2_Text = findViewById(R.id.sub);

        Thread1 t1 = new Thread1();
        t1.start();

        Thread2 t2 = new Thread2();
        t2.start();
    }

    class Thread1 extends Thread {
        public void run() {
            for (int i = 0; ; i++) {
                try {
                    Thread.sleep(1000);
                    Thread1_Text.setText(String.valueOf(i));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    class Thread2 extends Thread {
        public void run() {
            for (int i = 0; ; i++) {
                try {
                    Thread.sleep(3000);
                    Thread2_Text.setText(String.valueOf(i));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

