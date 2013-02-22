package com.htc.sample.nextflight.activity;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.Window;

import com.htc.sample.nextflight.R;
import com.htc.sample.nextflight.lockscreen.LockScreenHelper;

public class LockScreenDialog extends Dialog {
	
	public LockScreenDialog(Context context) {
		super(context);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setBackgroundDrawable(null);
		setContentView(R.layout.lock_screen_dialog);

		final View openSettings = findViewById(R.id.lock_screen_dialog_open_settings_button);
		openSettings.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(final View v) {
				showSettings();
				dismiss();
			}
		});
		
		final View close = findViewById(R.id.lock_screen_dialog_close_button);
		close.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(final View v) {
				dismiss();
			}
		});				
	}
	
	private void showSettings() {
		LockScreenHelper.openLockScreenChooser(getContext());	
	}

}
