package com.example.notesandreminding;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class App extends AppCompatActivity {
    private static NotesRepository notesRepository;
    private static SettingsManager keystore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        notesRepository = new NotesRepository(this);
        keystore = new SettingsManager(this);
    }
    public static NotesRepository getNoteRepository() {
        return notesRepository;
    }
    public static SettingsManager getKeystore() {
        return keystore;
    }

    public static void setNotesRepository(NotesRepository notesRepository) {
        App.notesRepository = notesRepository;
    }

    public static void setKeystore(SettingsManager keystore) {
        App.keystore = keystore;
    }
}