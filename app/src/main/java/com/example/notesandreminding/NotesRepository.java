package com.example.notesandreminding;

import java.util.HashMap;

public class NotesRepository {

    private static HashMap<Long, Note> notes = new HashMap<>();

    public static HashMap<Long, Note> getNotes() {
        return notes;
    }

    public static void removeNote(Long noteId) {
        notes.remove(noteId);
    }

    public static void saveNote(Long l, Note n) {
        notes.put(l, n);
    }

    public static Note getNote(Long noteId) {
        return notes.get(noteId);
    }
}
