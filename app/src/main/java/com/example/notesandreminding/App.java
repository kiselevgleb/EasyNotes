package com.example.notesandreminding;

import android.app.Application;

public class App extends Application {
    private static NotesRepositoryImp noteRepository;
    private static SettingsManagerImp settingsManager;
    @Override
    public void onCreate() {
        super.onCreate();

        noteRepository = new NotesRepositoryImp(this);
        settingsManager = new SettingsManagerImp(this);
    }
    public static NotesRepositoryImp getNoteRepository() {
        return noteRepository;
    }
    public static SettingsManagerImp getSettingsManager() {
        return settingsManager;
    }
}