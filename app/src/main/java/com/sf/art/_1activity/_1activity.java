/**
 * @author: songfei
 * @Title:_1activity.java
 * @Description: 
 * @DATE: 2017-7-31上午9:36:56
 * 
 */
package com.sf.art._1activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.sf.art.R;

public class _1activity extends Activity {
    public final static String TAG = "_1activity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.layout_1activity);
	Log.e("", TAG + "-----onCreate");
    }

    public void activityBtn(View view) {
	Intent intent = new Intent(this, newActivity.class);
	startActivity(intent);
    }

    @Override
    protected void onStart() {
	super.onStart();
	Log.e("", TAG + "-----onStart");
    }

    @Override
    protected void onRestart() {
	super.onRestart();
	Log.e("", TAG + "-----onRestart");
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
    protected void onDestroy() {
	super.onDestroy();
	Log.e("", TAG + "-----onDestroy");
    }
}
