package com.join.learn.ssm.service;

import com.join.learn.ssm.dao.UserMapper;
import com.join.learn.ssm.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.join.learn.ssm.mbg.TestUtils;
import java.util.List;

/**
 * user service
 * @author Join 2019-05-23
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * find all users;
     * @return
     */
    public List<User> findAll(){
        TestUtils.test();
        return userMapper.findAll();
    }

}
