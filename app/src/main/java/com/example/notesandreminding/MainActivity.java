package com.example.notesandreminding;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

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
    private String passDoc = "7777";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
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

        n1.setOnClickListener(clickListener1);
        n2.setOnClickListener(clickListener1);
        n3.setOnClickListener(clickListener1);
        n4.setOnClickListener(clickListener1);
        n5.setOnClickListener(clickListener1);
        n6.setOnClickListener(clickListener1);
        n7.setOnClickListener(clickListener1);
        n8.setOnClickListener(clickListener1);
        n9.setOnClickListener(clickListener1);
        n0.setOnClickListener(clickListener1);
        c.setOnClickListener(clickListener1);    }


    String pass = "";
    private View.OnClickListener clickListener1 = new View.OnClickListener() {
        @Override
        public void onClick(View v)  {


               if(pass.length()==0){
                switch (v.getId()) {
                case R.id.button1: pass +="1"; point1.setTextColor(Color.YELLOW);break;
                case R.id.button2: pass +="2";  point1.setTextColor(Color.YELLOW);break;
                case R.id.button3: pass +="3";  point1.setTextColor(Color.YELLOW);break;
                case R.id.button4: pass +="4";  point1.setTextColor(Color.YELLOW);break;
                case R.id.button5: pass +="5";  point1.setTextColor(Color.YELLOW);break;
                case R.id.button6: pass +="6";  point1.setTextColor(Color.YELLOW);break;
                case R.id.button7: pass +="7";  point1.setTextColor(Color.YELLOW);break;
                case R.id.button8: pass +="8";  point1.setTextColor(Color.YELLOW);break;
                case R.id.button9: pass +="9";  point1.setTextColor(Color.YELLOW);break;
                case R.id.button0: pass +="0";  point1.setTextColor(Color.YELLOW);break;   }}

               else if(pass.length()==1){
                    switch (v.getId()) {
                        case R.id.button1: pass +="1"; point2.setTextColor(Color.YELLOW);break;
                        case R.id.button2: pass +="2";  point2.setTextColor(Color.YELLOW);break;
                        case R.id.button3: pass +="3";  point2.setTextColor(Color.YELLOW);break;
                        case R.id.button4: pass +="4";  point2.setTextColor(Color.YELLOW);break;
                        case R.id.button5: pass +="5";  point2.setTextColor(Color.YELLOW);break;
                        case R.id.button6: pass +="6";  point2.setTextColor(Color.YELLOW);break;
                        case R.id.button7: pass +="7";  point2.setTextColor(Color.YELLOW);break;
                        case R.id.button8: pass +="8";  point2.setTextColor(Color.YELLOW);break;
                        case R.id.button9: pass +="9";  point2.setTextColor(Color.YELLOW);break;
                        case R.id.button0: pass +="0";  point2.setTextColor(Color.YELLOW);break;   }}

                else if(pass.length()==2){
                    switch (v.getId()) {
                        case R.id.button1: pass +="1"; point3.setTextColor(Color.YELLOW);break;
                        case R.id.button2: pass +="2";  point3.setTextColor(Color.YELLOW);break;
                        case R.id.button3: pass +="3";  point3.setTextColor(Color.YELLOW);break;
                        case R.id.button4: pass +="4";  point3.setTextColor(Color.YELLOW);break;
                        case R.id.button5: pass +="5";  point3.setTextColor(Color.YELLOW);break;
                        case R.id.button6: pass +="6";  point3.setTextColor(Color.YELLOW);break;
                        case R.id.button7: pass +="7";  point3.setTextColor(Color.YELLOW);break;
                        case R.id.button8: pass +="8";  point3.setTextColor(Color.YELLOW);break;
                        case R.id.button9: pass +="9";  point3.setTextColor(Color.YELLOW);break;
                        case R.id.button0: pass +="0";  point3.setTextColor(Color.YELLOW);break;   }}

                else if(pass.length()==3){
                    switch (v.getId()) {
                        case R.id.button1: pass +="1"; point4.setTextColor(Color.YELLOW);break;
                        case R.id.button2: pass +="2";  point4.setTextColor(Color.YELLOW);break;
                        case R.id.button3: pass +="3";  point4.setTextColor(Color.YELLOW);break;
                        case R.id.button4: pass +="4";  point4.setTextColor(Color.YELLOW);break;
                        case R.id.button5: pass +="5";  point4.setTextColor(Color.YELLOW);break;
                        case R.id.button6: pass +="6";  point4.setTextColor(Color.YELLOW);break;
                        case R.id.button7: pass +="7";  point4.setTextColor(Color.YELLOW);break;
                        case R.id.button8: pass +="8";  point4.setTextColor(Color.YELLOW);break;
                        case R.id.button9: pass +="9";  point4.setTextColor(Color.YELLOW);break;
                        case R.id.button0: pass +="0";  point4.setTextColor(Color.YELLOW);break;}
}
                        if (pass.length()==4&&pass.equals(passDoc)) {
                            Intent intent= new Intent(MainActivity.this, NotesAct.class);
                            startActivity(intent); }
//                            setContentView(R.layout.notes);}
                        else if (pass.length()==4){
                            pass = "";
                            point1.setTextColor(Color.GRAY);
                            point2.setTextColor(Color.GRAY);
                            point3.setTextColor(Color.GRAY);
                            point4.setTextColor(Color.GRAY);}
        }
    };
}
