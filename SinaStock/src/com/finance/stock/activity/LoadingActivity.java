package com.finance.stock.activity;

import com.finance.stock.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class LoadingActivity extends Activity {
	private ShowMainUI showMainUI = new ShowMainUI();
	private Handler mHandler = new Handler();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		initView();
		this.mHandler.postDelayed(this.showMainUI, 1000L);
	}

	private void initView() {
		getWindow().setBackgroundDrawableResource(R.drawable.loading);
	}

	private void showMainUI() {
		Intent localIntent = new Intent();
		localIntent.setClass(this, MainActivity.class);
		startActivity(localIntent);
		finish();
	}

	private final class ShowMainUI implements Runnable {
		private ShowMainUI() {

		}

		public void run() {
			LoadingActivity.this.showMainUI();
		}
	}
}
