
package com.htc.sample.nextflight.lockscreen;

import android.view.SurfaceHolder;

public interface LockScreenListener {
	public void onCreate(final SurfaceHolder holder);
    public void onStart();
    public void onResume();
    public void onPause();
    public void onStop();
    public void onDestroy();
}
