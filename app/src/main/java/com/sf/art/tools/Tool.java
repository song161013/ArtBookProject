/**
 * @author: songfei
 * @Title:Tool.java
 * @Description: 
 * @DATE: 2017-8-8下午1:45:14
 * 
 */
package com.sf.art.tools;

import android.content.Context;
import android.os.Environment;
import android.util.DisplayMetrics;
import android.view.WindowManager;

import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Tool {
	/*关闭流操作**/
	public static void close(Closeable closeable) {
	try {
	    if (closeable != null) {
		closeable.close();
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	}
    }

	/*获取分辨率*/
	public static DisplayMetrics dispalyMetric(Context context){
		WindowManager wm= (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
		DisplayMetrics outMetrics=new DisplayMetrics();
		wm.getDefaultDisplay().getMetrics(outMetrics);
		return outMetrics;
	}

	/*将字符串保存到sd上*/
	public static void saveToFile(Context context, String companyName,String datas) {
		//路径是  /包名/文件名
		String packname = context.getPackageName();

		String sdPath = Environment.getExternalStorageDirectory().getPath();
		String sperator = File.separator;
		File dir = new File(sdPath,  companyName+ sperator + packname);
		if (!dir.exists()) {
			dir.mkdirs();
		}
		Date curDate = new Date(System.currentTimeMillis());
		SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
		String time = format.format(curDate);
		File file = new File(dir, time + ".txt");
		try {
			FileOutputStream fos = new FileOutputStream(file);
			fos.write(datas.getBytes());
			fos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
