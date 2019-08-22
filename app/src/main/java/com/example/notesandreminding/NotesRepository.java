package com.example.notesandreminding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.atomic.AtomicLong;

public class NotesRepository {

    private static ArrayList<Note> notes = new ArrayList<>();
    private static AtomicLong idCounter = new AtomicLong();
    private static App a;

    public NotesRepository() {
        loadNotes();
    }
    public NotesRepository(App app) {
        loadNotes();
    }


    public static NotesRepository loadNotes() {
        return a.getNoteRepository();
    }

    private static void sort() {
        Comparator<Note> comNote = new Comparator<Note>() {
            @Override
            public int compare(Note left, Note right) {

                if (left.getDeadline() == null) {
                    if (right.getDeadline() != null) {
                        return 1;
                    } else {
                        return Long.compare(right.getEditDate(), left.getEditDate());
                    }
                } else {
                    if (right.getDeadline() == null) {
                        return -1;
                    } else {
                        if (left.getDeadline() < right.getDeadline()) {
                            return -1;
                        } else if (left.getDeadline() > right.getDeadline()) {
                            return 1;
                        } else {
                            return Long.compare(right.getEditDate(), left.getEditDate());
                        }
                    }
                }
            }
        };

        Collections.sort(notes, comNote);
    }

    public static ArrayList<Note> getNotes() {
        return notes;
    }

    public static void removeNote(Long id) {
        notes.remove(getNote(id));
    }

    public static void saveNote(Note n) {
        if (getNote(n.getId()) != null) {
            removeNote(n.getId());
            notes.add(n);
        } else {
            n.setId(createID());
            notes.add(n);
        }
        sort();
        a = new App();
        a.onCreate();
    }


    public static Note getNote(Long id) {
        Note n = null;
        for (int i = 0; i < notes.size(); i++) {
            if (notes.get(i).getId() == id) {
                n = notes.get(i);
            }
        }
        return n;
    }

    public static synchronized Long createID() {
        return idCounter.getAndIncrement();
    }


}
