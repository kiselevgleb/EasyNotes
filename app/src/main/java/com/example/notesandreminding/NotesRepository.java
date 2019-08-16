package com.example.notesandreminding;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class NotesRepository {

    private static ArrayList<Note> notes = new ArrayList<>();


    static void sort() {
        ArrayList<Note> notesWithDL = new ArrayList<>();
        ArrayList<Note> notesWithoutDL = new ArrayList<>();
        for (int i = 0; i < notes.size(); i++) {
            if (notes.get(i).getDeadline() != 0) {
                notesWithDL.add(notes.get(i));
            } else {
                notesWithoutDL.add(notes.get(i));
            }
        }
        Comparator<Note> comNote = new Comparator<Note>() {
            @Override
            public int compare(Note left, Note right) {
                final long diff = left.getDeadline() - right.getDeadline();
                if (diff > 0) {
                    return 1;
                } else if (diff < 0) {
                    return -1;
                } else {
                    return 0;
                }
            }
        };
//        Comparator<Note> comNote = Comparator.comparingLong(Note::getDeadline);
        Collections.sort(notesWithDL, comNote);
        Collections.sort(notesWithoutDL, comNote);
        Collections.reverse(notesWithoutDL);
        notes = new ArrayList<>();
        notes.addAll(notesWithDL);
        notes.addAll(notesWithoutDL);

    }

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
            if (notes.get(i).getId() == noteId) {
                n = notes.get(i);
            }
        }
        return n;
    }


}
