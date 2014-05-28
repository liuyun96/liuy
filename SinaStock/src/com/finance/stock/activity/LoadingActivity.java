package com.finance.stock.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.finance.stock.R;

@SuppressLint("NewApi")
public class LoadingActivity extends BaseActivity {
	private ShowMainUI showMainUI = new ShowMainUI();
	private Handler mHandler = new Handler();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//initView();
		showMainUI();
		this.mHandler.postDelayed(this.showMainUI, 100L);
	}

	private void initView() {
		getWindow().setBackgroundDrawableResource(R.drawable.loading);
	}

	private void showMainUI() {
		Intent localIntent = new Intent();
		//localIntent.setClass(this, MainActivity.class);
		//localIntent.setClass(this, ViewFlipperActivity.class);
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
