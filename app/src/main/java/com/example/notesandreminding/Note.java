package com.example.notesandreminding;

import android.widget.CheckBox;

import java.util.Calendar;

public class Note {
    String title;
    String text;
    String calendar;
    int checkBox;

    public int getCheckBox() {
        return checkBox;
    }

    public void setCheckBox(int checkBox) {
        this.checkBox = checkBox;
    }

    public Note(String title, String text, String calendar, int checkBox) {
        this.title = title;
        this.text = text;
        this.calendar = calendar;
        this.checkBox = checkBox;
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

    public String getCalendar() {
        return calendar;
    }

    public void setCalendar(String calendar) {
        this.calendar = calendar;
    }
}
