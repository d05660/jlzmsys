package org.cloud.jlzm.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.cloud.jlzm.domain.Permission;
import org.cloud.jlzm.domain.Role;

public interface RoleMapper {
	
	List<Integer> selectPermissionIdListByRoleId(@Param("id") int id);

    List<Permission> selectPermissionListByRoleIdList(@Param("list") List<Integer> list);

    List<Map<Integer, String>> selectPermissionListByRoleId(@Param("id") int roleId);

	Role selectById(@Param("id") int id);

}
