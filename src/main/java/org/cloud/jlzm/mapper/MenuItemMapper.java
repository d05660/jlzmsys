package org.cloud.jlzm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.cloud.jlzm.domain.MenuItem;

public interface MenuItemMapper {
	List<MenuItem> getMenuList(@Param("lv") int lv);
}
