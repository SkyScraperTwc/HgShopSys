package indi.twc.hg.entity;
/**
 * 简化版！！
 * @author 谭纬城
 *
 */
public class ProductImage {
	/**
	 * 图片id
	 * int的默认值为0,Integer的默认值为null
	 */
	private Integer id;
	/**
	 * 图片名称
	 */
	private String name;
	/**
	 * 图片集合
	 */
	private String url;
	/**
	 * 图片排序
	 */
	private int index;
	/**
	 * 图片所属产品Id,重要
	 */
	private int	productId;
	
	public ProductImage() {
	}

	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
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
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	
}
