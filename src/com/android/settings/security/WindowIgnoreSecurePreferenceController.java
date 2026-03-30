package com.android.settings.security;

import android.content.Context;
import android.provider.Settings;
import androidx.preference.Preference;
import androidx.preference.TwoStatePreference;
import com.android.settings.core.BasePreferenceController;

public class WindowIgnoreSecurePreferenceController extends BasePreferenceController {

    private static final String KEY = "window_ignore_secure";

    public WindowIgnoreSecurePreferenceController(Context context, String preferenceKey) {
        super(context, preferenceKey);
    }

    @Override
    public int getAvailabilityStatus() {
        return AVAILABLE;
    }

    @Override
    public void updateState(Preference preference) {
        int value = Settings.Global.getInt(mContext.getContentResolver(), KEY, 0);
        ((TwoStatePreference) preference).setChecked(value != 0);
    }

    @Override
    public int getSliceHighlightMenuRes() {
        return 0;
    }

    @Override
    public boolean handlePreferenceTreeClick(Preference preference) {
        if (KEY.equals(preference.getKey())) {
            TwoStatePreference switchPref = (TwoStatePreference) preference;
            boolean isChecked = switchPref.isChecked();
            Settings.Global.putInt(mContext.getContentResolver(), KEY, isChecked ? 1 : 0);
            return true;
        }
        return false;
    }
}
