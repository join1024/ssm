package com.join.learn.ssm.service;

import com.join.learn.ssm.dao.SysUserDao;
import com.join.learn.ssm.model.mbg.SysUser;
import com.join.learn.ssm.model.mbg.SysUserExample;
import com.join.learn.ssm.utils.CommonUtils;
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
    private SysUserDao sysUserDAo;

    /**
     * find all users;
     * @return
     */
    public List<SysUser> findAll(){
        TestUtils.test();
        //return sysUserDAo.selectByExample(new UserExample());
        return sysUserDAo.findAll();
    }

    /**
     * 根据账号查询
     * @param account
     * @return
     */
    public SysUser findByAccount(String account){
        SysUserExample example=new SysUserExample();
        example.createCriteria().andAccountEqualTo(account);
        return CommonUtils.getFirstElement(sysUserDAo.selectByExample(example));
    }


}
