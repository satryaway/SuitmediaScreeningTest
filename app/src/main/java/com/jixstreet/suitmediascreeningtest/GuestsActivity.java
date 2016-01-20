package com.jixstreet.suitmediascreeningtest;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.jixstreet.suitmediascreeningtest.adapters.EventListAdapter;
import com.jixstreet.suitmediascreeningtest.adapters.GuestGridAdapter;
import com.jixstreet.suitmediascreeningtest.models.Event;
import com.jixstreet.suitmediascreeningtest.models.Guest;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import cz.msebera.android.httpclient.Header;

public class GuestsActivity extends AppCompatActivity {

    private GridView guestsGV;
    private GuestGridAdapter mAdapter;
    private List<Guest> guestList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initUI();
        setCallBack();
        getData();
    }

    private void initUI() {
        setContentView(R.layout.activity_guests);

        guestsGV = (GridView) findViewById(R.id.guests_gv);
        mAdapter = new GuestGridAdapter(this, new ArrayList<Guest>());
        guestsGV.setAdapter(mAdapter);
    }

    private void setCallBack() {
        guestsGV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent();
                intent.putExtra(CommonConstant.NAME, guestList.get(position).getName());
                intent.putExtra(CommonConstant.BIRTHDATE, guestList.get(position).getBirthdate());
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }

    private void getData() {
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage(getString(R.string.please_wait));

        AsyncHttpClient client = new AsyncHttpClient();
        client.get("http://dry-sierra-6832.herokuapp.com/api/people", null, new JsonHttpResponseHandler() {
            @Override
            public void onStart() {
                super.onStart();
                progressDialog.show();
            }

            @Override
            public void onFinish() {
                super.onFinish();
                progressDialog.hide();
            }


            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONArray response) {
                putData(response);
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                Toast.makeText(GuestsActivity.this, "Request Timed Out", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                Toast.makeText(GuestsActivity.this, "Servers are temporary down", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void putData(JSONArray response) {
        try {
            for (int i = 0; i < response.length(); i++) {
                Guest guest = new Guest();
                JSONObject object = response.getJSONObject(i);
                guest.setId(object.getInt(CommonConstant.ID));
                guest.setName(object.getString(CommonConstant.NAME));
                guest.setBirthdate(object.getString(CommonConstant.BIRTHDATE));

                guestList.add(guest);
            }

            mAdapter.updateContent(guestList);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
