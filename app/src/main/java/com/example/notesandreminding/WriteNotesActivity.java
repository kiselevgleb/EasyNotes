package com.example.notesandreminding;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.DateUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.TimePicker;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class WriteNotesActivity extends AppCompatActivity {
    private TextView dueDate;
    private EditText title;
    private EditText description;
    private CheckBox checkBoxDate;
    private Calendar dateAndTime = Calendar.getInstance();
    private Long inputID = null;
    public final static String EXTRA_NOTE_ID="note_id";

    private View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            setDate();
        }
    };

    DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

            dateAndTime.set(Calendar.YEAR, year);
            dateAndTime.set(Calendar.MONTH, monthOfYear);
            dateAndTime.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            updateDeadlineTextView();
        }
    };
    private CompoundButton.OnCheckedChangeListener onCheckedChangeListener = new CompoundButton.OnCheckedChangeListener() {

        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if (isChecked) {
                dueDate.setText(Calendar.getInstance().getTime().toString());
                updateDeadlineTextView();
            } else {
                dueDate.setText("");
            }
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write_notes);
        dueDate = (TextView) findViewById(R.id.date);
        title = (EditText) findViewById(R.id.hader);
        description = (EditText) findViewById(R.id.text);
        checkBoxDate = (CheckBox) findViewById(R.id.checkBox);
        ImageButton datebut = (ImageButton) findViewById(R.id.imageButton);
        datebut.setOnClickListener(clickListener);
        checkBoxDate.setOnCheckedChangeListener(onCheckedChangeListener);
        try {
            inputID = (Long) getIntent().getExtras().getLong(EXTRA_NOTE_ID);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        if (inputID != null) {
            Note n = App.getNoteRepository().getNote(inputID);
            fillViewsByNote(n);
        }
    }

    private void fillViewsByNote(Note n) {

        if (n.getDeadline() != null) {
            checkBoxDate.setChecked(true);
            dateAndTime.setTimeInMillis(n.getDeadline());
            dueDate.setText((n.getDeadline().toString()));
            updateDeadlineTextView();
        } else {
            checkBoxDate.setChecked(false);
        }
        title.setText(n.getTitle());
        description.setText(n.getText());
    }

    private void updateDeadlineTextView() {
        dueDate.setText(DateUtils.formatDateTime(this,
                dateAndTime.getTimeInMillis(),
                DateUtils.FORMAT_SHOW_DATE | DateUtils.FORMAT_SHOW_YEAR
                        | DateUtils.FORMAT_SHOW_TIME));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.savemenu, menu);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.save_action:
                Long deadLine = checkBoxDate.isChecked() ? dateAndTime.getTimeInMillis() : null;

                String textHader = title.getText().toString();
                String textBody = description.getText().toString();
                Note notes = new Note(textHader, textBody, deadLine, inputID, Calendar.getInstance().getTimeInMillis());
                App.getNoteRepository().saveNote(notes);
                finish();
                return true;

            case android.R.id.home:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void setDate() {
        new DatePickerDialog(WriteNotesActivity.this, dateSetListener,
                dateAndTime.get(Calendar.YEAR),
                dateAndTime.get(Calendar.MONTH),
                dateAndTime.get(Calendar.DAY_OF_MONTH))
                .show();
    }


}
