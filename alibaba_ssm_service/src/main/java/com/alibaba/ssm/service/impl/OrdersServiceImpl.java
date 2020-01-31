package com.alibaba.ssm.service.impl;

import com.alibaba.ssm.dao.OrderDao;
import com.alibaba.ssm.domain.Orders;
import com.alibaba.ssm.service.OrdersService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author ZhangPeng
 * @Email ZhangPeng1853093@126.com
 * @date 2020/1/28 - 23:04
 */
@Service
@Transactional
public class OrdersServiceImpl implements OrdersService {
    @Autowired
    private OrderDao orderDao;
    @Override
    public List<Orders> findAll(int page, int size) throws Exception {
        //参数pageNum是页码值 参数pageSize代表是每页显示条数
        PageHelper.startPage(page,size);
        return orderDao.findAll();
    }

    @Override
    public Orders findById(String ordersId) throws Exception{
            return orderDao.findById(ordersId);
    }
}
