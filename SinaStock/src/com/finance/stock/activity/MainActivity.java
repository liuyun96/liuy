package com.finance.stock.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.finance.stock.R;
import com.finance.stock.db.Stock;
import com.finance.stock.utils.StockUtils;

public class MainActivity extends Activity {

	private TableLayout table;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Intent intent = new Intent();
		intent.setClass(this, MoreDateListActivity.class);
		startActivity(intent);
		finish();
		// setContentView(R.layout.table);
		// table = (TableLayout) findViewById(R.id.dictTable);
		// initStocks();
	}

	private void initStocks() {
		Stock stock = StockUtils.getStock("sh600255");
		// List<Stock> list = new ArrayList<Stock>();
		for (int i = 0; i < 10; i++) {
			// list.add(stock);
			TableRow row = new TableRow(this);
			row.setId(i);

			TextView title = new TextView(this);
			title.setText(stock.getTitle());
			title.setGravity(Gravity.CENTER);

			TextView price = new TextView(this);
			price.setText(stock.getPrice() + "");
			price.setGravity(Gravity.CENTER);

			TextView maxPrice = new TextView(this);
			maxPrice.setText(stock.getMaxPrice() + "");
			maxPrice.setGravity(Gravity.CENTER);

			row.addView(title);
			row.addView(price);
			row.addView(maxPrice);

			row.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					System.out.println(v.getId());
				}
			});

			table.addView(row, new TableLayout.LayoutParams());
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
