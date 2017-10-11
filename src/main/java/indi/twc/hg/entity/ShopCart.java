package indi.twc.hg.entity;

import java.util.LinkedHashMap;

import indi.twc.hg.entity.Product;
import indi.twc.hg.entity.CartItem;
/**
 * 购物车类
 * @author TanWC
 * 
 */
public class ShopCart {
	
	//<Integer, CartItem>,选用LinkedHashMap作为购物车！！！！
	private LinkedHashMap<Integer, CartItem> itemsMap = new LinkedHashMap<Integer, CartItem>(); 
	/** 
	 * 添加到购物车
	 */
	public void add(Product p, int count){
		CartItem ct = itemsMap.get(p.getId());
		//先判断购物车中有无此产品
		if(null == ct){
			//没有就添加进去
			ct = new CartItem(p, count);
			itemsMap.put(p.getId(), ct);
		}else{     
			//更新产品数量
			this.update(p.getId(),ct.getCount()+count);
		} 
	} 
	/**    
	 * 从购物车中删除
	 */ 
	public void remove(Integer id){
		itemsMap.remove(id); 
	} 
	/** 
	 * 清空购物车    
	 */
	public void clear(){ 
		itemsMap.clear();
	}
	/**
	 * 更新购物车
	 * @param count 
	 * @param id 
	 */
	public void update(Integer p_id, int newCount){ 
		CartItem ct = itemsMap.get(p_id); 
		if(null!=ct){ 
			ct.setCount(newCount);   
		} 
		 
	} 
	/**
	 * 计算购物车总价钱 
	 */ 
	public double getTotal(){  
		double total = 0;
		for(CartItem ct : itemsMap.values()){
			total = total + ct.getSubTotal(); 
		}
		return total; 
	}
	/**  
	 * 获得购物车 
	 * @return
	 */
	public LinkedHashMap<Integer, CartItem> getItems() {
		return itemsMap; 
	}
	
}
