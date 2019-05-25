package com.join.learn.ssm.dao;

import com.join.learn.ssm.dao.mbg.UserMapper;
import com.join.learn.ssm.model.mbg.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

public interface UserDao extends UserMapper {
    /**
     * find all users from database
     * @return
     */
//    @Select("select * from user")
//    @Results({
//        @Result(property = "userName", column = "user_name")
//    })
    List<User> findAll();
}
