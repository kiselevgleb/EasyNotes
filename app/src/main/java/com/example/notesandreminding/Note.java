package com.example.notesandreminding;

import java.io.Serializable;

public class Note implements Serializable {
    private String title;
    private String text;
    private Long deadline;
    private Long ID;
    private Long editDate;

    public Note(String title, String text, Long deadline, Long id, Long editDate) {
        this.title = title;
        this.text = text;
        this.deadline = deadline;
        this.ID = id;
        this.editDate = editDate;
    }

    public long getEditDate() {
        return editDate;
    }

    public void setEditDate(long editDate) {
        this.editDate = editDate;
    }

    public Long getId() {
        return ID;
    }

    public void setId(Long id) {
        this.ID = id;
    }

    public Long getDeadline() {
        return deadline;
    }

    public void setDeadline(Long deadline) {
        this.deadline = deadline;
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
