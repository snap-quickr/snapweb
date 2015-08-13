package org.snap.shopoweb.beans;

public class Product {
	
	int productId;
	int categoryId;
	int locationId;
	String url;
	String productDetail;
	
	public int getProductId() {
		return productId;
	}
	
	
	public void setProductId(int productId) {
		this.productId = productId;
	}
	
	public int getCategoryId() {
		return categoryId;
	}
	
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public int getLocationId() {
		return locationId;
	}
	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getProductDetail() {
		return productDetail;
	}
	public void setProductDetail(String productDetail) {
		this.productDetail = productDetail;
	}
	
	

}
