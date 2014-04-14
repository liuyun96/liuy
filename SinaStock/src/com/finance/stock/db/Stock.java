package com.finance.stock.db;

public class Stock {
	// http://stock.finance.sina.com.cn/portfolio/api/json.php/HoldService.getSymbolListByPid?pid=&rn=1397029283285&type=cn
	//http://hq.sinajs.cn/?_=0.3388963919132948&list=sh600255
	/**
	 *股票 代号
	 */
	private String code;
	/**
	 * 股票名称
	 */
	private String title;
	/**
	 * 现价
	 */
	protected Double price = 0.0D;
	/**
	 * 振幅
	 */
	protected double diff = 0.0D;
	/**
	 * 最价
	 */
	private double maxPrice;
	/**
	 * 最低
	 */
	private double minPrice;
	/**
	 * 今开价
	 */
	private double startPrice;
	/**
	 * 昨收价
	 */
	private double endPrice;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public double getDiff() {
		return diff;
	}

	public void setDiff(double diff) {
		this.diff = diff;
	}

	public double getMaxPrice() {
		return maxPrice;
	}

	public void setMaxPrice(double maxPrice) {
		this.maxPrice = maxPrice;
	}

	public double getMinPrice() {
		return minPrice;
	}

	public void setMinPrice(double minPrice) {
		this.minPrice = minPrice;
	}

	public double getStartPrice() {
		return startPrice;
	}

	public void setStartPrice(double startPrice) {
		this.startPrice = startPrice;
	}

	public double getEndPrice() {
		return endPrice;
	}

	public void setEndPrice(double endPrice) {
		this.endPrice = endPrice;
	}

}
