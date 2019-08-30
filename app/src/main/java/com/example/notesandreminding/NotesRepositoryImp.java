package com.example.notesandreminding;

import android.content.Context;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.atomic.AtomicLong;

public class NotesRepositoryImp implements NotesRepository {

    private ArrayList<Note> notes = new ArrayList<>();
    private AtomicLong idCounter = new AtomicLong();
    private FileDateSource fds = null;

    public NotesRepositoryImp(Context context) {
        fds = new FileDateSource(context);

        setNotes(fds.load());
    }

    public void sort() {
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
        saveToDisk();
    }


    public Note getNote(Long id) {
        Note n = null;
        for (int i = 0; i < notes.size(); i++) {
            if (notes.get(i).getId().equals(id)) {
                n = notes.get(i);
            }
        }
        return n;
    }

    private synchronized Long createID() {
        return idCounter.getAndIncrement();
    }

    private void saveToDisk() {
        boolean result = fds.save(notes);
    }

}
