package com.jixstreet.suitmediascreeningtest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText nameET;
    private Button nextBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initUI();
        setCallBack();
    }

    private void initUI() {
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        nameET = (EditText) findViewById(R.id.name_et);
        nextBtn = (Button) findViewById(R.id.next_btn);
    }

    private void setCallBack() {
        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra(CommonConstant.NAME, nameET.getText().toString());
                startActivity(intent);
            }
        });
    }
}
