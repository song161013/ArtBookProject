/**
 * @author: songfei
 * @Title:BinderActivity.java
 * @Description: 
 * @DATE: 2017-8-4上午8:40:48
 * 
 */
package com.sf.art._2IPC;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.StreamCorruptedException;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.widget.TextView;

import com.sf.art.R;
import com.sf.art.tools.LogTool;
import com.sf.art.tools.Tool;

public class _2SecondActivity extends Activity {
    TextView tv;
    Book book = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.layout_2_second_activity);
	tv = (TextView) findViewById(R.id.tv);
	readToFile();
	if (book == null) {
	    LogTool.E("book is null");
	    return;
	}
	tv.setText(book.toString());
    }

    private void readToFile() {
	String path = Environment.getExternalStorageDirectory().getPath();
	File file = new File(path, "bookcache.pro");
	ObjectInputStream ois = null;
	try {
	    ois = new ObjectInputStream(new FileInputStream(file));
	    book = (Book) ois.readObject();
	} catch (StreamCorruptedException e) {
	    e.printStackTrace();
	} catch (FileNotFoundException e) {
	    e.printStackTrace();
	} catch (IOException e) {
	    e.printStackTrace();
	} catch (ClassNotFoundException e) {
	    e.printStackTrace();
	} finally {
	    Tool.close(ois);
	}
    }
}
