package com.freemarkertemplate.poc.model;

public class TempPojo {
	
	private final String user;
	private final Product latestProduct;
	
	public TempPojo(String user, Product latestProduct) {
		this.user = user;
		this.latestProduct = latestProduct;
	}

	public String getUser() {
		return user;
	}

	public Product getLatestProduct() {
		return latestProduct;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TempPojo [user=");
		builder.append(user);
		builder.append(", latestProduct=");
		builder.append(latestProduct);
		builder.append("]");
		return builder.toString();
	}
	
}
