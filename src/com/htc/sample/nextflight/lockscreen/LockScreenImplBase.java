
package com.htc.sample.nextflight.lockscreen;

import android.app.Activity;
import android.app.WallpaperManager;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;

import com.htc.lockscreen.fusion.idlescreen.SimpleIdleScreenEngine;
import com.htc.lockscreen.fusion.open.SimpleEngine;

public class LockScreenImplBase {

	private SimpleIdleScreenEngine mLegacyEngine;
	
	private SimpleEngine mEngine;
    
	private Activity mActivity;
		
	private Context mService;
	
	public LockScreenImplBase(final Context service, final SimpleIdleScreenEngine legacyEngine) {
		mLegacyEngine = legacyEngine;
		mService = service;
	}

	public LockScreenImplBase(final Context service, final SimpleEngine engine) {
		mEngine = engine;
		mService = service;
	}
	
	public LockScreenImplBase(final Activity activity) {
	    mActivity = activity;
	}
	
	public boolean isActivity() {
	    return mActivity == null ? false : true;
	}
	
	public Context getContext() {
		if ( null != mActivity ) {
			return mActivity;
		} 
		
		return mService;
	}

	protected void setContent(int main) {
		if(mEngine!=null) {
			mEngine.setContent(main);
		} else if(mLegacyEngine!=null){
		    mLegacyEngine.setContent(main);
        } else if(mActivity!=null) {
            mActivity.setContentView(main);
        }
	}
    protected void setContent(View view) {
        if(mEngine!=null) {
            mEngine.setContent(view);
        } else if(mLegacyEngine!=null){
            mLegacyEngine.setContent(view);
        } else if(mActivity!=null) {
            mActivity.setContentView(view);
        }
    }
    protected void setBackground(Drawable drawable) {
        if(mEngine!=null) {
            mEngine.setBackground(drawable);
        } else if(mLegacyEngine!=null){
            mLegacyEngine.setBackground(drawable);
        } else if(mActivity!=null) {
            ((ViewGroup)mActivity.getWindow().getDecorView()).getChildAt(0).setBackgroundDrawable(drawable);
        }
    }
    protected void setBackground(int resid) {
        if(mEngine!=null) {
            mEngine.setBackground(resid);
        } else if(mLegacyEngine!=null){
            mLegacyEngine.setBackground(resid);
        } else if(mActivity!=null) {
            ((ViewGroup)mActivity.getWindow().getDecorView()).getChildAt(0).setBackgroundResource(resid);
        }
    }
	protected void setShowLiveWallpaper(boolean b) {
		if(mEngine!=null) {
			mEngine.setShowLiveWallpaper(b);
		} else if(mLegacyEngine!=null) {
			mLegacyEngine.setShowLiveWallpaper(b);
        } else if(mActivity!=null) {
			setBackground(WallpaperManager.getInstance(mActivity).getDrawable());
		}
	}
	protected void skipShowHint() {
		if(mEngine!=null) {
			mEngine.skipShowHint();
		} else if(mLegacyEngine!=null) {
			//not available			
		}		
	}
	
	protected View findViewById(int id) {
		if(mLegacyEngine!=null) {
			return mLegacyEngine.findViewById(id);
		} else if(mEngine!=null) {
			return mEngine.findViewById(id);
        } else if(mActivity!=null) {
			return mActivity.findViewById(id);
		}
		return null;
	}

}