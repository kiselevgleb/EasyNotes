package com.example.notesandreminding;


import java.util.ArrayList;


public interface NotesRepository {

    public ArrayList<Note> getNotes();

    public void removeNote(Long id);

    public void setNotes(ArrayList<Note> notes);

    public void saveNote(Note n);

    public Note getNote(Long id);

}