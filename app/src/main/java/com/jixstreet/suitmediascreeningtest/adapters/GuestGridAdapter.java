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
import com.jixstreet.suitmediascreeningtest.models.Guest;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by M Agung Satrio - agung.satrio@inmagine.com on 1/20/2016.
 */
public class GuestGridAdapter extends BaseAdapter {
    private Context context;
    private List<Guest> guestList = new ArrayList<>();

    public GuestGridAdapter(Context context, List<Guest> guestList) {
        this.context = context;
        this.guestList = guestList;
    }

    @Override
    public int getCount() {
        return guestList.size();
    }

    @Override
    public Object getItem(int position) {
        return guestList.get(position);
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
            convertView = mInflater.inflate(R.layout.guest_gv_item_layout, null);
            holder = new ViewHolder();

            holder.guestNameTV = (TextView) convertView.findViewById(R.id.guest_name_tv);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.guestNameTV.setText(guestList.get(position).getName());

        return convertView;
    }

    public void updateContent(List<Guest> guestList) {
        this.guestList = guestList;
        notifyDataSetChanged();
    }

    private class ViewHolder {
        TextView guestNameTV;
    }
}
