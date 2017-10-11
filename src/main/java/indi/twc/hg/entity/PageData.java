package indi.twc.hg.entity;

import java.util.List;

import indi.twc.hg.entity.Category;

public class PageData {
	/**
	 * 默认当前页为第一页
	 */
	public static int PAGE = 1;
	/**
	 * 默认每一页为10条记录 
	 */
	public static int ROWS = 30;  
	
	/** 
	 * 总记录数
	 */
	private int totalRecordes;
	/** 
	 * 当前第几页
	 */
	private int page;
	/**
	 * 总页数
	 */ 
	private int totalpages;
	/**
	 * 每一页记录数
	 */ 
	private int rows; 
	/**
	 * 要展示的列表数据
	 */  
	private List<Category> dataList;
	
	/** 
	 * 构造方法
	 * @param totalRecordes
	 * @param page
	 * @param rows
	 * @param dataList
	 */
	public PageData(int totalRecordes, int page, int rows, List dataList) {
		super();
		this.totalRecordes = totalRecordes;
		this.page = page;
		this.rows = rows;
		this.dataList = dataList;
		this.totalpages = totalRecordes/rows;
		if(totalRecordes % rows != 0){
			this.totalpages = this.totalpages + 1;
		}
	}
	public int getTotalRecordes() {
		return totalRecordes;
	}
	public void setTotalRecordes(int totalRecordes) {
		this.totalRecordes = totalRecordes;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	} 
	public int getTotalpages() {
		return totalpages;
	}
	public void setTotalpages(int totalpages) {
		this.totalpages = totalpages;
	}
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	public List<Category> getDataList() {
		return dataList;
	}
	public void setDataList(List dataList) {
		this.dataList = dataList;
	}
	/**
	 * 第一页
	 * @return
	 */
	public int getFirst(){
		
		return 1; 
	}
	/**
	 * 上一页
	 * @return 
	 */
	public int getPre(){  
		if(page-1 > 0){
			return page - 1;
		}else{
			return 1;  
		}
	} 
	/**
	 * 下一页
	 * @return
	 */
	public int getNext(){
		if(page+1<=totalpages){
			return page + 1;
		}else{
			return totalpages;
		}
	}
	/**
	 * 最后一页
	 * @return
	 */
	public int getLast(){
		
		return totalpages;
	}
}
