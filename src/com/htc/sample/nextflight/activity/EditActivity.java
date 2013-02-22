/*
 * Copyright 2011 Lauri Nevala.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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
    }

}
