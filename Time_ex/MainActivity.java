package com.example.timeex;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    Button button;
    TextView textView;

    SimpleDateFormat Format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    SimpleDateFormat Format2 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    SimpleDateFormat Format3 = new SimpleDateFormat("yyyy-MM-dd HH");
    SimpleDateFormat Format4 = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat Format5 = new SimpleDateFormat("yyyy-MM");
    SimpleDateFormat Format6 = new SimpleDateFormat("yyyy");
    String text = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.button);
        textView = (TextView) findViewById(R.id.textView);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // case 1
                long Now = System.currentTimeMillis();

                // case 2
                Date ReDate1 = new Date(Now);
                String formatDate1 = Format1.format(ReDate1);

                // case 3
                Date ReDate2 = new Date(Now);
                String formatDate2 = Format2.format(ReDate2);

                // case 4
                Date ReDate3 = new Date(Now);
                String formatDate3 = Format3.format(ReDate3);

                // case 5
                Date ReDate4 = new Date(Now);
                String formatDate4 = Format4.format(ReDate4);

                // case 6
                Date ReDate5 = new Date(Now);
                String formatDate5 = Format5.format(ReDate5);

                // case 7
                Date ReDate6 = new Date(Now);
                String formatDate6 = Format6.format(ReDate6);

                text = "case 1 : " + Now + "\n" + "case 2 : " + formatDate1 + "\n" + "case 3 : " + formatDate2 + "\n"
                        + "case 4 : " + formatDate3 + "\n" + "case 5 : " + formatDate4 + "\n" + "case 6 : " + formatDate5
                        + "\n" + "case 7 : " + formatDate6 + "\n";
                textView.setText(text);
            }
        });
    }
}