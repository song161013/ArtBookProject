/**
 * @author: songfei
 * @Title:ThreadTest.java
 * @Description: 
 * @DATE: 2017-7-22下午5:13:40
 * 
 */
package com.sf.art._11thread;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;

import com.sf.art.R;

public class ThreadTest extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.layout_11thread);
    }

    private class AsyncTest extends AsyncTask<String, Integer, String> {
	@Override
	protected String doInBackground(String... params) {
	    return null;
	}

	@Override
	protected void onPostExecute(String result) {
	    super.onPostExecute(result);
	}

	@Override
	protected void onProgressUpdate(Integer... values) {
	    super.onProgressUpdate(values);
	}

	@Override
	protected void onPreExecute() {
	    super.onPreExecute();
	}
    }
}
