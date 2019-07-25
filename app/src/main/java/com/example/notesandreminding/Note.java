package com.example.notesandreminding;

import android.widget.CheckBox;

import java.util.Calendar;

public class Note {
    String title;
    String text;
    long calendar;
    int checkBoxIsChecked;


    public int getCheckBox() {
        return checkBoxIsChecked;
    }

    public void setCheckBox(int checkBox) {
        this.checkBoxIsChecked = checkBox;
    }

    public Note(String title, String text, long calendar, int checkBox) {
        this.title = title;
        this.text = text;
        this.calendar = calendar;
        this.checkBoxIsChecked = checkBox;
    }

    public Note(String title, String text) {
        this.title = title;
        this.text = text;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public long getCalendar() {
        return calendar;
    }

    public void setCalendar(long calendar) {
        this.calendar = calendar;
    }
}
