/**
 * @author: songfei
 * @Title:_1activity.java
 * @Description: 
 * @DATE: 2017-7-31上午9:36:56
 * 
 */
package com.sf.art._1activity;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.sf.art.R;

public class newActivity extends Activity {
    public final static String TAG = "newActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.layout_1activity_new);
	Log.e("", TAG + "-----onCreate");
    }

    @Override
    protected void onStart() {
	super.onStart();
	Log.e("", TAG + "-----onStart");
    }

    @Override
    protected void onRestart() {
	super.onRestart();
	Log.e("", TAG + "----onRestart");
    }

    @Override
    protected void onResume() {
	super.onResume();
	Log.e("", TAG + "-----onResume");
    }

    @Override
    protected void onPause() {
	super.onPause();
	Log.e("", TAG + "-----onPause");
    }

    @Override
    protected void onStop() {
	super.onStop();
	Log.e("", TAG + "-----onStop");
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
	super.onConfigurationChanged(newConfig);
    }

    @Override
    protected void onDestroy() {
	super.onDestroy();
	Log.e("", TAG + "-----onDestroy");
    }
}
