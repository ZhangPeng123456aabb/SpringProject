package com.alibaba.ssm.dao;

import com.alibaba.ssm.domain.Traveller;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author ZhangPeng
 * @Email ZhangPeng1853093@126.com
 * @date 2020/1/28 - 23:55
 */
public interface TravellerDao {
    @Select("select * from traveller where id in (select travellerId from order_traveller where orderId=#{ordersId})")
    List<Traveller> findByOrdersId(String ordersId) throws Exception;
}
