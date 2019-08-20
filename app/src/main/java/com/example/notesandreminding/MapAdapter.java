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
    public ArrayList<Note> mData;
    private static final SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy hh:mm");

    public MapAdapter(ArrayList<Note> list) {
        mData = list;
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Note getItem(int position) {
        return mData.get(position);
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

        Note item = getItem(position);
        String tit = item.getTitle();
        String text = item.getText();
//        boolean checkBox = item.getCheckBox();
        Long date = item.getDeadline();
        Long editTime = item.getEditDate();
        String timeString = " ";
        if (date != null) {
            Calendar d = Calendar.getInstance();
            d.setTimeInMillis(date);
            Date convertDate = d.getTime();
            timeString = formatter.format(convertDate);
        } else {
            Calendar d = Calendar.getInstance();
            d.setTimeInMillis(editTime);
            Date convertDate = d.getTime();
//            timeString = "Edit date " + formatter.format(convertDate);

        }


        TextView title = ((TextView) result.findViewById(R.id.title));
        title.setText(tit);
        if (title.getText().length() == 0) {
            title.setVisibility(View.GONE);
        }
        TextView subtitle = ((TextView) result.findViewById(R.id.subtitle));
        subtitle.setText(text);
        if (subtitle.getText().length() == 0) {
            subtitle.setVisibility(View.GONE);
        }
        TextView textdate = ((TextView) result.findViewById(R.id.textdate));
        textdate.setText(timeString);
        if (textdate.getText() == " ") {
            textdate.setVisibility(View.GONE);
        }
        return result;
    }
}