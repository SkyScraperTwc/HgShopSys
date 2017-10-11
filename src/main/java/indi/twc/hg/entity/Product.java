package indi.twc.hg.entity;

import java.util.Date;
import java.util.List;

public class Product {
	
	/**1
	 * id
	 */
	private Integer id;
	/**2
	 * 产品名称 
	 */
	private String name;
	/**3
	 * 产品编号
	 */
	private String number;
	/**4
	 * 市场价
	 */
	private Double marketPrice;
	/**5
	 * 折扣价
	 */
	private Double discountedPrice ;
	/**6
	 * 录入日期
	 */
	private Date addDate;
	/**7
	 * 产品介绍 
	 */
	private String desc;
	/**8
	 * 产品颜色
	 */
	private String color;
	/**9
	 * 产品购买说明
	 */
	private String remark;
	/**10
	 * 产品所属品牌
	 */ 
	private Brand brand;
	/**11
	 * 产品所属类别
	 */
	private Category category;
	/**12
	 * 产品颜色 
	 */ 
	private List<ProductImage> productImagesList;
	/**13
	 * 产品主图片
	 */
	private String mainImage;
	/**14
	 * 是否推荐
	 */
	private boolean recommend; 
	/**15
	 * 是否促销
	 */
	private boolean promotion;
	/**
	 * 关注次数
	 */
	private int attention;
	/**
	 * 购买次数
	 */
	private long buyCount;
	/**
	 * 当前产品的分类和上面的所有父分类组成的id序列
	 * 形如|5|,|2|,|1|
	 * 表示当前产品的直接分类为5,5的父分类为2，2的父分类为1
	 */
	private String cls;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
   

	public Double getMarketPrice() {
		return marketPrice;
	}

	public void setMarketPrice(Double marketPrice) {
		this.marketPrice = marketPrice;
	}

	public Double getDiscountedPrice() {
		return discountedPrice;
	}

	public void setDiscountedPrice(Double discountedPrice) {
		this.discountedPrice = discountedPrice;
	}

	public Date getAddDate() {
		return addDate;
	}

	public void setAddDate(Date addDate) {
		this.addDate = addDate;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getColor() {
		return color; 
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public List<ProductImage> getProductImagesList() {
		return productImagesList;
	}

	public void setProductImagesList(List<ProductImage> productImagesList) {
		this.productImagesList = productImagesList;
	}

	public boolean isRecommend() {
		return recommend;
	}

	public void setRecommend(boolean recommend) {
		this.recommend = recommend;
	}

	public boolean isPromotion() {
		return promotion;
	}

	public void setPromotion(boolean promotion) {
		this.promotion = promotion;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getMainImage() {
		return mainImage;
	}

	public void setMainImage(String mainImage) {
		this.mainImage = mainImage;
	}

	public int getAttention() {
		return attention;
	}

	public void setAttention(int attention) {
		this.attention = attention;
	}

	public long getBuyCount() {
		return buyCount;
	}

	public void setBuyCount(long buyCount) {
		this.buyCount = buyCount;
	}

	public String getCls() {
		return cls;
	}

	public void setCls(String cls) {
		this.cls = cls;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", number=" + number + ", marketPrice=" + marketPrice
				+ ", discountedPrice=" + discountedPrice + ", addDate=" + addDate + ", desc=" + desc + ", color="
				+ color + ", remark=" + remark + ", brand=" + brand + ", category=" + category + ", productImages="
				+ productImagesList + ", mainImage=" + mainImage + ", recommend=" + recommend + ", promotion=" + promotion
				+ ", attention=" + attention + ", buyCount=" + buyCount + ", cls=" + cls + "]";
	}
	
}
  