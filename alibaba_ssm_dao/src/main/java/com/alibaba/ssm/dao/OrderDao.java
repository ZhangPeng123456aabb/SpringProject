package com.alibaba.ssm.dao;

import com.alibaba.ssm.domain.Member;
import com.alibaba.ssm.domain.Orders;
import com.alibaba.ssm.domain.Product;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author ZhangPeng
 * @Email ZhangPeng1853093@126.com
 * @date 2020/1/28 - 22:54
 */
public interface OrderDao {
    @Select("select * from orders")
    @Results({
          @Result(id=true,property = "id",column = "id"),
            @Result(property = "orderNum",column = "orderNum"),
            @Result(property = "orderTime",column = "orderTime"),
            @Result(property = "orderStatus",column = "orderStatus"),
            @Result(property = "peopleCount",column = "peopleCount"),
            @Result(property = "peopleCount",column = "peopleCount"),
            @Result(property = "payType",column = "payType"),
            @Result(property = "orderDesc",column = "orderDesc"),
            @Result(property = "product",column = "productId",javaType = Product.class,one = @One(select = "com.alibaba.ssm.dao.ProductDao.findById")),
    })
    List<Orders> findAll() throws Exception;

    //多表操作
    @Select("select * from orders where id=#{ordersId}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "orderNum", column = "orderNum"),
            @Result(property = "orderTime", column = "orderTime"),
            @Result(property = "orderStatus", column = "orderStatus"),
            @Result(property = "peopleCount", column = "peopleCount"),
            @Result(property = "peopleCount", column = "peopleCount"),
            @Result(property = "payType", column = "payType"),
            @Result(property = "orderDesc", column = "orderDesc"),
            @Result(property = "product", column = "productId", javaType = Product.class, one = @One(select = "com.alibaba.ssm.dao.ProductDao.findById")),
            @Result(property = "member",column = "memberId",javaType = Member.class,one = @One(select = "com.alibaba.ssm.dao.MemberDao.findById")),
            @Result(property = "travellers",column = "id",javaType =java.util.List.class,many = @Many(select = "com.alibaba.ssm.dao.TravellerDao.findByOrdersId"))
    })
    Orders findById(String ordersId) throws Exception;
}
