package com.example.notesandreminding;

import java.util.Calendar;

public class Note {
    String title;
    String text;
    String calendar;

    public Note(String title, String text, String calendar) {
        this.title = title;
        this.text = text;
        this.calendar = calendar;
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
