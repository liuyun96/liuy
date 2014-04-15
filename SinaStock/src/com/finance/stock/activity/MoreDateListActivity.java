package com.finance.stock.activity;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.finance.stock.R;

public class MoreDateListActivity extends Activity implements OnScrollListener {

	// ListView��Adapter
	private SimpleAdapter mSimpleAdapter;
	private ListView lv;
	private Button bt;
	private ProgressBar pg;
	private ArrayList<HashMap<String, String>> list;
	// ListView�ײ�View
	private View moreView;
	private Handler handler;
	// ����һ�������������������������ټ���
	private int MaxDateNum;
	// ���ɼ���Ŀ������
	private int lastVisibleIndex;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		MaxDateNum = 22; // ���������������
		lv = (ListView) findViewById(R.id.lv);
		// ʵ�����ײ�����
		moreView = getLayoutInflater().inflate(R.layout.moredata, null);

		bt = (Button) moreView.findViewById(R.id.bt_load);
		pg = (ProgressBar) moreView.findViewById(R.id.pg);
		handler = new Handler();

		// ��map��װ�����ݣ���ʼ��10������
		list = new ArrayList<HashMap<String, String>>();
		for (int i = 0; i < 10; i++) {
			HashMap<String, String> map = new HashMap<String, String>();
			map.put("ItemTitle", "��" + i + "�б���");
			map.put("ItemText", "��" + i + "������");
			list.add(map);
		}
		// ʵ����SimpleAdapter
		mSimpleAdapter = new SimpleAdapter(this, list, R.layout.item,
				new String[] { "ItemTitle", "ItemText" }, new int[] {
						R.id.tv_title, R.id.tv_content });

		// ���ϵײ�View��ע��Ҫ����setAdapter����ǰ
		lv.addFooterView(moreView);
		lv.setAdapter(mSimpleAdapter);
		// �󶨼�����
		lv.setOnScrollListener(this);
		bt.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				pg.setVisibility(View.VISIBLE);// ���������ɼ�
				bt.setVisibility(View.GONE);// ��ť���ɼ�
				handler.postDelayed(new Runnable() {
					@Override
					public void run() {
						loadMoreDate();// ���ظ�������
						bt.setVisibility(View.VISIBLE);
						pg.setVisibility(View.GONE);
						mSimpleAdapter.notifyDataSetChanged();// ֪ͨlistViewˢ������
					}

				}, 2000);
			}
		});

	}

	public void loadItem(View view) {
		Intent localIntent = new Intent();
		localIntent.setClass(this, ItemActivity.class);
		startActivity(localIntent);
	}

	private void loadMoreDate() {
		int count = mSimpleAdapter.getCount();
		if (count + 5 < MaxDateNum) {
			// ÿ�μ���5��
			for (int i = count; i < count + 5; i++) {
				HashMap<String, String> map = new HashMap<String, String>();
				map.put("ItemTitle", "������" + i + "�б���");
				map.put("ItemText", "������" + i + "������");
				list.add(map);
			}
		} else {
			// �����Ѿ�����5��
			for (int i = count; i < MaxDateNum; i++) {
				HashMap<String, String> map = new HashMap<String, String>();
				map.put("ItemTitle", "������" + i + "�б���");
				map.put("ItemText", "������" + i + "������");
				list.add(map);
			}
		}

	}

	@Override
	public void onScroll(AbsListView view, int firstVisibleItem,
			int visibleItemCount, int totalItemCount) {
		// �������ɼ���Ŀ������
		lastVisibleIndex = firstVisibleItem + visibleItemCount - 1;

		// ���е���Ŀ�Ѿ������������ȣ����Ƴ��ײ���View
		if (totalItemCount == MaxDateNum + 1) {
			lv.removeFooterView(moreView);
			Toast.makeText(this, "����ȫ��������ɣ�û�и������ݣ�", Toast.LENGTH_LONG).show();
		}

	}

	@Override
	public void onScrollStateChanged(AbsListView view, int scrollState) {
		// �����ײ����Զ����أ��ж�listview�Ѿ�ֹͣ�������������ӵ���Ŀ����adapter����Ŀ
		if (scrollState == OnScrollListener.SCROLL_STATE_IDLE
				&& lastVisibleIndex == mSimpleAdapter.getCount()) {
			System.out.println("�Ѿ����ײ��ˣ��Զ������µ�����");
			// �������ײ�ʱ�Զ�����
			pg.setVisibility(View.VISIBLE);
			bt.setVisibility(View.GONE);
			handler.postDelayed(new Runnable() {
				@Override
				public void run() {
					loadMoreDate();
					bt.setVisibility(View.VISIBLE);
					pg.setVisibility(View.GONE);
					mSimpleAdapter.notifyDataSetChanged();
				}

			}, 2000);
		}

	}

}