package com.alibaba.ssm.service;

import com.alibaba.ssm.domain.Permission;

import java.util.List;

/**
 * @author ZhangPeng
 * @Email ZhangPeng1853093@126.com
 * @date 2020/1/30 - 15:07
 */
public interface PermissionService {
    List<Permission> findAll() throws Exception;
    void save(Permission permission) throws Exception;
}
