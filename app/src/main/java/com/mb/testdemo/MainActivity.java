package com.mb.testdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("1");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("2");
    }
}
