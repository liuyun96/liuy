package com.finance.stock.activity;

import java.io.File;
import java.io.FileOutputStream;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.widget.Toast;

import com.finance.stock.R;

@SuppressLint("NewApi")
public class FileActivity extends BaseActivity {

	private String FILENAME = "test.txt";
	private String folderName = "/mytest";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		initWeb();
	}

	private void createFile() {
		String file = Environment.getExternalStorageDirectory().getPath()
				+ folderName;
		File destDir = new File(file);
		if (!destDir.exists()) {
			destDir.mkdirs();
		}
	}

	// ȱ����غ���
	private void initWeb() {
		setContentView(R.layout.web);
		Log.e("file", Environment.getDataDirectory().getPath());
		Log.e("file", Environment.getDownloadCacheDirectory().getPath());
		Log.e("file", Environment.getExternalStorageDirectory().toString());
		Log.e("file", Environment.getExternalStorageState().toString());
		Log.e("file", Environment.getRootDirectory().toString());
		if (Environment.getExternalStorageState().equals(
				Environment.MEDIA_MOUNTED)) {
			createFile();
			File file = new File(Environment.getExternalStorageDirectory()
					.getPath() + folderName, FILENAME);
			try {
				FileOutputStream fos = new FileOutputStream(file);
				fos.write("write test".getBytes());
				fos.close();
				Toast.makeText(FileActivity.this, "д���ļ��ɹ�", Toast.LENGTH_LONG)
						.show();
			} catch (Exception e) {
				Toast.makeText(FileActivity.this, "д���ļ�ʧ��", Toast.LENGTH_SHORT)
						.show();
			}
		} else {
			// ��ʱSDcard�����ڻ��߲��ܽ��ж�д������
			Toast.makeText(FileActivity.this, "��ʱSDcard�����ڻ��߲��ܽ��ж�д����",
					Toast.LENGTH_SHORT).show();
		}

	}

}
