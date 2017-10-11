package indi.twc.hg.entity;

import java.util.Arrays;
import java.util.HashSet;

public class Category {
	/**
	 * 分类id
	 */
	private Integer id;
	/**
	 * 分类名称
	 */
	private String name;
	/**
	 * 描述
	 */ 
	private String desc;
	/**
	 * 父分类 
	 */
	private Category parentCategory; 
	/**
	 * cls
	 * 当前分类上面的所有父分类组成的id序列
	 * 形如|5|,|2|,|1|
	 * 表示当前分类的直接父分类为5,5的父分类为2，2的父分类为1
	 */
	private String cls;
	/**
	 * 分类级别
	 */
	private Integer level;
	
	private HashSet<Category> childsSet;
	
	public Category() {
		super();
	}
	public Category(Integer id) {
		super();
		this.id = id;
	}
	public Category(Integer categoryId, String categoryName) {
		this.id = categoryId;
		this.name = categoryName;  
	}
	public Integer getLevel() {
		return level;
	}
	public void setLevel(Integer level) {
		this.level = level;
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
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public Category getParentCategory() {
		return parentCategory;
	}
	public void setParentCategory(Category parentCategory) {
		this.parentCategory = parentCategory;
	}
	public String getCls() {
		return cls;
	}
	public void setCls(String cls) {
		this.cls = cls; 
	}
	public HashSet<Category> getChilds() {
		return childsSet;
	}
	public void setChilds(HashSet<Category> childsSet)  {
		this.childsSet = childsSet;  
	}
	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", desc=" + desc 
				+ ", cls=" + cls + ", level=" + level + ", childsSet=" 
				+ Arrays.toString(childsSet.toArray()) + "]";
	}

}
