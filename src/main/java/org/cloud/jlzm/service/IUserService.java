package org.cloud.jlzm.service;

import java.util.List;

import org.cloud.jlzm.domain.User;
import org.cloud.jlzm.dto.UserDto;

public interface IUserService {

    List<User> getAllUsers(UserDto userDto);

    int getUserCount(UserDto userDto);
    
    User getUserByUserId(String userId);
}
