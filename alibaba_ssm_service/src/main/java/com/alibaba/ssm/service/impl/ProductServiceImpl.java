package com.alibaba.ssm.service.impl;

import com.alibaba.ssm.dao.ProductDao;
import com.alibaba.ssm.domain.Product;
import com.alibaba.ssm.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author ZhangPeng
 * @Email ZhangPeng1853093@126.com
 * @date 2020/1/28 - 16:23
 */
@Service
@Transactional
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductDao productDao;
    @Override
    public List<Product> findAll() throws Exception {
        return productDao.findAll();
    }

    @Override
    public void save(Product product) throws Exception {
        productDao.save(product);
    }
}
