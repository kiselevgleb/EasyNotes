package com.example.notesandreminding;

import android.content.Context;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.atomic.AtomicLong;

public interface NotesRepository {
    ArrayList<Note> notes = new ArrayList<>();
    AtomicLong idCounter = new AtomicLong();
    FileDateSource fds = null;

    void sort();

    public ArrayList<Note> getNotes();

    public void removeNote(Long id);

    public void setNotes(ArrayList<Note> notes);

    public void saveNote(Note n);

    public Note getNote(Long id);

    public Long createID();

    void saveToDisk();

}