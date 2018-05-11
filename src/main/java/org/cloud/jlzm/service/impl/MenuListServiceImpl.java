package org.cloud.jlzm.service.impl;

import java.util.List;

import org.cloud.jlzm.domain.MenuItem;
import org.cloud.jlzm.mapper.MenuItemMapper;
import org.cloud.jlzm.service.IMenuItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MenuListServiceImpl implements IMenuItemService {
	
	private static final Logger logger = LoggerFactory.getLogger(MenuListServiceImpl.class);

	@Autowired
	private MenuItemMapper menuListMapper;

	@Override
	public List<MenuItem> getTreeData(int lv) {
		List<MenuItem> menuLists = menuListMapper.getMenuList(lv);
		logger.info(menuLists.toString());
		return menuLists;
	}
}
