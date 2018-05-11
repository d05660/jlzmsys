package org.cloud.jlzm.service;

import java.util.List;

import org.cloud.jlzm.domain.MenuItem;

public interface IMenuItemService {

	List<MenuItem> getTreeData(int lv);

}
