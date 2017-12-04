package cn.e3.manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.e3.manager.service.ItemService;
import cn.e3.pojo.TbItem;

@Controller
public class ItemController {
	
	@Autowired
	private ItemService itemService;
	
	@RequestMapping("item/list/{id}")
	@ResponseBody
	public TbItem findById(@PathVariable Long id){
		System.out.println("qqqqqqqqqqqqqqqqqqqqqqqqqqqqqq");
		TbItem item = itemService.findById(id);
		return item;
	}

}
