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

    public static ArrayList<Note> notes = new ArrayList<>();

    @RequiresApi(api = Build.VERSION_CODES.N)
    public static void sort() {
        ArrayList<Note> notesWithDL = new ArrayList<>();
        ArrayList<Note> notesWithoutDL = new ArrayList<>();
        for (int i = 0; i < notes.size(); i++) {
            if (notes.get(i).getDeadline() < 34712658000000L) {
                notesWithDL.add(notes.get(i));
            } else {
                notesWithoutDL.add(notes.get(i));
            }
        }
        Comparator<Note> comNote = Comparator.comparingLong(Note::getDeadline);
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
            if (notes.get(i).getDeadline() == noteId) {
                n = notes.get(i);
            }
        }
        return n;
    }


}
