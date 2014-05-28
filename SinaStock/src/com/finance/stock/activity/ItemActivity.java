package com.finance.stock.activity;

import android.content.Intent;
import android.gesture.GestureOverlayView;
import android.gesture.GestureOverlayView.OnGestureListener;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.finance.stock.R;

public class ItemActivity extends BaseActivity implements OnGestureListener,
		OnDoubleTapListener {
	WebView webView;
	private final String TAG = "TestMotionEvent";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.item_detail);
		ImageView localImageView1 = (ImageView) findViewById(R.id.backImg);
		RelativeLayout webView = (RelativeLayout) findViewById(R.id.rl);
		webView.setOnTouchListener(new TouchImp(this));
		Intent localIntent = getIntent();
		Log.v(TAG, "viewId" + localIntent.getStringExtra("id"));
		localImageView1.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				finish();
			}
		});
	}

	private final class TouchImp implements View.OnTouchListener {
		public TouchImp(ItemActivity paramItemDetailActivity) {

		}

		@Override
		public boolean onTouch(View v, MotionEvent event) {
			float x = event.getX();
			float y = event.getY();
			// showToast(, "action" + event.getAction());
			Log.v(TAG, "X = " + x + "  " + "Y = " + y);
			switch (event.getAction()) {
			case MotionEvent.ACTION_MOVE:
				Log.v(TAG, "X = " + x + "  " + "Y = " + y
						+ "MotionEvent.ACTION_MOVE" + MotionEvent.ACTION_MOVE);
				finish();
				Intent intent = new Intent();
				intent.setClass(getApplicationContext(), AnimationActivity.class);
				startActivity(intent);
				break;
			default:
				break;
			}
			return false;
		}
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

	@Override
	public boolean onDoubleTap(MotionEvent arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean onDoubleTapEvent(MotionEvent arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean onSingleTapConfirmed(MotionEvent arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void onGesture(GestureOverlayView overlay, MotionEvent event) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onGestureCancelled(GestureOverlayView overlay, MotionEvent event) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onGestureEnded(GestureOverlayView overlay, MotionEvent event) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onGestureStarted(GestureOverlayView overlay, MotionEvent event) {
		// TODO Auto-generated method stub

	}
}
