/**
 * @author: songfei
 * @Title:BinderActivity.java
 * @Description: 
 * @DATE: 2017-8-4上午8:40:48
 * 
 */
package com.sf.art._2IPC;

import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.os.Messenger;
import android.view.View;

import com.sf.art.R;
import com.sf.art.tools.LogTool;
import com.sf.art.tools.Tool;

public class BinderActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.layout_2activity);
    }

    @Override
    protected void onStart() {
	super.onStart();
	saveToFile();
    }

    public void _2ActivityBtn(View view) {
	Intent intent = new Intent(this, _2SecondActivity.class);
	startActivity(intent);
    }

    public void _2MessngerBtn(View view) {
	Intent intent = new Intent(this, _2MessengerActivity.class);
	startActivity(intent);
    }

    private void saveToFile() {
	new Thread(new Runnable() {
	    @Override
	    public void run() {
		Book book = new Book(1, "开发探索");

		String path = Environment.getExternalStorageDirectory().getPath();
		File dir = new File(path);

		if (!dir.exists()) {
		    dir.mkdirs();
		}
		ObjectOutputStream ois = null;
		try {
		    File file = new File(path, "bookcache.pro");
		    LogTool.E("来啦。。" + file);
		    if (!file.exists()) {
			file.createNewFile();
		    }
		    ois = new ObjectOutputStream(new FileOutputStream(file));
		    ois.writeObject(book);
		    LogTool.E("保存成功");
		} catch (Exception e) {
		    e.printStackTrace();
		    LogTool.E("序列化是异常了" + e);
		} finally {
		    Tool.close(ois);
		}
	    }
	}) {
	}.start();
    }
}
