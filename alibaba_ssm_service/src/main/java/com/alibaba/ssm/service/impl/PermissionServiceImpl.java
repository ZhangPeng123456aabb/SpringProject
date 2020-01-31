package com.alibaba.ssm.service.impl;

import com.alibaba.ssm.dao.PermissionDao;
import com.alibaba.ssm.domain.Permission;
import com.alibaba.ssm.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author ZhangPeng
 * @Email ZhangPeng1853093@126.com
 * @date 2020/1/30 - 15:09
 */
@Service
@Transactional
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    private PermissionDao permissionDao;
    @Override
    public List<Permission> findAll() throws Exception {
        return permissionDao.findAll();
    }

    @Override
    public void save(Permission permission) throws Exception {
        permissionDao.save(permission);
    }
}
