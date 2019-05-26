package com.join.learn.ssm.dao;

import com.join.learn.ssm.dao.mbg.SysUserMapper;
import com.join.learn.ssm.model.mbg.SysUser;

import java.util.List;

public interface SysUserDao extends SysUserMapper{
    /**
     * find all users from database
     * @return
     */
//    @Select("select * from user")
//    @Results({
//        @Result(property = "userName", column = "user_name")
//    })
    List<SysUser> findAll();
}
