package com.alibaba.ssm.service.impl;

import com.alibaba.ssm.dao.SysLogDao;
import com.alibaba.ssm.domain.SysLog;
import com.alibaba.ssm.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author ZhangPeng
 * @Email ZhangPeng1853093@126.com
 * @date 2020/1/31 - 13:31
 */
@Service
@Transactional
public class SysLogServiceImpl implements SysLogService {
    @Autowired
    private SysLogDao sysLogDao;

    @Override
    public void save(SysLog sysLog) throws Exception {
        sysLogDao.save(sysLog);
    }

    @Override
    public List<SysLog> findAll() throws Exception {
        return sysLogDao.findAll();
    }
}
