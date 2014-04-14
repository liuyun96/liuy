package com.finance.stock.utils;

import com.finance.stock.db.Stock;

public class StockUtils {

	public static Stock getStock(String code) {
		// http://finance.sina.com.cn/realstock/company/sh600255/nc.shtml
		// sh600255
		String url = "http://hq.sinajs.cn/?_=0.3388963919132948&list=" + code;
		String str = HttpUtil.post(url);
		if (str != null) {
			str = str.substring(str.indexOf("=") + 2);
			str = str.replace("\";", "");
			String[] arr = str.split(",");
			if (str != null) {
				Stock stock = new Stock();
				stock.setCode(code);
				stock.setTitle(arr[0]);
				stock.setStartPrice(Double.valueOf(arr[1]));
				stock.setEndPrice(Double.valueOf(arr[2]));
				stock.setPrice(Double.valueOf(arr[3]));
				stock.setMaxPrice(Double.valueOf(arr[4]));
				stock.setMinPrice(Double.valueOf(arr[5]));
				return stock;
			}
		}
		return null;
	}
}
