
package com.htc.sample.nextflight.lockscreen;

import android.view.SurfaceHolder;

import com.htc.lockscreen.fusion.idlescreen.SimpleIdleScreenEngine;
import com.htc.lockscreen.idlescreen.IdleScreenEngine;
import com.htc.lockscreen.idlescreen.IdleScreenService;

/**
 * Support for roms not updated with final lockscreen API   
 */
@Deprecated
public class SampleServiceLegacy extends IdleScreenService {

    @Override
    public IdleScreenEngine onCreateEngine() {
        return new IdleScreenRemoteEngine();
    }

    public class IdleScreenRemoteEngine extends SimpleIdleScreenEngine implements LockScreenListener {

		private LockScreenImpl lockScreen = new LockScreenImpl(SampleServiceLegacy.this, this);

		public IdleScreenRemoteEngine() {
            super(SampleServiceLegacy.this);
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
