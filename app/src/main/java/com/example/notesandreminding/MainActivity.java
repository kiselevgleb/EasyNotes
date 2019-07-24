package com.example.notesandreminding;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    private TextView point1;
    private TextView point2;
    private TextView point3;
    private TextView point4;
    private String passDoc = "temp";
    private final String MY_SET = "MY_SETTINGS";
    private static SettingsManager settingsManager;

    public static SettingsManager getSettingsManager() {
        return settingsManager;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        settingsManager = new SettingsManager(this);
        if (!settingsManager.hasPinCode()) {
            Intent intent = new Intent(MainActivity.this, NewPassActivity.class);
            startActivity(intent);
//            finish();
        }

        point1 = findViewById(R.id.textPass1);
        point2 = findViewById(R.id.textPass2);
        point3 = findViewById(R.id.textPass3);
        point4 = findViewById(R.id.textPass4);

        findViewById(R.id.button1).setOnClickListener(new NumberClickListener(1));
        findViewById(R.id.button2).setOnClickListener(new NumberClickListener(2));
        findViewById(R.id.button3).setOnClickListener(new NumberClickListener(3));
        findViewById(R.id.button4).setOnClickListener(new NumberClickListener(4));
        findViewById(R.id.button5).setOnClickListener(new NumberClickListener(5));
        findViewById(R.id.button6).setOnClickListener(new NumberClickListener(6));
        findViewById(R.id.button7).setOnClickListener(new NumberClickListener(7));
        findViewById(R.id.button8).setOnClickListener(new NumberClickListener(8));
        findViewById(R.id.button9).setOnClickListener(new NumberClickListener(9));
        findViewById(R.id.button0).setOnClickListener(new NumberClickListener(0));
        findViewById(R.id.button).setOnClickListener(clickListenerC);
    }

    String pass = "";
    private View.OnClickListener clickListenerC = new View.OnClickListener() {
        @RequiresApi(api = Build.VERSION_CODES.M)
        @Override
        public void onClick(View v) {
            pass = pass.substring(0, Math.max(0, pass.length() - 1));
            check();
        }
    };

    @RequiresApi(api = Build.VERSION_CODES.M)
    public void check() {
        int unCheckedColor = getColor(R.color.pointUnChecked);
        point1.setTextColor(unCheckedColor);
        point2.setTextColor(unCheckedColor);
        point3.setTextColor(unCheckedColor);
        point4.setTextColor(unCheckedColor);
        int checkedColor = getColor(R.color.pointChecked);
        if (pass.length() == 1) {
            point1.setTextColor(checkedColor);
        } else if (pass.length() == 2) {
            point1.setTextColor(checkedColor);
            point2.setTextColor(checkedColor);
        } else if (pass.length() == 3) {
            point1.setTextColor(checkedColor);
            point2.setTextColor(checkedColor);
            point3.setTextColor(checkedColor);
        } else if (pass.length() == 4) {
            if (pass.length() == 4 && pass.equals(settingsManager.getPinCode())) {
                Intent intent = new Intent(MainActivity.this, NotesAct.class);
                startActivity(intent);
                finish();

            } else {
                pass = "";
                Toast.makeText(getApplicationContext(), R.string.pass_error, Toast.LENGTH_SHORT).show();
            }
        }
    }

    public class NumberClickListener implements View.OnClickListener {
        private final int number;

        public NumberClickListener(int number) {
            this.number = number;
        }

        @RequiresApi(api = Build.VERSION_CODES.M)
        @Override
        public void onClick(View v) {
            pass += number;
            check();
        }
    }
}
