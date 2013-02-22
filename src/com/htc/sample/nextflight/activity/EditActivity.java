package com.htc.sample.nextflight.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import com.htc.sample.nextflight.Prefs;
import com.htc.sample.nextflight.R;
import com.htc.sample.nextflight.lockscreen.LockScreenHelper;
import com.htc.sample.nextflight.widget.WidgetProvider;

public class EditActivity extends Activity {

	private EditText mNextFlightName;

    private EditText mNextFlightDetails;
    
    private Prefs mPrefs;

    @Override
    public void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPrefs = new Prefs(this);
        
        final boolean enabledLockScreen = LockScreenHelper.enable(this);
        if (enabledLockScreen) {
            if (!mPrefs.getShowedLockScreenDialog()) {
                new LockScreenDialog(this).show();
                mPrefs.setShowedLockScreenDialog(true);
            }
        }

        setContentView(R.layout.edit_view);
        final Button help = (Button) findViewById(R.id.help_button);
        help.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
                new LockScreenDialog(EditActivity.this).show();
			}
		});

        mNextFlightName = (EditText)findViewById(R.id.flight_name_edit);
        mNextFlightDetails = (EditText)findViewById(R.id.flight_details_edit);

    }

    @Override
    protected void onResume() {
        super.onResume();
        mNextFlightName.setText(mPrefs.getNextFlightName());
        mNextFlightDetails.setText(mPrefs.getNextFlightDetails());
    }

    @Override
    protected void onPause() {
        super.onPause();
        mPrefs.setNextFlightName(mNextFlightName.getText().toString());
        mPrefs.setNextFlightDetails(mNextFlightDetails.getText().toString());
        WidgetProvider.update(this);
    }

}
