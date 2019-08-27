package com.example.notesandreminding;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.Nullable;

public interface SettingsManager {
    static final String SHARED_PREFERENCE_NAME = "settings_preferences";
    static final String KEY_PIN_CODE = "pin_code";

    final SharedPreferences preferences = null;

    public void setPinCode(String pinCode);

    @Nullable
    public String getPinCode();

    public boolean hasPinCode();
}
