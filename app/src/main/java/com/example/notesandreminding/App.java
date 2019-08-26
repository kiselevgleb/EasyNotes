package com.example.notesandreminding;

import android.app.Application;
import android.content.Context;

public class App extends Application {
    private static Context context;
    private static NotesRepository notesRepository;

    App(NotesRepository notesRepository, Context context) {
        this.notesRepository = notesRepository;
        this.context = context;
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