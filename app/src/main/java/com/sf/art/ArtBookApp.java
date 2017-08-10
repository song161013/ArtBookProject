/**
 * @author: songfei
 * @Title:ArtBookApp.java
 * @Description: 
 * @DATE: 2017-8-8下午1:50:37
 * 
 */
package com.sf.art;

import com.sf.art.crash.CrashHandler;

import android.app.Application;

public class ArtBookApp extends Application {
    @Override
    public void onCreate() {
	super.onCreate();
	CrashHandler crashHandler = CrashHandler.getInstance();
	crashHandler.init(this);
    }
}
