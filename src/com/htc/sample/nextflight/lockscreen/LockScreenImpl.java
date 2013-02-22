/*
 * Copyright (C) 2012 HTC Corporation
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.htc.sample.nextflight.lockscreen;

import android.app.Activity;
import android.content.Context;
import android.view.SurfaceHolder;
import android.widget.TextView;

import com.htc.lockscreen.fusion.idlescreen.SimpleIdleScreenEngine;
import com.htc.lockscreen.fusion.open.SimpleEngine;
import com.htc.sample.nextflight.Prefs;
import com.htc.sample.nextflight.R;

/**
 * The lock screen wrapper implementation class. <br>
 * Use this class to target legacy API and emulator support in addition to the
 * current API. <br>
 * See AndroidManifest to toggle support for each of the three cases there.
 */
public class LockScreenImpl extends LockScreenImplBase implements LockScreenListener {

	private TextView mNextFlightName;

    private TextView mNextFlightDetails;
    
    private Prefs mPrefs;

    public LockScreenImpl(final Context service, final SimpleEngine engine) {
        super(service, engine);
        mPrefs = new Prefs(getContext());
    }

    // support for older deprecated API
    public LockScreenImpl(final Context service, final SimpleIdleScreenEngine engine) {
        super(service, engine);
    }

    // support for running in an activity (emulator)
    public LockScreenImpl(final Activity context) {
        super(context);
    }

    @Override
    public void onCreate(final SurfaceHolder holder) {

        setContent(R.layout.lock_screen);
        setShowLiveWallpaper(true);

        mNextFlightName = (TextView)findViewById(R.id.next_flight_name);
        mNextFlightDetails = (TextView)findViewById(R.id.next_flight_details);

    }

    @Override
    public void onStart() {

    }

    @Override
    public void onResume() {
        mNextFlightName.setText(mPrefs.getNextFlightName());
        mNextFlightDetails.setText(mPrefs.getNextFlightDetails());
    }

    @Override
    public void onPause() {
    }

    @Override
    public void onStop() {
    }

    @Override
    public void onDestroy() {
    }

}
