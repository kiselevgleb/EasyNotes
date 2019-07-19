package com.example.notesandreminding;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import static com.example.notesandreminding.NewPassActivity.sp;


public class MainActivity extends AppCompatActivity {

    private Button n1;
    private Button n2;
    private Button n3;
    private Button n4;
    private Button n5;
    private Button n6;
    private Button n7;
    private Button n8;
    private Button n9;
    private Button n0;
    private Button c;

    private TextView point1;
    private TextView point2;
    private TextView point3;
    private TextView point4;
    private String passDoc = "0000";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        SharedPreferences sp = getSharedPreferences("MY_SETTINGS", Context.MODE_PRIVATE);
        boolean hasVisited = sp.getBoolean("hasVisited", false);

        if (!hasVisited) {
            Intent intent = new Intent(MainActivity.this, NewPassActivity.class);
            startActivity(intent);
            SharedPreferences.Editor e = sp.edit();
            e.putBoolean("hasVisited", true);
            e.commit();
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        n1 = findViewById(R.id.button1);
        n2 = findViewById(R.id.button2);
        n3 = findViewById(R.id.button3);
        n4 = findViewById(R.id.button4);
        n5 = findViewById(R.id.button5);
        n6 = findViewById(R.id.button6);
        n7 = findViewById(R.id.button7);
        n8 = findViewById(R.id.button8);
        n9 = findViewById(R.id.button9);
        n0 = findViewById(R.id.button0);
        c = findViewById(R.id.button);

        point1 = findViewById(R.id.textPass1);
        point2 = findViewById(R.id.textPass2);
        point3 = findViewById(R.id.textPass3);
        point4 = findViewById(R.id.textPass4);

        n1.setOnClickListener(new NumberClickListener(1));
        n2.setOnClickListener(new NumberClickListener(2));
        n3.setOnClickListener(new NumberClickListener(3));
        n4.setOnClickListener(new NumberClickListener(4));
        n5.setOnClickListener(new NumberClickListener(5));
        n6.setOnClickListener(new NumberClickListener(6));
        n7.setOnClickListener(new NumberClickListener(7));
        n8.setOnClickListener(new NumberClickListener(8));
        n9.setOnClickListener(new NumberClickListener(9));
        n0.setOnClickListener(new NumberClickListener(0));
        c.setOnClickListener(clickListenerC);

    }

    String pass = "";
    private View.OnClickListener clickListenerC = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (pass.length() > 0) {
                String sub = pass.substring(0, pass.length() - 1);
                pass = sub;
                check();
            }
        }
    };

    public void check() {
        if (pass.length() == 0) {
            point1.setTextColor(Color.GRAY);
            point2.setTextColor(Color.GRAY);
            point3.setTextColor(Color.GRAY);
            point4.setTextColor(Color.GRAY);
        } else if (pass.length() == 1) {
            point1.setTextColor(Color.YELLOW);
            point2.setTextColor(Color.GRAY);
            point3.setTextColor(Color.GRAY);
            point4.setTextColor(Color.GRAY);
        } else if (pass.length() == 2) {
            point1.setTextColor(Color.YELLOW);
            point2.setTextColor(Color.YELLOW);
            point3.setTextColor(Color.GRAY);
            point4.setTextColor(Color.GRAY);
        } else if (pass.length() == 3) {
            point1.setTextColor(Color.YELLOW);
            point2.setTextColor(Color.YELLOW);
            point3.setTextColor(Color.YELLOW);
            point4.setTextColor(Color.GRAY);
        } else if (pass.length() == 4) {
            point1.setTextColor(Color.YELLOW);
            point2.setTextColor(Color.YELLOW);
            point3.setTextColor(Color.YELLOW);
            point4.setTextColor(Color.YELLOW);
        }
        if (pass.length() == 4 && pass.equals(sp.getString("777", ""))) {
            Intent intent = new Intent(MainActivity.this, NotesAct.class);
            startActivity(intent);
        } else if (pass.length() == 4) {
            pass = "";
            point1.setTextColor(Color.GRAY);
            point2.setTextColor(Color.GRAY);
            point3.setTextColor(Color.GRAY);
            point4.setTextColor(Color.GRAY);
            Toast.makeText(getApplicationContext(), "Error password", Toast.LENGTH_SHORT).show();
        }
    }

    public class NumberClickListener implements View.OnClickListener {
        private final int number;

        public NumberClickListener(int number) {
            this.number = number;
        }

        @Override
        public void onClick(View v) {
            pass += number;
            check();
        }
    }
}
