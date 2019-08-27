package com.example.notesandreminding;

import android.app.Application;

public class App extends Application {
    private static NotesRepository noteRepository;
    private static SettingsManager settingsManager;
    @Override
    public void onCreate() {
        super.onCreate();
        noteRepository = new NotesRepositoryImp(this);
        settingsManager = new SettingsManagerImp(this);
    }
    public static NotesRepository getNoteRepository() {
        return noteRepository;
    }
    public static SettingsManager getSettingsManager() {
        return settingsManager;
    }
}