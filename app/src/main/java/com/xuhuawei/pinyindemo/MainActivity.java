package com.xuhuawei.pinyindemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.xuhuawei.pinyindemo.views.SpellTextView;

public class MainActivity extends AppCompatActivity {
    private SpellTextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=findViewById(R.id.textView);
        String.format("","");
        textView.postDelayed(new Runnable() {
            @Override
            public void run() {
                textView.setStringResource("许华维");
                textView.setStringColor(0xff000000,0xff000000);
            }
        },1000);


    }
}
