package com.example.notesandreminding;

import android.app.Application;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class App extends Application {
//   private static NotesRepository notesRepository;
//    private static SettingsManager keystore;
//private static ArrayList<Note> notes;

    public void onCreate() {
        super.onCreate();

//        notesRepository = new NotesRepository(this);
//        keystore = new SettingsManager(this);
    }
    public void save(View view) {
        boolean result = JSONHelper.exportToJSON(this, NotesAct.n.getNotes());
    }
    public void open(View view) {
        if (JSONHelper.importFromJSON(this) != null) {
            NotesAct.n.setNotes(JSONHelper.importFromJSON(this)) ;
//            n.notes=notesNew;
            NotesAct.adapter = new MapAdapter(NotesAct.n.getNotes());
            NotesAct.listView.setAdapter(NotesAct.adapter);

        } else {
//            NotesAct.showNotes(NotesAct.n.getNotes());
            NotesAct.adapter = new MapAdapter(NotesAct.n.getNotes());
            NotesAct.listView.setAdapter(NotesAct.adapter);
        }
    }
//    public static NotesRepository getNoteRepository() {
//        return notesRepository;
//    }
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