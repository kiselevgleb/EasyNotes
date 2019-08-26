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
import android.widget.TimePicker;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class WriteNotesActivity extends AppCompatActivity {
    private static EditText dueDate;
    private static EditText title;
    private static EditText description;

    private CheckBox checkBoxDate;
    private Calendar dateAndTime = Calendar.getInstance();
    private Note notes;
    private String sethd = null;
    private String setText = null;
    private Long inputID = null;

    private Long dateText = null;
    private boolean checkBox;
    private int impText = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write_notes);
        dueDate = (EditText) findViewById(R.id.date);
        title = (EditText) findViewById(R.id.hader);
        description = (EditText) findViewById(R.id.text);
        checkBoxDate = (CheckBox) findViewById(R.id.checkBox);
        ImageButton datebut = (ImageButton) findViewById(R.id.imageButton);
        datebut.setOnClickListener(clickListener);
        try {
            impText = getIntent().getExtras().getInt("impText");
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        if (impText == 1) {
            inputID = (Long) getIntent().getExtras().getLong("ID");
            Note n = App.getNoteRepository().getNote(inputID);
            sethd = n.getTitle();
            setText = n.getText();
            if (checkBox == true) {
                checkBoxDate.setChecked(true);
                dueDate.setText(ConvertLongToString(n.getDeadline()));
            } else {
                checkBoxDate.setChecked(false);
            }
            title.setText(sethd);
            description.setText(setText);
        } else {
            sethd = null;
            setText = null;
            dateText = null;
            title.setText(sethd);
            description.setText(setText);
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
                if (impText != 1) {
                    if (checkBoxDate.isChecked()) {
                        String textHader = title.getText().toString();
                        String textBody = description.getText().toString();
                        String cal = dueDate.getText().toString();
                        Long deadLine = ParsDate(cal);
                        notes = new Note(textHader, textBody, deadLine, null, Calendar.getInstance().getTimeInMillis());
                        App.getNoteRepository().saveNote(notes);
//                        App.setNotesRepository(this);
                        Intent intent = new Intent(WriteNotesActivity.this, NotesAct.class);
                        startActivity(intent);
                        finish();
                        return true;
                    } else {
                        String textHader = title.getText().toString();
                        String textBody = description.getText().toString();
                        Long deadLine = null;
                        notes = new Note(textHader, textBody, deadLine, null, Calendar.getInstance().getTimeInMillis());
                        App.getNoteRepository().saveNote(notes);
                        Intent intent = new Intent(WriteNotesActivity.this, NotesAct.class);
                        startActivity(intent);
                        finish();
                        return true;
                    }
                } else if (impText == 1) {
                    if (checkBoxDate.isChecked()) {
                        String textHader = title.getText().toString();
                        String textBody = description.getText().toString();
                        String cal = dueDate.getText().toString();
                        Long deadLine = ParsDate(cal);
                        Note n = App.getNoteRepository().getNote(inputID);
                        notes = new Note(textHader, textBody, deadLine, inputID, Calendar.getInstance().getTimeInMillis());
                        App.getNoteRepository().saveNote(notes);
                        Intent intent = new Intent(WriteNotesActivity.this, NotesAct.class);
                        startActivity(intent);
                        finish();
                        return true;
                    } else {
                        String textHader = title.getText().toString();
                        String textBody = description.getText().toString();
                        Note n = App.getNoteRepository().getNote(inputID);
                        Long deadLine = null;
                        notes = new Note(textHader, textBody, deadLine, inputID, Calendar.getInstance().getTimeInMillis());
                        App.getNoteRepository().saveNote(notes);
                        Intent intent = new Intent(WriteNotesActivity.this, NotesAct.class);
                        startActivity(intent);
                        finish();
                        return true;
                    }
                }
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

    private long ParsDate(String date) {
        Date dateDate = Calendar.getInstance().getTime();
        SimpleDateFormat formatter = null;
        if (date.length() == 22 && !date.split("")[1].equals(" ")) {
            formatter = new SimpleDateFormat("dd MMMM yyyy г., hh:mm");
        } else if (date.length() == 21 && date.split("")[1].equals(" ")) {
            formatter = new SimpleDateFormat("d MMMM yyyy г., hh:mm");
        } else if (date.length() == 24 && !date.split("")[1].equals(" ")) {
            formatter = new SimpleDateFormat("dd MMMMMM yyyy г., hh:mm");
        } else if (date.length() == 23 && date.split("")[1].equals(" ")) {
            formatter = new SimpleDateFormat("d MMMMMM yyyy г., hh:mm");
        } else if (date.length() == 25 && !date.split("")[1].equals(" ")) {
            formatter = new SimpleDateFormat("dd MMMMMMM yyyy г., hh:mm");
        } else if (date.length() == 24 && date.split("")[1].equals(" ")) {
            formatter = new SimpleDateFormat("d MMMMMMM yyyy г., hh:mm");
        } else if (date.length() == 23 && !date.split("")[1].equals(" ")) {
            formatter = new SimpleDateFormat("dd MMMMM yyyy г., hh:mm");
        } else if (date.length() == 22 && date.split("")[1].equals(" ")) {
            formatter = new SimpleDateFormat("d MMMMM yyyy г., hh:mm");
        } else if (date.length() == 21 && !date.split("")[1].equals(" ")) {
            formatter = new SimpleDateFormat("dd MMM yyyy г., hh:mm");
        } else if (date.length() == 20) {
            formatter = new SimpleDateFormat("d MMM yyyy г., hh:mm");
        } else if (date.length() == 26) {
            formatter = new SimpleDateFormat("dd MMMMMMMM yyyy г., hh:mm");
        } else if (date.length() == 25 && date.split("")[1].equals(" ")) {
            formatter = new SimpleDateFormat("d MMMMMMMM yyyy г., hh:mm");
        } else if (date.length() == 14) {
            formatter = new SimpleDateFormat("dd/MM/yy hh:mm");
        }
        try {
            dateDate = formatter.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return dateDate.getTime();
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
    private View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            setDate();
        }
    };


}
