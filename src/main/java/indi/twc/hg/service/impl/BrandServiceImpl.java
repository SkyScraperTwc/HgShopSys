package indi.twc.hg.service.impl;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import indi.twc.hg.dao.impl.BrandDaoImpl;
import indi.twc.hg.dao.impl.BrandDaoImpl.Brand_Sql;
import indi.twc.hg.entity.Brand;
import indi.twc.hg.entity.PageData;
import indi.twc.hg.service.IBrandService;
import indi.twc.hg.utils.mapper.BrandRowMapper;

public class BrandServiceImpl extends BaseServiceImpl implements IBrandService {
	private BrandDaoImpl brandDao = new BrandDaoImpl();
	
	@Override
	public void add(Brand brand) throws Exception {
		try{
				brandDao.save(brand);
		}catch(Exception e){
				e.printStackTrace();  
		}
	}  
        
	@Override
	public void delete(Integer[] ids) throws Exception {
		try {
			for (int i = 0; i < ids.length; i++) {
				Brand brand = findById(ids[i]);
				//先删除图片！
				deletePhoto(brand.getSmallPhoto());
				deletePhoto(brand.getBigPhoto());
			}
			
			//再删除数据库信息！
			brandDao.delete(ids);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void edit(Brand newBrand) throws Exception {
		try{
			Brand oldBrand = findById(newBrand.getId());
			String spPath = oldBrand.getSmallPhoto();
			//图片路径不相同，要删除旧的路径
			if(!spPath.equals(newBrand.getSmallPhoto())){
				//删除旧的图片！
				deletePhoto(spPath);
			}
			
			String bpPath = oldBrand.getBigPhoto();
			if(!bpPath.equals(newBrand.getBigPhoto())){
				deletePhoto(bpPath);
			}
			
			//再修改数据库信息！
			brandDao.update(newBrand);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	 
	@Override
	public Brand findById(Integer id) throws Exception{
		try {
			StringBuffer whereSql = new StringBuffer(" and B_ID=?");
			List<Integer> paramsList = new ArrayList<Integer>(); 
			paramsList.add(id);
			List<Brand> brandList = brandDao.queryList(whereSql, paramsList.toArray(), 
						-1, -1, null, Brand_Sql.brandQueryList, new BrandRowMapper());
			if(null!=brandList && brandList.size()>0){
				return brandList.get(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
    /**
     * 分页查询  
     */
	@Override
	public PageData listPage(Map<String, Object> conditions, int page, int rows,
			LinkedHashMap<String, String> orderBy) throws Exception {
		
		StringBuffer whereSql = new StringBuffer();
		List<Object> paramsList = new ArrayList<Object>();
		  
		if(null!=conditions && conditions.size()>0){
			Object enName = conditions.get("B_ENNAME");
			//判断enName是否为空 ,不为空才添加到whereSql
			if(null!=enName && !"".equals(enName)){
				whereSql.append(" and B_ENNAME like ?");
				paramsList.add("%"+enName+"%"); //添加enName到paramsList
			}
			
			Object cnName = conditions.get("B_CNNAME"); 
			//判断cnName是否为空,不为空才添加到whereSql
			if(null!=cnName && !"".equals(cnName)){  
				whereSql.append(" and B_CNNAME like ?");
				paramsList.add("%"+cnName+"%"); //添加cnName到paramsList
			} 
		}
		try { 
			//查出dataList
			List<Brand> dataList = brandDao.queryList(whereSql,paramsList.toArray(),
							page,rows,orderBy,Brand_Sql.brandQueryList, new BrandRowMapper());
			
			//查出totalRecordes总记录数
			int totalRecordes = brandDao.getTotalRecords(whereSql,paramsList,Brand_Sql.queryCount);
			
			//创建pageData对象(totalRecordes,1,10,dataList)
			PageData pageData = new PageData(totalRecordes, page, rows, dataList);
			  
			return pageData;
			
		} catch (Exception e) {  
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Brand> listAllBrand() throws Exception {
		try {
			List<Brand> brandlist = brandDao.queryList(null, null, -1, -1,
							null, Brand_Sql.brandQueryList, new BrandRowMapper());
			if(null!=brandlist && brandlist.size()>0){
				return brandlist;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
