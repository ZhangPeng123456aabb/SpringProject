package com.alibaba.ssm.dao;

import com.alibaba.ssm.domain.Product;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author ZhangPeng
 * @Email ZhangPeng1853093@126.com
 * @date 2020/1/28 - 16:18
 */
public interface ProductDao {
    //根据id查询产品
    @Select("select * from product where id=#{id}")
    Product findById(String id) throws Exception;
    //查询所有产品
    @Select("select * from product")
    List<Product> findAll() throws Exception;
    @Insert("insert into product(productNum,productName,cityName,departureTime,productPrice,productDesc,productStatus) values(#{productNum},#{productName},#{cityName},#{departureTime},#{productPrice},#{productDesc},#{productStatus})")
    void save(Product product);
}
