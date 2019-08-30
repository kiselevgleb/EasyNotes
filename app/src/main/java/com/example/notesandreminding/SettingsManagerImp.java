package com.example.notesandreminding;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.Nullable;

public class SettingsManagerImp implements SettingsManager{
    private static final String SHARED_PREFERENCE_NAME = "settings_preferences";
    private static final String KEY_PIN_CODE = "pin_code";

    private final SharedPreferences preferences;

    public SettingsManagerImp(Context context) {
        this.preferences = context.getSharedPreferences(SHARED_PREFERENCE_NAME, Context.MODE_PRIVATE);
    }

    public void setPinCode(String pinCode) {
        preferences.edit()
                .putString(KEY_PIN_CODE, pinCode)
                .apply();
    }

    @Nullable
    public String getPinCode() {
        return preferences.getString(KEY_PIN_CODE, null);
    }

    public boolean hasPinCode() {
        return preferences.contains(KEY_PIN_CODE);
    }
}