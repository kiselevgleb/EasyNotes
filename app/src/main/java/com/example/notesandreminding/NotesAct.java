package com.example.notesandreminding;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class NotesAct extends AppCompatActivity {
    private ListView listView;
    private int impText = 0;
    MapAdapter adapter;
    ArrayList<Note> notesNew;
    private static final String LIST = "list";
    private SettingsManager settings;
    public static NotesRepository n = new NotesRepository();

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
//        save(listView);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);
        listView = findViewById(R.id.listView);

//        n = n.loadNotes();
        notesNew = n.getNotes();

        showNotes(notesNew);

        findViewById(R.id.fab).setOnClickListener(addNoteClickListener);
        listView.setOnItemClickListener(itemClickListener);
        listView.setOnItemLongClickListener(onItemLongClickListener);
    }

    AdapterView.OnItemLongClickListener onItemLongClickListener = new AdapterView.OnItemLongClickListener() {
        @Override
        public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

            final Note val = adapter.mData.get(position);

            AlertDialog.Builder builder = new AlertDialog.Builder(NotesAct.this)
                    .setTitle(R.string.warning)
                    .setMessage(R.string.Sure)
                    .setCancelable(false)
                    .setPositiveButton(R.string.delete, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int arg1) {
                            n.removeNote(val.getId());
                            Intent intent = new Intent(NotesAct.this, NotesAct.class);
                            startActivity(intent);
                            finish();
                        }
                    });
            builder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int arg1) {
                    dialog.cancel();
                }
            });

            AlertDialog alert = builder.create();
            alert.show();
            return true;
        }
    };

    AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            final Note val = adapter.mData.get(position);
            impText = 1;
            if (val != null) {
                Intent intent = new Intent(NotesAct.this, WriteNotesActivity.class);
                intent.putExtra("impText", impText);
                intent.putExtra("ID", val.getId());
                startActivity(intent);
            }
        }
    };

    private void showNotes(ArrayList<Note> not) {
        adapter = new MapAdapter(not);
        listView.setAdapter(adapter);
    }

    private View.OnClickListener addNoteClickListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            impText = 0;
            finish();
            Intent intent = new Intent(NotesAct.this, WriteNotesActivity.class);
            startActivity(intent);
        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.notes_activity_menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.new_pass_action:
                Intent intent = new Intent(NotesAct.this, NewPassActivity.class);
                startActivity(intent);
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

//    public void save(View view) {
//
//        boolean result = JSONHelper.exportToJSON(this, notesNew);
//        if (result) {
//            Toast.makeText(this, "", Toast.LENGTH_LONG).show();
//        } else {
//            Toast.makeText(this, "", Toast.LENGTH_LONG).show();
//        }
//    }

//    public void open(View view) {
//        notesNew = JSONHelper.importFromJSON(this);
//        if (notesNew != null) {
//            adapter = new MapAdapter(notesNew);
//            listView.setAdapter(adapter);
//        }
//    }
}
