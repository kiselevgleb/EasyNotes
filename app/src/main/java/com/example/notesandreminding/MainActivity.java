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
        n2.setOnClickListener(clickListener2);
        n3.setOnClickListener(clickListener3);
        n4.setOnClickListener(clickListener4);
        n5.setOnClickListener(clickListener5);
        n6.setOnClickListener(clickListener6);
        n7.setOnClickListener(clickListener7);
        n8.setOnClickListener(clickListener8);
        n9.setOnClickListener(clickListener9);
        n0.setOnClickListener(clickListener0);
        c.setOnClickListener(clickListenerC);    }


    String pass = "";

    private View.OnClickListener clickListener1 = new View.OnClickListener() {
        @Override
        public void onClick(View v)  {
            pass +="1";check();}};
    private View.OnClickListener clickListener2 = new View.OnClickListener() {
        @Override
        public void onClick(View v)  {
                pass +="2";check();}};
    private View.OnClickListener clickListener3 = new View.OnClickListener() {
        @Override
        public void onClick(View v)  {
            pass +="3";check();}};
    private View.OnClickListener clickListener4 = new View.OnClickListener() {
        @Override
        public void onClick(View v)  {
            pass +="4";check();}};
    private View.OnClickListener clickListener5 = new View.OnClickListener() {
        @Override
        public void onClick(View v)  {
            pass +="5";check();}};
    private View.OnClickListener clickListener6 = new View.OnClickListener() {
        @Override
        public void onClick(View v)  {
            pass +="6";check();}};
    private View.OnClickListener clickListener7 = new View.OnClickListener() {
        @Override
        public void onClick(View v)  {
            pass +="7";check();}};
    private View.OnClickListener clickListener8 = new View.OnClickListener() {
        @Override
        public void onClick(View v)  {
            pass +="8";check();}};
    private View.OnClickListener clickListener9 = new View.OnClickListener() {
        @Override
        public void onClick(View v)  {
            pass +="9";check();}};
    private View.OnClickListener clickListener0 = new View.OnClickListener() {
        @Override
        public void onClick(View v)  {
            pass +="0";check();}};
    private View.OnClickListener clickListenerC = new View.OnClickListener() {
        @Override
        public void onClick(View v)  {
            if (pass.length()>0){
                String sub = pass.substring(0, pass.length()-1);
            pass = sub;
            check();}}};

    private void check(){
    if (pass.length()==0){
            point1.setTextColor(Color.GRAY);
            point2.setTextColor(Color.GRAY);
            point3.setTextColor(Color.GRAY);
            point4.setTextColor(Color.GRAY);
        }
    else if (pass.length()==1){
        point1.setTextColor(Color.YELLOW);
        point2.setTextColor(Color.GRAY);
        point3.setTextColor(Color.GRAY);
        point4.setTextColor(Color.GRAY);
    }
    else if (pass.length()==2){
        point1.setTextColor(Color.YELLOW);
        point2.setTextColor(Color.YELLOW);
        point3.setTextColor(Color.GRAY);
        point4.setTextColor(Color.GRAY);
    }
    else if (pass.length()==3){
        point1.setTextColor(Color.YELLOW);
        point2.setTextColor(Color.YELLOW);
        point3.setTextColor(Color.YELLOW);
        point4.setTextColor(Color.GRAY);    }
    else if (pass.length()==4){
        point1.setTextColor(Color.YELLOW);
        point2.setTextColor(Color.YELLOW);
        point3.setTextColor(Color.YELLOW);
        point4.setTextColor(Color.YELLOW);    }

    if (pass.length()==4&&pass.equals(passDoc)) {
        Intent intent= new Intent(MainActivity.this, NotesAct.class);
        startActivity(intent); }
    else if (pass.length()==4){
                pass = "";
                point1.setTextColor(Color.GRAY);
                point2.setTextColor(Color.GRAY);
                point3.setTextColor(Color.GRAY);
                point4.setTextColor(Color.GRAY);}
    }


//    private View.OnClickListener clickListener2 = new View.OnClickListener() {
//        @Override
//        public void onClick(View v)  {
//            if(pass.length()==0){
//                pass +="2";
//                point1.setTextColor(Color.YELLOW);
//            }
//            else if(pass.length()==1){
//                pass +="2";
//                point2.setTextColor(Color.YELLOW);
//            }
//            else if(pass.length()==2){
//                pass +="2";
//                point3.setTextColor(Color.YELLOW);}
//
//            else if(pass.length()==3){
//                pass +="2";
//                point4.setTextColor(Color.YELLOW);
//            }
//            if (pass.length()==4&&pass.equals(passDoc)) {
//                Intent intent= new Intent(MainActivity.this, NotesAct.class);
//                startActivity(intent); }
//            else if (pass.length()==4){
//                pass = "";
//                point1.setTextColor(Color.GRAY);
//                point2.setTextColor(Color.GRAY);
//                point3.setTextColor(Color.GRAY);
//                point4.setTextColor(Color.GRAY);}
//        }
//    };



//    private View.OnClickListener clickListener1 = new View.OnClickListener() {
//        @Override
//        public void onClick(View v)  {
//               if(pass.length()==0){
//                switch (v.getId()) {
//                case R.id.button1: pass +="1"; break;
//                case R.id.button2: pass +="2"; break;
//                case R.id.button3: pass +="3"; break;
//                case R.id.button4: pass +="4"; break;
//                case R.id.button5: pass +="5"; break;
//                case R.id.button6: pass +="6"; break;
//                case R.id.button7: pass +="7"; break;
//                case R.id.button8: pass +="8"; break;
//                case R.id.button9: pass +="9"; break;
//                case R.id.button0: pass +="0"; break;   }
//                   point1.setTextColor(Color.YELLOW);
//               }
//
//               else if(pass.length()==1){
//                    switch (v.getId()) {
//                        case R.id.button1: pass +="1"; break;
//                        case R.id.button2: pass +="2";  break;
//                        case R.id.button3: pass +="3";  break;
//                        case R.id.button4: pass +="4";  break;
//                        case R.id.button5: pass +="5";  break;
//                        case R.id.button6: pass +="6";  break;
//                        case R.id.button7: pass +="7";  break;
//                        case R.id.button8: pass +="8";  break;
//                        case R.id.button9: pass +="9";  break;
//                        case R.id.button0: pass +="0";  break;   }
//                   point2.setTextColor(Color.YELLOW);
//               }
//
//                else if(pass.length()==2){
//                    switch (v.getId()) {
//                        case R.id.button1: pass +="1"; break;
//                        case R.id.button2: pass +="2"; break;
//                        case R.id.button3: pass +="3"; break;
//                        case R.id.button4: pass +="4"; break;
//                        case R.id.button5: pass +="5"; break;
//                        case R.id.button6: pass +="6"; break;
//                        case R.id.button7: pass +="7"; break;
//                        case R.id.button8: pass +="8"; break;
//                        case R.id.button9: pass +="9"; break;
//                        case R.id.button0: pass +="0"; break;
//                    }
//                   point3.setTextColor(Color.YELLOW);}
//
//                else if(pass.length()==3){
//                    switch (v.getId()) {
//                        case R.id.button1: pass +="1"; break;
//                        case R.id.button2: pass +="2";  break;
//                        case R.id.button3: pass +="3";  break;
//                        case R.id.button4: pass +="4";  break;
//                        case R.id.button5: pass +="5";  break;
//                        case R.id.button6: pass +="6";  break;
//                        case R.id.button7: pass +="7";  break;
//                        case R.id.button8: pass +="8";  break;
//                        case R.id.button9: pass +="9"; break;
//                        case R.id.button0: pass +="0";  break;}
//                   point4.setTextColor(Color.YELLOW);
//                    }
//                        if (pass.length()==4&&pass.equals(passDoc)) {
//                            Intent intent= new Intent(MainActivity.this, NotesAct.class);
//                            startActivity(intent); }
////                            setContentView(R.layout.notes);}
//                        else if (pass.length()==4){
//                            pass = "";
//                            point1.setTextColor(Color.GRAY);
//                            point2.setTextColor(Color.GRAY);
//                            point3.setTextColor(Color.GRAY);
//                            point4.setTextColor(Color.GRAY);}
//        }
//    };
}
