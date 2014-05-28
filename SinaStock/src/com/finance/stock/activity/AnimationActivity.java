package com.finance.stock.activity;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.finance.stock.R;

public class AnimationActivity extends BaseActivity {

	Animation slideInLeft;
	Animation slideOutLeft;
	Animation slideInRight;
	Animation slideOutRight;
	Animation slideInTop;
	Animation slideOutTop;
	Animation slideInBottom;
	Animation slideOutBottom;
	TextView myTextView;

	@Override
	public void onCreate(Bundle icicle) {
		super.onCreate(icicle);
		setContentView(R.layout.animation);

		// slideInLeft = AnimationUtils.loadAnimation(this,
		// R.anim.slide_left_in);
		// slideOutLeft = AnimationUtils.loadAnimation(this,
		// R.anim.slide_left_out);
		// slideInRight = AnimationUtils.loadAnimation(this,
		// R.anim.slide_right_in);
		// slideOutRight =AnimationUtils.loadAnimation(this,
		// R.anim.slide_right_out);
		slideInTop = AnimationUtils.loadAnimation(this,
				R.anim.slide_in_from_top);
		slideOutTop = AnimationUtils.loadAnimation(this,
				R.anim.slide_out_to_top);
		slideInBottom = AnimationUtils.loadAnimation(this,
				R.anim.slide_in_from_bottom);
		slideOutBottom = AnimationUtils.loadAnimation(this,
				R.anim.slide_out_to_bottom);

		myTextView = (TextView) findViewById(R.id.myTextView);
	}

	private void applyAnimation(Animation _out, Animation _in, String _newText) {
		final String text = _newText;
		final Animation in = _in;

		// ��֤�����������֮���ı�Ҳ������Ļ�ϡ�
		_out.setFillAfter(true);
		// ����һ�����������ȴ��������������
		_out.setAnimationListener(new AnimationListener() {

			@Override
			public void onAnimationStart(Animation animation) {
				// �ı��ı�
				myTextView.setText(text);
				// ����������View��
				myTextView.startAnimation(in);
			}

			@Override
			public void onAnimationRepeat(Animation animation) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onAnimationEnd(Animation animation) {
				// TODO Auto-generated method stub

			}
		});

		// ������������
		myTextView.startAnimation(_out);
	}
}
