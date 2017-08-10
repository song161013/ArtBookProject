/**
 * @author: songfei
 * @Title:BinderActivity.java
 * @Description: 
 * @DATE: 2017-8-4上午8:40:48
 * 
 */
package com.sf.art._2IPC;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.sf.art.R;
import com.sf.art.tools.LogTool;

public class _2MessengerActivity extends Activity {
    TextView tv;
    EditText et;
    Book book = null;
    Messenger messenger = null;
    Messenger getReply = new Messenger(new h());

    private ServiceConnection serviceConnection = new ServiceConnection() {
	@Override
	public void onServiceConnected(ComponentName componentname, IBinder ibinder) {
	    messenger = new Messenger(ibinder);
	    Message msg = Message.obtain(null, _2MessengerService.FROM_CLIENT_MSG);
	    Bundle data = new Bundle();
	    data.putString("msg", "您好，这是客户端");
	    msg.setData(data);
	    msg.replyTo = getReply;
	    try {
		messenger.send(msg);
	    } catch (RemoteException e) {
		e.printStackTrace();
	    }
	}

	@Override
	public void onServiceDisconnected(ComponentName componentname) {
	}

    };

    private class h extends Handler {
	public void handleMessage(Message msg) {
	    switch (msg.what) {
	    case _2MessengerService.FROM_SERVICE_MSG:
		String s = msg.getData().getString("reply");
		LogTool.E(s);
		break;
	    }
	};
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.layout_2_second_activity);
	Intent intent = new Intent(this, _2MessengerService.class);
	bindService(intent, serviceConnection, Context.BIND_AUTO_CREATE);
	et = (EditText) findViewById(R.id.et);
	tv = (TextView) findViewById(R.id.tv);
	if (book == null) {
	    LogTool.E("book is null");
	    return;
	}
	tv.setText(book.toString());
    }

    @Override
    protected void onDestroy() {
	super.onDestroy();
	unbindService(serviceConnection);
    }

    public void btnT(View view) {
	String s = et.getText().toString();
	Message msg = new Message();
	msg.obj = s;
    }
}
