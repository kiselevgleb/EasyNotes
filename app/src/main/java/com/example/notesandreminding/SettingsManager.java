package com.example.notesandreminding;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.Nullable;

public interface SettingsManager {

    public void setPinCode(String pinCode);

    @Nullable
    public String getPinCode();

    public boolean hasPinCode();
}
