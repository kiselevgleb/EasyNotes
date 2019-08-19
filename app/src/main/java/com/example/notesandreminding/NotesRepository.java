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

        Comparator<Note> comNote = new Comparator<Note>() {
            @Override
            public int compare(Note left, Note right) {
                int comp = 0;

                if (left.getDeadline() != null) {
                    if (right.getDeadline() ==null) {
                        return 1;
                    }
                    else {
                        if (left.getDeadline() > right.getDeadline()) {
                            return -1;
                        } else if (left.getDeadline() < right.getDeadline()) {
                            return 1;
                        }
                    }
                }
//                else {
                    return Long.compare(left.getEditDate(),right.getEditDate());

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
        if (getNote(n.getId())!=null){
            removeNote(n.getId());
            notes.add(n);
        }
        else {
        notes.add(n);}
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


}
