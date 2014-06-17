package com.finance.stock.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import com.finance.stock.R;

@SuppressLint("NewApi")
public class LoadingActivity extends BaseActivity {
	private ShowMainUI showMainUI = new ShowMainUI();
	private Handler mHandler = new Handler();

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		// 如果被回收了记录状态
		outState.putLong("id", 12345678);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		if (savedInstanceState != null) {
			long id = savedInstanceState.getLong("id");
			Log.e("id", "" + id);
			onResume();
			// onStart();
			return;
		}
		super.onCreate(savedInstanceState);
		initView();
		showMainUI();
		this.mHandler.postDelayed(this.showMainUI, 100L);
	}
	
	private void initView() {
		getWindow().setBackgroundDrawableResource(R.drawable.loading);
	}

	private void showMainUI() {
		Intent localIntent = new Intent();
		// localIntent.setClass(this, MainActivity.class);
		// localIntent.setClass(this, ViewFlipperActivity.class);
		localIntent.setClass(this, MoreDateListActivity.class);
		startActivity(localIntent);
		finish();
		sendNotice(1);
	}

	private final class ShowMainUI implements Runnable {
		private ShowMainUI() {

		}
		public void run() {
			sendNotice(1);
			LoadingActivity.this.showMainUI();
		}
	}

}
