package com.alibaba.ssm.service;

import com.alibaba.ssm.domain.Orders;

import java.util.List;

/**
 * @author ZhangPeng
 * @Email ZhangPeng1853093@126.com
 * @date 2020/1/28 - 23:02
 */
public interface OrdersService {
    List<Orders> findAll(int page, int size) throws Exception;
    Orders findById(String ordersId) throws Exception;
}
