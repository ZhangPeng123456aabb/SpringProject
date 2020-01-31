package com.alibaba.ssm.dao;

import com.alibaba.ssm.domain.Member;
import org.apache.ibatis.annotations.Select;

/**
 * @author ZhangPeng
 * @Email ZhangPeng1853093@126.com
 * @date 2020/1/28 - 23:52
 */
public interface MemberDao {
    @Select("select * from member where id=#{id}")
    Member findById(String id) throws Exception;
}
