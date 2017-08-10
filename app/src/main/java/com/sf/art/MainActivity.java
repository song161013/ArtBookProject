/**
 * @author: songfei
 * @Title:MainActivity.java
 * @Description: 
 * @DATE: 2017-7-13下午5:51:15
 * 
 */
package com.sf.art;

import com.sf.art._11thread.ThreadTest;
import com.sf.art._1activity._1activity;
import com.sf.art._1activity.newActivity;
import com.sf.art._2IPC.BinderActivity;
import com.sf.art._3view_event._3viewEvetActivity;
import com.sf.art._5remoteviews.RemoteViews5Activity;
import com.sf.art._7animation._7Animation;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.activity_main);
    }

    /** 第1章 */
    public void _1activityBtn(View view) {
	Intent intent = new Intent(this, _1activity.class);
	startActivity(intent);
    }
    /** 第2章 */
    public void _2IPCBtn(View view) {
        Intent i = new Intent(this, BinderActivity.class);
        startActivity(i);
    }
    /** 第2章 */
    public void _3ViewEventBtn(View view) {
        Intent i = new Intent(this, _3viewEvetActivity.class);
        startActivity(i);
    }
    /** 第5章 remoteViews5 */
    public void remoteViewsBtn5(View view) {
	Intent i = new Intent(this, RemoteViews5Activity.class);
	startActivity(i);
    }

    public void DrawableBtn6(View view) {
	Intent i = new Intent(this, RemoteViews5Activity.class);
	startActivity(i);
    }

    public void ThreadBtn11(View view) {
	Intent i = new Intent(this, ThreadTest.class);
	startActivity(i);
    }



    /** 第7章 动画 */
    public void AnimationBtn7(View view) {
	Intent i = new Intent(this, _7Animation.class);
	startActivity(i);
    }
}
