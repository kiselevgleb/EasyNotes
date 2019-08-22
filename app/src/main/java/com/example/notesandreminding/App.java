package com.example.notesandreminding;

import android.app.Application;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class App extends Application {
   private static NotesRepository notesRepository;
//    private static SettingsManager keystore;
//private static ArrayList<Note> notes;

    public void onCreate() {
        super.onCreate();

//        notesRepository = new NotesRepository(this);
//        keystore = new SettingsManager(this);
    }
    public static NotesRepository getNoteRepository() {
        return notesRepository;
    }
//    public static SettingsManager getKeystore() {
//        return keystore;
//    }
//
//    public static void setNotesRepository(NotesRepository notesRepository) {
//        App.notesRepository = notesRepository;
//    }
//
//    public static void setKeystore(SettingsManager keystore) {
//        App.keystore = keystore;
//    }
}