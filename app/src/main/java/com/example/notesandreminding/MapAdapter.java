package com.example.notesandreminding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
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

    public MapAdapter(Map<Long, Note> map) {
        mData = new ArrayList();
        mData.addAll(map.entrySet());
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Map.Entry<Long, Note> getItem(int position) {
        return (Map.Entry) mData.get(position);
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

        Map.Entry<Long, Note> item = getItem(position);
        String tit = item.getValue().getTitle();
        String text = item.getValue().getText();
        int checkBox = item.getValue().getCheckBox();
//        long zero = item.getValue().getCalendar();
        Long date = item.getKey();
        String timeString = " ";
        if (checkBox == 1) {
            Calendar d = Calendar.getInstance();
            d.setTimeInMillis(date);
            Date convertDate = d.getTime();
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy hh:mm");
            timeString = formatter.format(convertDate);
        }


        ((TextView) result.findViewById(R.id.title)).setText(tit);
        ((TextView) result.findViewById(R.id.subtitle)).setText(text);
        ((TextView) result.findViewById(R.id.textdate)).setText(timeString);

        return result;
    }
}