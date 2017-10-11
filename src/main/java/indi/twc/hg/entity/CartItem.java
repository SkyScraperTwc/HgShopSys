package indi.twc.hg.entity;

import indi.twc.hg.entity.Product;

public class CartItem {
	/**
	 * 产品 
	 */
	private Product product;
	/**
	 * 产品数量
	 */
	private int count;
	
	public CartItem(Product product, int count) {
		this.product = product;
		this.count = count;
	}
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product; 
	}

	public int getCount() { 
		return count;
	}

	public void setCount(int count) { 
		this.count = count;
	}
	/**
	 * 计算每一项的价格（price*count）
	 * @return
	 */
	public double getSubTotal(){
		return product.getDiscountedPrice()*count;
	}
	
}
