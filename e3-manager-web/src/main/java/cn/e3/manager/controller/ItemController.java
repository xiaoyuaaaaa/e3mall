package cn.e3.manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.e3.manager.service.ItemService;
import cn.e3.pojo.TbItem;
import cn.e3.pojo.TbItemDesc;
import cn.e3.utils.DatagridPagebean;
import cn.e3.utils.E3mallResult;

@Controller
public class ItemController {
	
	@Autowired
	private ItemService itemService;
	
	@RequestMapping("item/list/{id}")
	@ResponseBody
	public TbItem findById(@PathVariable Long id){
		TbItem item = itemService.findById(id);
		return item;
	}
	
	@RequestMapping("item/list")
	@ResponseBody
	public DatagridPagebean findItemListByPage(@RequestParam(defaultValue="1")Integer page, @RequestParam(defaultValue="30")Integer rows) {
		DatagridPagebean pagebean = itemService.findItemListByPage(page, rows);
		return pagebean;
	}
	
	@RequestMapping("item/save")
	@ResponseBody
	public E3mallResult saveItem(TbItem item,TbItemDesc itemDesc){
		E3mallResult result = itemService.saveItem(item, itemDesc);
		return result;
	}

}
