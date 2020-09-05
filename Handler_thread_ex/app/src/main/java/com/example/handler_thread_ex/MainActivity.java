package com.example.handler_thread_ex;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView Thread1_Text;
    TextView Thread2_Text;
    Button btn_start;
    Button btn_stop;
    boolean isthread = false;

    MyHandler handler = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Thread example! (use handler)");

        Thread1_Text = (TextView) findViewById(R.id.main);
        Thread2_Text = (TextView) findViewById(R.id.sub);
        btn_start = (Button) findViewById(R.id.start);
        btn_stop = (Button) findViewById(R.id.stop);

        handler = new MyHandler();

        // Thread Start
        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isthread = true;

                Thread thread1 = new Thread(){
                    @Override
                    public void run() {
                        while (isthread){
                            handler.sendEmptyMessage(1);
                            try {
                                sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                };

                Thread thread2 = new Thread(){
                    @Override
                    public void run() {
                        while (isthread){
                            handler.sendEmptyMessage(2);
                            try {
                                sleep(3000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                };

                thread1.start();
                thread2.start();
            }
        });

        // Thread Stop
        btn_stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isthread = false;
            }
        });
    }

    class MyHandler extends Handler {
        int count1 = 0;
        int count2 = 0;
        @Override
        public void handleMessage(@NonNull Message msg) {
            switch (msg.what) {
                case 1:
                    Thread1_Text.setText(String.valueOf(count1));
                    count1++;
                    break;
                case 2:
                    Thread2_Text.setText(String.valueOf(count2));
                    count2++;
                    break;
                default:
            }
        }
    }

    ;
}

