package com.alibaba.ssm.service;

import com.alibaba.ssm.domain.Product;

import java.util.List;

/**
 * @author ZhangPeng
 * @Email ZhangPeng1853093@126.com
 * @date 2020/1/28 - 16:21
 */
public interface ProductService {
    public List<Product> findAll() throws Exception;
    void save(Product product) throws Exception;
}
