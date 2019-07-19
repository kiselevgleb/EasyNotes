package com.example.notesandreminding;

import java.util.Calendar;

public class Notes {
    String title;
    String text;
    long calendar;

    public Notes(String title, String text, long calendar) {
        this.title = title;
        this.text = text;
        this.calendar = calendar;
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
