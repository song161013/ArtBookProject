/**
 * @author: songfei
 * @Title:_2MessengerService.java
 * @Description: 
 * @DATE: 2017-8-8下午4:17:43
 * 
 */
package com.sf.art._2IPC;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;

import com.sf.art.tools.LogTool;

public class _2MessengerService extends Service {
    public static final int FROM_CLIENT_MSG = 1;
    public static final int FROM_SERVICE_MSG = 2;
    private final Messenger messenger = new Messenger(new MessengerHandler());

    private class MessengerHandler extends Handler {
	@Override
	public void handleMessage(Message msg) {
	    super.handleMessage(msg);
	    switch (msg.what) {
	    case FROM_CLIENT_MSG: {
		String s = msg.getData().getString("msg");
		LogTool.E("收到消息," + s);
		Messenger reply = msg.replyTo;
		Message replyMsg = Message.obtain(null, FROM_SERVICE_MSG);
		Bundle b = new Bundle();
		b.putString("reply", "恩，已收到你发的消息");
		replyMsg.setData(b);
		try {
		    reply.send(replyMsg);
		} catch (RemoteException e) {
		    e.printStackTrace();
		}
		break;
	    }
	    }
	}
    }

    @Override
    public IBinder onBind(Intent intent) {
	return messenger.getBinder();
    }

}
