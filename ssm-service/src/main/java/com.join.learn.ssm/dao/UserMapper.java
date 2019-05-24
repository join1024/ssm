package com.join.learn.ssm.dao;

import com.join.learn.ssm.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * user mapper
 * @author Join 2019-05-23
 */
@Mapper
public interface UserMapper {

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
