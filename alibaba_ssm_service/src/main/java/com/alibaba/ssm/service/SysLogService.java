package com.alibaba.ssm.service;

import com.alibaba.ssm.domain.SysLog;

import java.util.List;

/**
 * @author ZhangPeng
 * @Email ZhangPeng1853093@126.com
 * @date 2020/1/31 - 13:30
 */
public interface SysLogService {
    void save(SysLog sysLog) throws Exception;

    List<SysLog> findAll() throws Exception;
}
