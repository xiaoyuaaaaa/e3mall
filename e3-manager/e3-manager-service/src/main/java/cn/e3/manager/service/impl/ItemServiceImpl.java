package cn.e3.manager.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.e3.manager.service.ItemService;
import cn.e3.mapper.TbItemDescMapper;
import cn.e3.mapper.TbItemMapper;
import cn.e3.pojo.TbItem;
import cn.e3.pojo.TbItemDesc;
import cn.e3.pojo.TbItemExample;
import cn.e3.utils.DatagridPagebean;
import cn.e3.utils.E3mallResult;
import cn.e3.utils.IDUtils;

@Service
public class ItemServiceImpl implements ItemService {
	
	@Autowired
	private TbItemMapper itemMapper;
	@Autowired
	private TbItemDescMapper itemDescMapper;

	public TbItem findById(Long id) {
		TbItem item = itemMapper.selectByPrimaryKey(id);
		return item;
	}

	@Override
	public DatagridPagebean findItemListByPage(Integer page, Integer rows) {
		TbItemExample example = new TbItemExample();
		PageHelper.startPage(page, rows);
		
		List<TbItem> list = itemMapper.selectByExample(example);
		PageInfo<TbItem> pageInfo = new PageInfo<TbItem>(list);
		DatagridPagebean pagebean = new DatagridPagebean();
		pagebean.setTotal(pageInfo.getTotal());
		pagebean.setRows(list);
		
		return pagebean;
	}

	@Override
	public E3mallResult saveItem(TbItem item, TbItemDesc itemDesc) {
		long itemId = IDUtils.genItemId();
		item.setId(itemId);
		item.setStatus((byte)1);
		Date date = new Date();
		item.setCreated(date);
		item.setUpdated(date);
		itemMapper.insert(item);
		
		itemDesc.setItemId(itemId);
		itemDesc.setCreated(date);
		itemDesc.setUpdated(date);
		itemDescMapper.insert(itemDesc);
		
		return E3mallResult.ok();
	}

}
