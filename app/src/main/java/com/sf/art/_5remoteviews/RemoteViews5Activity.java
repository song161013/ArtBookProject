/**
 * @author: songfei
 * @Title:RemoteViews5Activity.java
 * @Description: 
 * @DATE: 2017-7-13下午6:03:03
 * 
 */
package com.sf.art._5remoteviews;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.RemoteViews;

import com.sf.art.R;

public class RemoteViews5Activity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	requestWindowFeature(Window.FEATURE_NO_TITLE);
	setContentView(R.layout.layout_remoteviews);
    }

    public void NotifityBtn(View view) {
	notify(this);
    }

    public void customNotifityBtn(View view) {
	customNotify(this);
    }

    private static int sId = 0;

    @TargetApi(16)
    private void notify(Context context) {
	Notification notification = new Notification();
	notification.icon = R.mipmap.ic_launcher;
	notification.tickerText = "hello world";
	notification.when = System.currentTimeMillis();
	Intent intent = new Intent(this, NotifyActivity.class);
	PendingIntent pIntent = PendingIntent.getActivity(context, 0, intent,
		PendingIntent.FLAG_UPDATE_CURRENT);
	//notification.setLatestEventInfo(context, "第5章", "这是notify", pIntent);
	notification.flags = Notification.FLAG_AUTO_CANCEL;
	NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
	manager.notify(1, notification);
    }

    private void customNotify(Context context) {
	Notification notification = new Notification();
	notification.icon = R.drawable.ic_launcher;
	notification.tickerText = "hello world";
	notification.when = System.currentTimeMillis();
	Intent intent = new Intent(this, NotifyActivity.class);
	PendingIntent pIntent = PendingIntent.getActivity(context, 0, intent,
		PendingIntent.FLAG_CANCEL_CURRENT);
	notification.flags = Notification.FLAG_AUTO_CANCEL;
	RemoteViews remoteView = new RemoteViews(getPackageName(), R.layout.layout_custom_notify);
	remoteView.setTextViewText(R.id.tv_1, "5章");
	remoteView.setImageViewResource(R.id.bird, R.drawable.bird);
	remoteView.setOnClickPendingIntent(R.id.tv_2, pIntent);
	notification.contentView = remoteView;
	notification.contentIntent = pIntent;
	NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
	manager.notify(1, notification);
    }
}
