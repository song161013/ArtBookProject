/**
 * @author: songfei
 * @Title:LogTool.java
 * @Description: 
 * @DATE: 2017-8-8下午2:22:06
 * 
 */
package com.sf.art.tools;

import android.util.Log;

public class LogTool {
    private static boolean isLog = true;

    public static void E(String TAG, String message) {
	if (isLog)
	    Log.e(TAG, message);
    }

    public static void E(String message) {
	E("", message);
    }
}
