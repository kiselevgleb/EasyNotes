package com.example.notesandreminding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class MapAdapter extends BaseAdapter {
    public static ArrayList mData;
    public static ArrayList<String> listLongD;

    public MapAdapter(Map<String, String> map, ArrayList<String> listLongDate) {
        mData = new ArrayList();
        mData.addAll(map.entrySet());
        listLongD = listLongDate;
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Map.Entry<String, String> getItem(int position) {
        return (Map.Entry) mData.get(position);
    }

    public String getItemLong(int position) {
        return (String) listLongD.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final View result;

        if (convertView == null) {
            result = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        } else {
            result = convertView;
        }

        Map.Entry<String, String> item = getItem(position);
        String c = getItemLong(position);
        DateFormat formatter = new SimpleDateFormat("dd/MM/yy hh:mm");
        String time = c;

        ((TextView) result.findViewById(R.id.title)).setText(item.getKey());
        ((TextView) result.findViewById(R.id.subtitle)).setText(item.getValue());
        ((TextView) result.findViewById(R.id.textdate)).setText(time);

        return result;
    }
}