
package com.htc.sample.nextflight.lockscreen;

import android.view.SurfaceHolder;

import com.htc.lockscreen.fusion.open.SimpleEngine;
import com.htc.lockscreen.fusion.open.SimpleIdleScreenService;

public class SampleService extends SimpleIdleScreenService {

    @Override
    public SimpleEngine onCreateEngine() {
        return new IdleScreenRemoteEngine();
    }

    public class IdleScreenRemoteEngine extends SimpleEngine implements LockScreenListener {

		private LockScreenImpl lockScreen = new LockScreenImpl(SampleService.this, this);

        public IdleScreenRemoteEngine() {
        }

        public void onCreate(final SurfaceHolder holder) {
        	lockScreen.onCreate(holder);
        }

        public void onStart() {
    		lockScreen.onStart();
	    }
	
	    public void onResume() {
			lockScreen.onResume();
	    }
	
	    public void onPause() {
			lockScreen.onPause();
	    }
	
	    public void onStop() {
			lockScreen.onStop();
	    }
	
	    public void onDestroy() {
			lockScreen.onDestroy();
	    }
	
    }
}
