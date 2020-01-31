package com.alibaba.ssm.dao;

import com.alibaba.ssm.domain.Permission;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author ZhangPeng
 * @Email ZhangPeng1853093@126.com
 * @date 2020/1/29 - 23:44
 */
public interface PermissionDao {
    @Select("select * from permission where id in (select permissionId from role_permission where roleId=#{id} )")
    List<Permission> findPermissionByRoleId(String id) throws Exception;

    @Select("select * from permission")
    List<Permission> findAll() throws Exception;

    @Insert("insert into permission(permissionName,url) values(#{permissionName},#{url})")
    void save(Permission permission) throws Exception;
}
