
package com.htc.sample.nextflight;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;

public class Prefs {

    private static final String SHOWED_LOCKSCREEN_DIALOG_KEY = Prefs.class.getName()
            + ".SHOWED_LOCKSCREEN_DIALOG_KEY";

    private static final String NEXT_FLIGHT_NAME_KEY = Prefs.class.getName()
            + ".NEXT_FLIGHT_NAME_KEY";

    private static final String NEXT_FLIGHT_DETAILS_KEY = Prefs.class.getName()
            + ".NEXT_FLIGHT_DETAILS_KEY";

    private final SharedPreferences mPrefs;

    public Prefs(final Context context) {
        mPrefs = PreferenceManager.getDefaultSharedPreferences(context);
    }

    public boolean getShowedLockScreenDialog() {
        return mPrefs.getBoolean(SHOWED_LOCKSCREEN_DIALOG_KEY, false);
    }

    public void setShowedLockScreenDialog(final boolean newValue) {
        final Editor edit = mPrefs.edit();
        edit.putBoolean(SHOWED_LOCKSCREEN_DIALOG_KEY, newValue);
        edit.commit();
    }

    public String getNextFlightName() {
        return mPrefs.getString(NEXT_FLIGHT_NAME_KEY, "AA Flight 03 (CJKDF3)");
    }

    public void setNextFlightName(final String newValue) {
        final Editor edit = mPrefs.edit();
        edit.putString(NEXT_FLIGHT_NAME_KEY, newValue);
        edit.commit();
    }

    public String getNextFlightDetails() {
        return mPrefs.getString(NEXT_FLIGHT_DETAILS_KEY, "2/30 9AM Terminal 2 DFW");
    }

    public void setNextFlightDetails(final String newValue) {
        final Editor edit = mPrefs.edit();
        edit.putString(NEXT_FLIGHT_DETAILS_KEY, newValue);
        edit.commit();
    }


}
