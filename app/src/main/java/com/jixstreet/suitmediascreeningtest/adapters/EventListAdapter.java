package com.jixstreet.suitmediascreeningtest.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.jixstreet.suitmediascreeningtest.R;
import com.jixstreet.suitmediascreeningtest.models.Event;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by M Agung Satrio - agung.satrio@inmagine.com on 1/20/2016.
 */
public class EventListAdapter extends BaseAdapter {
    private Context context;
    private List<Event> eventList = new ArrayList<>();

    public EventListAdapter(Context context, List<Event> eventList) {
        this.context = context;
        this.eventList = eventList;
    }

    @Override
    public int getCount() {
        return eventList.size();
    }

    @Override
    public Object getItem(int position) {
        return eventList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater mInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        ViewHolder holder;

        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.event_lv_item_layout, null);
            holder = new ViewHolder();

            holder.eventIV = (ImageView) convertView.findViewById(R.id.event_iv);
            holder.eventTitleTV = (TextView) convertView.findViewById(R.id.event_name_tv);
            holder.eventDateTV = (TextView) convertView.findViewById(R.id.event_date_tv);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Picasso.with(context).load(eventList.get(position).getImageURL()).into(holder.eventIV);
        holder.eventTitleTV.setText(eventList.get(position).getName());
        holder.eventDateTV.setText(eventList.get(position).getDate());

        return convertView;
    }

    private class ViewHolder {
        ImageView eventIV;
        TextView eventTitleTV;
        TextView eventDateTV;
    }
}
