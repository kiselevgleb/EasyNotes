package com.example.notesandreminding;

import android.app.Application;
import android.content.Context;

public class App extends Application {

    private static NotesRepository notesRepository;

    App(NotesRepository notesRepository) {
        this.notesRepository = notesRepository;
    }

    public void onCreate() {
        super.onCreate();
    }

    public static NotesRepository getNoteRepository() {
        return notesRepository;
    }

    public static void setNotesRepository(NotesRepository notesRepository) {
        App.notesRepository = notesRepository;
    }
}