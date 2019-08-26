package com.example.notesandreminding;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.atomic.AtomicLong;

public class NotesRepository extends AppCompatActivity {

    ArrayList<Note> notes = new ArrayList<>();
    AtomicLong idCounter = new AtomicLong();

    private void sort() {
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

    public ArrayList<Note> getNotes() {
        return notes;
    }

    public void removeNote(Long id) {
        notes.remove(getNote(id));
    }

    public void setNotes(ArrayList<Note> notes) {
        this.notes = notes;
    }

    public void saveNote(Note n) {
        if (getNote(n.getId()) != null) {
            removeNote(n.getId());
            notes.add(n);
        } else {
            n.setId(createID());
            notes.add(n);
        }
        sort();
    }


    public Note getNote(Long id) {
        Note n = null;
        for (int i = 0; i < notes.size(); i++) {
            if (notes.get(i).getId() == id) {
                n = notes.get(i);
            }
        }
        return n;
    }

    public synchronized Long createID() {
        return idCounter.getAndIncrement();
    }

    public void saveToDisk(View view, Context context) {
        boolean result = JSONHelper.exportToJSON(context, getNotes());
    }

    public void openToDisk(View view, Context context) {
        ListView lv = (ListView) view;
        if (JSONHelper.importFromJSON(context) != null) {
            setNotes(JSONHelper.importFromJSON(context));
            NotesAct.adapter = new MapAdapter(getNotes());
            lv.setAdapter(NotesAct.adapter);

        } else {
            NotesAct.adapter = new MapAdapter(getNotes());
            lv.setAdapter(NotesAct.adapter);
        }
    }

}
