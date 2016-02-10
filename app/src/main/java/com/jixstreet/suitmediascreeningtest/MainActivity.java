package com.jixstreet.suitmediascreeningtest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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
                String message = "NOT PALINDROME";
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra(CommonConstant.NAME, nameET.getText().toString());
                startActivity(intent);
                if (isPalindrome(nameET.getText().toString())) {
                    message = "PALINDROME";
                }

                Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private static boolean isPalindrome(String words) {
        String name = String.valueOf(words);
        name = name.replace(" ", "");
        int beginNumber = 0;
        int lastNumber = name.length()-1;
        for(int i = beginNumber; i < name.length(); i++) {
            if(name.charAt(beginNumber) != name.charAt(lastNumber)) {
                return false;
            }
            beginNumber++; lastNumber--;
        }
        return true;
    }
}
