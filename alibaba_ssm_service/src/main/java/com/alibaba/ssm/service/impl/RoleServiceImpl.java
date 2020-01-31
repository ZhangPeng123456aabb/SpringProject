package com.alibaba.ssm.service.impl;

import com.alibaba.ssm.dao.RoleDao;
import com.alibaba.ssm.domain.Permission;
import com.alibaba.ssm.domain.Role;
import com.alibaba.ssm.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author ZhangPeng
 * @Email ZhangPeng1853093@126.com
 * @date 2020/1/30 - 14:31
 */
@Service
@Transactional
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleDao roleDao;
    @Override
    public List<Role> findAll() throws Exception {
        return roleDao.findAll();
    }

    @Override
    public void save(Role role) throws Exception {
        roleDao.save(role);
    }

    @Override
    public Role findById(String roleId) throws Exception {
        return roleDao.findById(roleId);
    }

    @Override
    public List<Permission> findOtherPermissions(String roleId) throws Exception {
        return roleDao.findOtherPermissions(roleId);
    }

    @Override
    public void addPermissionToRole(String roleId, String[] permissionIds) throws Exception {
        for(String permissionId:permissionIds){
            roleDao.addPermissionToRole(roleId,permissionId);
        }
    }

    @Override
    public void deleteRoleById(String roleId) throws Exception {
        //从user_role表中删除
        roleDao.deleteFromUser_RoleByRoleId(roleId);
        //从role_permission表中删除
        roleDao.deleteFromRole_PermissionByRoleId(roleId);
        //从role表中删除
        roleDao.deleteRoleById(roleId);
    }
}
