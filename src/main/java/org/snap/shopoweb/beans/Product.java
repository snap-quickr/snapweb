package org.snap.shopoweb.beans;


public class Product {
	
    private int productId;
    private String productName;
    private String productDetail;
    private int price;
    private int categoryId;
    private int locationId;
    private int userId;
	
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
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
	public String getProductDetail() {
		return productDetail;
	}
	public void setProductDetail(String productDetail) {
		this.productDetail = productDetail;
	}
    public int getUserId() {
        return userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }
}

