package org.cloud.jlzm.service.impl;

import java.util.List;

import com.github.pagehelper.PageHelper;
import org.cloud.jlzm.domain.User;
import org.cloud.jlzm.dto.UserDto;
import org.cloud.jlzm.mapper.UserMapper;
import org.cloud.jlzm.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> getAllUsers(UserDto userDto) {
        int pageNumber = userDto.getPage();
        int pageSize = userDto.getRows();
        PageHelper.startPage(pageNumber, pageSize);
        return userMapper.selectAllUsers();
    }

    @Override
    public int getUserCount(UserDto userDto) {
        return userMapper.selectCount();
    }

    @Override
	public User getUserByUserId(String userId) {
		return userMapper.selectUserByUserId(userId);
	}
}
