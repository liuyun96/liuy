package com.finance.stock.activity;

import com.finance.stock.R;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

@SuppressLint("NewApi")
public class BaseActivity extends Activity {

	public void showToast(View view, String text) {
		Toast toast = new Toast(getApplicationContext());
		toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
		toast.setDuration(Toast.LENGTH_LONG);
		toast.setView(view);
		toast.setText(text);
		toast.show();
	}

	public NotificationManager getNotificationManager() {
		NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
		return notificationManager;
	}
	
	public void sendNotice(int id) {
		Intent notificationIntent = new Intent(this, MainActivity.class);
		notificationIntent.putExtra("notice_id", 1);
		PendingIntent contentIntent = PendingIntent.getActivity(this, 0,
				notificationIntent, 0);
		Notification notification = new Notification.Builder(
				this.getApplicationContext()).setContentTitle("New mail from ")
				.setContentText("hello").setSmallIcon(R.drawable.ic_launcher)
				.setContentIntent(contentIntent).build();
		getNotificationManager().notify(id, notification);
	}

}
