package com.example.notesandreminding;

import android.widget.CheckBox;

import java.util.Calendar;

public class Notes {
    String hader;
    String text;
    Calendar calendar;

    public Notes(String hader, String text, Calendar calendar) {
        this.hader = hader;
        this.text = text;
        this.calendar = calendar;
    }

    public String getHader() {
        return hader;
    }

    public void setHader(String hader) {
        this.hader = hader;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Calendar getCalendar() {
        return calendar;
    }

    public void setCalendar(Calendar calendar) {
        this.calendar = calendar;
    }
}
