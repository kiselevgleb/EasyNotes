package com.example.notesandreminding;

import android.app.Application;

public class App extends Application {
    private static NotesRepository noteRepository;
    private static SettingsManager settingsManager;
    @Override
    public void onCreate() {
        super.onCreate();

        noteRepository = new NotesRepository(this);
        settingsManager = new SettingsManager(this);
    }
    public static NotesRepository getNoteRepository() {
        return noteRepository;
    }
    public static SettingsManager getKeystore() {
        return settingsManager;
    }
}