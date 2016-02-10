package com.jixstreet.suitmediascreeningtest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import com.jixstreet.suitmediascreeningtest.adapters.EventListAdapter;
import com.jixstreet.suitmediascreeningtest.models.Event;

import java.util.ArrayList;
import java.util.List;

public class EventsActivity extends AppCompatActivity {

    private ListView eventsLV;
    private EventListAdapter mAdapter;
    private List<Event> eventList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initUI();
        setCallBack();
    }

    private void initUI() {
        setContentView(R.layout.activity_events);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));

        eventList = Seeder.getEvents();

        eventsLV = (ListView) findViewById(R.id.event_lv);
        mAdapter = new EventListAdapter(this, Seeder.getEvents());
        eventsLV.setAdapter(mAdapter);

    }

    private void setCallBack() {
        eventsLV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent();
                intent.putExtra(CommonConstant.EVENT, eventList.get(position).getName());
                setResult(RESULT_OK, intent);
                finish();
            }
        });

        findViewById(R.id.back_iv).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
