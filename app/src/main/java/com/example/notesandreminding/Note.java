package com.example.notesandreminding;

public class Note {
    String title;
    String text;
    long deadline;
    int checkBoxIsChecked;

    public long getDeadline() {
        return deadline;
    }

    public void setDeadline(long deadline) {
        this.deadline = deadline;
    }

    public int getCheckBoxIsChecked() {
        return checkBoxIsChecked;
    }

    public void setCheckBoxIsChecked(int checkBoxIsChecked) {
        this.checkBoxIsChecked = checkBoxIsChecked;
    }

    public Note(String title, String text, long deadline, int checkBoxIsChecked) {
        this.title = title;
        this.text = text;
        this.deadline = deadline;
        this.checkBoxIsChecked = checkBoxIsChecked;
    }

    public int getCheckBox() {
        return checkBoxIsChecked;
    }

    public void setCheckBox(int checkBox) {
        this.checkBoxIsChecked = checkBox;
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

}
