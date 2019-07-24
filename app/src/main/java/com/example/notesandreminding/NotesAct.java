package com.example.notesandreminding;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class NotesAct extends AppCompatActivity {
    private static HashMap<Long, Note> dateBase = new HashMap<>();
    FloatingActionButton add;
    ListView listView;
    public static int impText = 0;

    public static HashMap<Long, Note> getDateBase() {
        return dateBase;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);
        add = (FloatingActionButton) findViewById(R.id.fab);
        listView = findViewById(R.id.listView);
        showNotes(dateBase);

        add.setOnClickListener(clickListener);
        listView.setOnItemClickListener(itemClickListener);
        listView.setOnItemLongClickListener(onItemLongClickListener);
    }

    long key = 0;
    AdapterView.OnItemLongClickListener onItemLongClickListener = new AdapterView.OnItemLongClickListener() {
        @Override
        public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

            Map.Entry<Long, Note> item = (Map.Entry) MapAdapter.mData.get(position);
            key = item.getKey();

            AlertDialog.Builder builder = new AlertDialog.Builder(NotesAct.this);
            builder.setTitle(R.string.Warning);
            builder.setMessage(R.string.Are_you_sure);
            builder.setCancelable(false);
            builder.setPositiveButton(R.string.DELETE, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int arg1) {
                    dateBase.remove(key);
                    finish();
                    Intent intent = new Intent(NotesAct.this, NotesAct.class);
                    startActivity(intent);
                }
            });
            builder.setNegativeButton(R.string.CANCEL, new DialogInterface.OnClickListener() {
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
            Map.Entry<Long, Note> item = (Map.Entry) MapAdapter.mData.get(position);
            impText = 1;
            if (item.getKey() != null || item.getValue() != null) {
                Note note = (Note) item.getValue();
                String timeString = " ";
                if (item.getKey() != 0) {
                    Calendar d = Calendar.getInstance();
                    d.setTimeInMillis(item.getKey());
                    Date convertDate = d.getTime();
                    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy hh:mm");
                    timeString = formatter.format(convertDate);
                }
                Intent intent = new Intent(NotesAct.this, WriteNotesActivity.class);
                intent.putExtra("haderEditText", note.getTitle());
                intent.putExtra("textEditText", note.getText());
                intent.putExtra("dateEditText", timeString);
                intent.putExtra("checkBox", note.getCheckBox());
                startActivity(intent);
            }
        }
    };

    public void showNotes(HashMap<Long, Note> not) {
        MapAdapter adapter = new MapAdapter(not);
        listView.setAdapter(adapter);
    }

    private View.OnClickListener clickListener = new View.OnClickListener() {
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
        inflater.inflate(R.menu.notmenu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.newPass:
                finish();
                Intent intent = new Intent(NotesAct.this, NewPassActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
