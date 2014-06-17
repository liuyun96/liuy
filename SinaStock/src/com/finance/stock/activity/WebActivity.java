package com.finance.stock.activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

@SuppressLint("NewApi")
public class WebActivity extends BaseActivity {
	@Override
	protected void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		outState.putLong("id", 12345678);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		initWeb();
	}

	//È±µã¼ÓÔØºÜÂý
	private void initWeb() {
		// setContentView(R.layout.web);
		WebView webView = new WebView(this);
		webView.getSettings().setJavaScriptEnabled(true);
		webView.loadUrl("file:///android_asset/index.html");
/*		String encoding = "UTF-8";
		String mimeType = "text/html";
		final String html = "http://www.baidu.com";
		webView.loadDataWithBaseURL("file://", html, mimeType, encoding,
				"about:blank");*/
		webView.setWebViewClient(new WebViewClient() {
			@Override
			public boolean shouldOverrideUrlLoading(WebView view, String url) {
				// TODO Auto-generated method stub
				view.loadUrl(url);
				return true;
			}
		});
		setContentView(webView);
	}

}
