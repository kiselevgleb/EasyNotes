package com.example.notesandreminding;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.SparseBooleanArray;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

public class NotesAct extends AppCompatActivity {
    FloatingActionButton floating;
    ListView listView;
    ArrayList<HashMap<String, String>> hmList = new ArrayList<>();
    HashMap<String, String> hashMap= new HashMap<>();
    ArrayList<Notes> values = new ArrayList<>(WriteNotesActivity.db.values());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);
        floating = (FloatingActionButton)findViewById(R.id.fab);
        listView = findViewById(R.id.listView);

        for (int i = 0; i <values.size() ; i++) {
            hashMap.put(values.get(i).hader, values.get(i).text);
        }
        hmList.add(hashMap);
        showNotes(hashMap);

        floating.setOnClickListener(clickListener);
    }
    public void showNotes(HashMap<String, String> cinemas) {
        MyAdapter adapter = new MyAdapter(cinemas);
        listView.setAdapter(adapter);
    }

    private View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v)  {
            Intent intent= new Intent(NotesAct.this, WriteNotesActivity.class);
            startActivity(intent);
        }};

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.notmenu, menu);
        return true;
    }

}
