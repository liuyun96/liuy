package com.finance.stock.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;

import com.finance.stock.R;

public class ItemActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.item_detail);
		ImageView localImageView1 = (ImageView) findViewById(R.id.backImg);
		localImageView1.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				finish();
			}
		});
	}

	public void hideBar(View view) {
		RelativeLayout bar = (RelativeLayout) findViewById(R.id.actionbar);
		int v = bar.getVisibility();
		if (v == View.VISIBLE) {
			bar.setVisibility(View.GONE);
		} else {
			bar.setVisibility(View.VISIBLE);
		}
	}
}
