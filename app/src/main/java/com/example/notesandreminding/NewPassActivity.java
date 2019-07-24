package com.example.notesandreminding;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

public class NewPassActivity extends AppCompatActivity {
    EditText pass;
    CheckBox showPassCheckbox;
    Button save;
    private String VALUE_SP = "PrivateValue";
    private SettingsManager settingsManager = MainActivity.getSettingsManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_pass);
        pass = (EditText) findViewById(R.id.passNew);
        showPassCheckbox = (CheckBox) findViewById(R.id.checkBoxPass);
        save = (Button) findViewById(R.id.buttonSavePass);
        showPassCheckbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    pass.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                } else {
                    pass.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
            }
        });
        save.setOnClickListener(clickListener);

    }

    private View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (pass.getText().toString().length() == 4) {
                String p = pass.getText().toString();
                settingsManager.setPinCode(p);
                Intent intent = new Intent(NewPassActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            } else {
                Toast.makeText(getApplicationContext(), R.string.pass_eror, Toast.LENGTH_SHORT).show();
            }
        }
    };
}
