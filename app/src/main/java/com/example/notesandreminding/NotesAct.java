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
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
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
import java.util.Map;

public class NotesAct extends AppCompatActivity {
    FloatingActionButton add;
    ListView listView;
    ArrayList<HashMap<String, String>> hmList = new ArrayList<>();
    HashMap<String, String> hashMap = new HashMap<>();
    ArrayList<Notes> values = new ArrayList<>(WriteNotesActivity.getDateBase().values());
    public static int impText = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);
        add = (FloatingActionButton) findViewById(R.id.fab);
        listView = findViewById(R.id.listView);

        for (int i = 0; i < values.size(); i++) {
            hashMap.put(values.get(i).title, values.get(i).text);
        }
        hmList.add(hashMap);
        showNotes(hashMap);

        add.setOnClickListener(clickListener);
        listView.setOnItemClickListener(itemClickListener);
    }

    AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Map.Entry<String, String> item = (Map.Entry) MapAdapter.mData.get(position);
            impText = 1;
            if (item.getKey() != null && item.getValue() != null) {
                Intent intent = new Intent(NotesAct.this, WriteNotesActivity.class);
                intent.putExtra("haderEditText", item.getKey());
                intent.putExtra("textEditText", item.getValue());
                startActivity(intent);
            }
        }
    };

    public void showNotes(HashMap<String, String> not) {
        MapAdapter adapter = new MapAdapter(not);
        listView.setAdapter(adapter);
    }

    private View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(NotesAct.this, WriteNotesActivity.class);
            startActivity(intent);
        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.notmenu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.sort:
                Intent intent2 = new Intent(NotesAct.this, NewPassActivity.class);
                startActivity(intent2);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
