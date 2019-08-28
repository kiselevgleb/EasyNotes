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

    private View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            setDate();
        }
    };

    TimePickerDialog.OnTimeSetListener timeSetListener = new TimePickerDialog.OnTimeSetListener() {

        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            dateAndTime.set(Calendar.HOUR_OF_DAY, hourOfDay);
            dateAndTime.set(Calendar.MINUTE, minute);
            setInitialDateTime();
        }
    };
    DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

            dateAndTime.set(Calendar.YEAR, year);
            dateAndTime.set(Calendar.MONTH, monthOfYear);
            dateAndTime.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            setInitialDateTime();
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
        try {
            inputID = (Long) getIntent().getExtras().getLong("ID");
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        if (inputID != null) {
            Note n = App.getNoteRepository().getNote(inputID);
            if (n.getDeadline() != null) {
                checkBoxDate.setChecked(true);
                dueDate.setText(ConvertLongToString(n.getDeadline()));
            } else {
                checkBoxDate.setChecked(false);
            }
            title.setText(n.getTitle());
            description.setText(n.getText());
        } else {
            title.setText("");
            description.setText("");
            dueDate.setText("");
        }
        checkBoxDate.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    dueDate.setText(ConvertLongToString(Calendar.getInstance().getTimeInMillis()));
                } else {
                    dueDate.setText("");
                }
            }
        });
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

    private String ConvertLongToString(long l) {
        Calendar d = Calendar.getInstance();
        d.setTimeInMillis(l);
        Date convertDate = d.getTime();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy hh:mm");
        return formatter.format(convertDate);
    }

    public void setDate() {
        new DatePickerDialog(WriteNotesActivity.this, dateSetListener,
                dateAndTime.get(Calendar.YEAR),
                dateAndTime.get(Calendar.MONTH),
                dateAndTime.get(Calendar.DAY_OF_MONTH))
                .show();
    }

    public void setTime(View v) {
        new TimePickerDialog(WriteNotesActivity.this, timeSetListener,
                dateAndTime.get(Calendar.HOUR_OF_DAY),
                dateAndTime.get(Calendar.MINUTE), true)
                .show();
    }

    private void setInitialDateTime() {

        dueDate.setText(DateUtils.formatDateTime(this,
                dateAndTime.getTimeInMillis(),
                DateUtils.FORMAT_SHOW_DATE | DateUtils.FORMAT_SHOW_YEAR
                        | DateUtils.FORMAT_SHOW_TIME));
    }
}
