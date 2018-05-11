package org.cloud.jlzm.service.impl;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.cloud.jlzm.domain.Role;
import org.cloud.jlzm.mapper.RoleMapper;
import org.cloud.jlzm.mapper.UserMapper;
import org.cloud.jlzm.service.IRoleService;
import org.cloud.jlzm.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements IRoleService {
	
	@Autowired
	private UserMapper userMapper;
	@Autowired
    private RoleMapper roleMapper;
	
	@Override
    public List<Long> getPermissionIdListByRoleId(String userId) {
	    // TODO Auto-generated method stub
	    return null;
    }
    
	@Override
    public Map<String, Set<String>> getPermissionMapByUserId(String userId) {
		Map<String, Set<String>> resourceMap = new HashMap<>();
		int roleId = userMapper.selectRoleIdByUserId(userId);

        Set<String> urlSet = new HashSet<>();
        Set<String> roles = new HashSet<>();
        List<Map<Integer, String>> resourceList = roleMapper.selectPermissionListByRoleId(roleId);
        System.out.println(resourceList.size());
        if (resourceList != null && resourceList.size()!=0) {
            System.out.println(resourceList);
            for (Map<Integer, String> map : resourceList) {
                if (map!=null && StringUtils.isNotBlank(map.get("url"))) {
                    urlSet.add(map.get("url"));
                }
            }
        }
        Role role = roleMapper.selectById(roleId);
        if (role != null) {
            roles.add(role.getName());
        }
        resourceMap.put("urls", urlSet);
        resourceMap.put("roles", roles);
        return resourceMap;
    }
}
