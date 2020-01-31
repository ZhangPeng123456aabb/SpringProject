package com.alibaba.ssm.service;

import com.alibaba.ssm.domain.Role;
import com.alibaba.ssm.domain.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

/**
 * @author ZhangPeng
 * @Email ZhangPeng1853093@126.com
 * @date 2020/1/29 - 15:28
 */
public interface UserService extends UserDetailsService {
    List<UserInfo> findAll()throws Exception;

    void save(UserInfo userInfo) throws Exception;

    UserInfo findById(String id) throws Exception;

    List<Role> findOtherRoles(String userId) throws Exception;

    void addRoleToUser(String userId,String[] roleIds);
}
