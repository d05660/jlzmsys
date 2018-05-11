package org.cloud.jlzm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.cloud.jlzm.domain.User;

public interface UserMapper {

    List<User> selectAllUsers();

    int selectCount();

	User selectUserByUserId(@Param("userId") String userId);
	
	Integer selectRoleIdByUserId(@Param("userId") String userId);
}
