package com.jixstreet.suitmediascreeningtest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SecondActivity extends AppCompatActivity {

    private TextView nameTV;
    private String name;
    private Button eventBtn;
    private Button guestBtn;
    private int month;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        handleIntent();
        initUI();
        setCallBack();
        putData();
    }

    private void handleIntent() {
        Intent intent = getIntent();
        name = intent.getStringExtra(CommonConstant.NAME);
    }

    private void initUI() {
        setContentView(R.layout.activity_second);

        nameTV = (TextView) findViewById(R.id.name_tv);
        eventBtn = (Button) findViewById(R.id.event_btn);
        guestBtn = (Button) findViewById(R.id.guest_btn);
    }

    private void setCallBack() {
        eventBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(new Intent(SecondActivity.this, EventsActivity.class), CommonConstant.EVENT_REQUEST_CODE);
            }
        });

        guestBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(new Intent(SecondActivity.this, GuestsActivity.class), CommonConstant.GUEST_REQUEST_CODE);
            }
        });
    }

    private void putData() {
        nameTV.setText(name);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == CommonConstant.EVENT_REQUEST_CODE && resultCode == RESULT_OK) {
            eventBtn.setText(data.getStringExtra(CommonConstant.EVENT));
        } else if (requestCode == CommonConstant.GUEST_REQUEST_CODE && resultCode == RESULT_OK) {
            String birthDate = data.getStringExtra(CommonConstant.BIRTHDATE);
            String textToShow = "Feature Phone";

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date convertedDate = new Date();
            try {
                convertedDate = dateFormat.parse(birthDate);
            } catch (ParseException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            int date = convertedDate.getDate();
            month = convertedDate.getMonth();

            guestBtn.setText(data.getStringExtra(CommonConstant.NAME));

            if (date % 2 == 0) {
                textToShow = "BlackBerry";
            } else if (date % 3 == 0) {
                textToShow = "Android";
            }

            if (date % 2 == 0 && date % 3 == 0) {
                textToShow = "iOS";
            }

            String prime = "NOT PRIME";

            if (isPrime(month))
                prime = "PRIME";

            Toast.makeText(SecondActivity.this, prime, Toast.LENGTH_SHORT).show();
        }
    }

    boolean isPrime(int n) {
        for(int i=2;i<n;i++) {
            if(n%i==0)
                return false;
        }
        return true;
    }
}
