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

public class NotesListActivity extends AppCompatActivity {
    private ListView listView;
    private MapAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);
        listView = findViewById(R.id.listView);

        findViewById(R.id.fab).setOnClickListener(addNoteClickListener);
        listView.setOnItemClickListener(itemClickListener);
        listView.setOnItemLongClickListener(onItemLongClickListener);
    }

    @Override
    protected void onResume() {
        super.onResume();
        updateNotesList();
    }

    AdapterView.OnItemLongClickListener onItemLongClickListener = new AdapterView.OnItemLongClickListener() {
        @Override
        public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

            final Note val = adapter.mData.get(position);

           new AlertDialog.Builder(NotesListActivity.this)
                    .setTitle(R.string.warning)
                    .setMessage(R.string.Sure)
                    .setCancelable(false)
                    .setPositiveButton(R.string.delete, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int arg1) {
                            App.getNoteRepository().removeNote(val.getId());
                            updateNotesList();
                        }
                    })
                    .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int arg1) {
                            dialog.cancel();
                        }
                    })
                    .create()
                    .show();
            return true;
        }
    };

    AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            final Note val = adapter.mData.get(position);
            final long ID = val.getId();
            Intent intent = new Intent(NotesListActivity.this, WriteNotesActivity.class);
            intent.putExtra("ID", ID);
            startActivity(intent);
        }
    };

    private void updateNotesList() {
        ArrayList<Note> not = App.getNoteRepository().getNotes();
        adapter = new MapAdapter(not);
        listView.setAdapter(adapter);
    }


    private View.OnClickListener addNoteClickListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            finish();
            Intent intent = new Intent(NotesListActivity.this, WriteNotesActivity.class);
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
                Intent intent = new Intent(NotesListActivity.this, NewPassActivity.class);
                startActivity(intent);
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
