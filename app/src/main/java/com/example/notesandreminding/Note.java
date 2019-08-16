package com.example.notesandreminding;

import java.io.Serializable;

public class Note implements Serializable {
    private String title;
    private String text;
    private Long deadline;
    private boolean checkBoxIsChecked;
    private Long id;
    private Long editDate;

    public Note(String title, String text, Long deadline, boolean checkBoxIsChecked, Long id, Long editDate) {
        this.title = title;
        this.text = text;
        this.deadline = deadline;
        this.checkBoxIsChecked = checkBoxIsChecked;
        this.id = id;
        this.editDate = editDate;
    }

    public long getEditDate() {
        return editDate;
    }

    public void setEditDate(long editDate) {
        this.editDate = editDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Long getDeadline() {
        return deadline;
    }

    public void setDeadline(Long deadline) {
        this.deadline = deadline;
    }

    public boolean getCheckBoxIsChecked() {
        return checkBoxIsChecked;
    }

    public void setCheckBoxIsChecked(boolean checkBoxIsChecked) {
        this.checkBoxIsChecked = checkBoxIsChecked;
    }


    public boolean getCheckBox() {
        return checkBoxIsChecked;
    }

    public void setCheckBox(boolean checkBox) {
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
