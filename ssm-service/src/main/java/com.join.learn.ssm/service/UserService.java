package com.join.learn.ssm.service;

import com.join.learn.ssm.dao.UserDao;
import com.join.learn.ssm.model.mbg.User;
import com.join.learn.ssm.model.mbg.UserExample;
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
    private UserDao userDAo;

    /**
     * find all users;
     * @return
     */
    public List<User> findAll(){
        TestUtils.test();
        //return userDAo.selectByExample(new UserExample());
        return userDAo.findAll();
    }

}
