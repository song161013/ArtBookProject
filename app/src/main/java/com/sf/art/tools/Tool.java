/**
 * @author: songfei
 * @Title:Tool.java
 * @Description: 
 * @DATE: 2017-8-8下午1:45:14
 * 
 */
package com.sf.art.tools;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;

import java.io.Closeable;

public class Tool {
	/*关闭流操作*/
    public static void close(Closeable closeable) {
	try {
	    if (closeable != null) {
		closeable.close();
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	}
    }
    public static DisplayMetrics dispalyMetric(Context context){
		WindowManager wm= (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
		DisplayMetrics outMetrics=new DisplayMetrics();
		wm.getDefaultDisplay().getMetrics(outMetrics);
		return outMetrics;
	}
}
