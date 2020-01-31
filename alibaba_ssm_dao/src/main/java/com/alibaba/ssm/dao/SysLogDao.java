package com.alibaba.ssm.dao;

import com.alibaba.ssm.domain.SysLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author ZhangPeng
 * @Email ZhangPeng1853093@126.com
 * @date 2020/1/31 - 13:22
 */
public interface SysLogDao {
    @Insert("insert into sysLog(visitTime,username,ip,url,executionTime,method) values(#{visitTime},#{username},#{ip},#{url},#{executionTime},#{method})")
    void save(SysLog sysLog) throws Exception;

    @Select("select * from sysLog")
    List<SysLog> findAll() throws Exception;
}
