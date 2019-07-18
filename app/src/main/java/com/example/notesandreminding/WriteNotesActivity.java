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
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;
import java.util.HashMap;

public class WriteNotesActivity extends AppCompatActivity {
    TextView currentDateTime;
    EditText hader1;
    EditText text1;
    CheckBox checkBox1;
    Calendar dateAndTime=Calendar.getInstance();
    public static HashMap<Calendar,Notes> db = new HashMap<>();
    Notes notes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write_notes);
        currentDateTime=(TextView)findViewById(R.id.date);
        hader1=(EditText)findViewById(R.id.hader);
        text1=(EditText)findViewById(R.id.text);
        checkBox1=(CheckBox)findViewById(R.id.checkBox);

        setInitialDateTime();
        ImageButton datebut =(ImageButton) findViewById(R.id.imageButton);
        datebut.setOnClickListener(clickListener);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.savemenu, menu);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId())
        {
            case R.id.item2:
                String textHader = hader1.getText().toString();
                String textBody = text1.getText().toString();
                notes = new Notes(textHader,textBody,dateAndTime);
                db.put(dateAndTime, notes);
                Intent intent2= new Intent(WriteNotesActivity.this, NotesAct.class);
                startActivity(intent2);
                return true;
            case android.R.id.home:
                Intent intent= new Intent(WriteNotesActivity.this, NotesAct.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void setDate() {
        new DatePickerDialog(WriteNotesActivity.this, d,
                dateAndTime.get(Calendar.YEAR),
                dateAndTime.get(Calendar.MONTH),
                dateAndTime.get(Calendar.DAY_OF_MONTH))
                .show();
    }

    public void setTime(View v) {
        new TimePickerDialog(WriteNotesActivity.this, t,
                dateAndTime.get(Calendar.HOUR_OF_DAY),
                dateAndTime.get(Calendar.MINUTE), true)
                .show();
    }

    private void setInitialDateTime() {
        currentDateTime.setText(DateUtils.formatDateTime(this,
                dateAndTime.getTimeInMillis(),
                DateUtils.FORMAT_SHOW_DATE | DateUtils.FORMAT_SHOW_YEAR
                        | DateUtils.FORMAT_SHOW_TIME));
    }

    TimePickerDialog.OnTimeSetListener t=new TimePickerDialog.OnTimeSetListener() {
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            dateAndTime.set(Calendar.HOUR_OF_DAY, hourOfDay);
            dateAndTime.set(Calendar.MINUTE, minute);
            setInitialDateTime();
        }
    };

    DatePickerDialog.OnDateSetListener d=new DatePickerDialog.OnDateSetListener() {
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            dateAndTime.set(Calendar.YEAR, year);
            dateAndTime.set(Calendar.MONTH, monthOfYear);
            dateAndTime.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            setInitialDateTime();
        }
    };
    private View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v)  {
            setDate();
        }};


}
