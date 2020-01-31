package com.alibaba.ssm.service;

import com.alibaba.ssm.domain.Permission;
import com.alibaba.ssm.domain.Role;

import java.util.List;

/**
 * @author ZhangPeng
 * @Email ZhangPeng1853093@126.com
 * @date 2020/1/30 - 14:29
 */
public interface RoleService {
    List<Role> findAll() throws Exception;

    void save(Role role) throws Exception;

    Role findById(String roleId) throws Exception;

    List<Permission> findOtherPermissions(String roleId) throws Exception;

    void addPermissionToRole(String roleId,String[] permissionIds) throws Exception;

    void deleteRoleById(String roleId) throws Exception;
}
