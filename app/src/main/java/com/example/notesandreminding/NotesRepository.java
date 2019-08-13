package com.example.notesandreminding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class NotesRepository {

    private static ArrayList<Note> notes = new ArrayList<>();

    //    Comparator<Note> compNote = new Comparator<Note>() {
//        @Override
//        public int compare(Note o1, Note o2) {
//
//            return (int) o1.getDeadline()-o2.getDeadline();
//        }
//    };
//    Collections.sort(notes, compNote);
//
    public static ArrayList<Note> getNotes() {
        return notes;
    }

    public static void removeNote(Note n) {
        notes.remove(n);
    }

    public static void saveNote(Note n) {
        notes.add(n);
    }

    public static Note getNote(Long noteId) {
        Note n = null;
        for (int i = 0; i < notes.size(); i++) {
            if (notes.get(i).getDeadline() == noteId) {
                n = notes.get(i);
            }
        }
        return n;
    }
}
