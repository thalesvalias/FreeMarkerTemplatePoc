package com.freemarkertemplate.poc.model;

public class Product {
	
	private final String url;
	private final String name;
	
	public Product(String url, String name) {
		this.url = url;
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Product [url=");
		builder.append(url);
		builder.append(", name=");
		builder.append(name);
		builder.append("]");
		return builder.toString();
	}
	
}
