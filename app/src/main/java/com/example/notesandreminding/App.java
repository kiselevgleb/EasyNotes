package com.example.notesandreminding;

import android.app.Application;

public class App extends Application {
    private static NotesRepository notesRepository = new NotesRepository();

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