package com.android.settings.security;

import android.content.Context;
import android.provider.Settings;

import androidx.preference.Preference;
import androidx.preference.SwitchPreferenceCompat;

import com.android.settings.core.TogglePreferenceController;

public class WindowIgnoreSecurePreferenceController extends TogglePreferenceController {

    public WindowIgnoreSecurePreferenceController(Context context, String key) {
        super(context, key);
    }

    @Override
    public boolean isChecked() {
        return Settings.Global.getInt(
                mContext.getContentResolver(),
                "window_ignore_secure", 0) == 1;
    }

    @Override
    public boolean setChecked(boolean isChecked) {
        return Settings.Global.putInt(
                mContext.getContentResolver(),
                "window_ignore_secure",
                isChecked ? 1 : 0
        );
    }

    @Override
    public int getAvailabilityStatus() {
        return AVAILABLE;
    }

    @Override
    public int getSliceHighlightMenuRes() {
        return 0;
    }

    @Override
    public void updateState(Preference preference) {
        boolean enabled = isChecked();
        ((SwitchPreferenceCompat) preference).setChecked(enabled);
    }
}
