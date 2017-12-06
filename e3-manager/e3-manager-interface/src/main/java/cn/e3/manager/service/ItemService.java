package cn.e3.manager.service;

import cn.e3.pojo.TbItem;
import cn.e3.utils.DatagridPagebean;

public interface ItemService {
	
	public TbItem findById(Long id);
	
	//分页查询
	public DatagridPagebean findItemListByPage(Integer page,Integer rows);

}
