package com.join.learn.ssm.security;

import com.join.learn.ssm.model.mbg.SysUser;
import com.join.learn.ssm.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 *
 */
@Service("userDetailsServiceImpl")
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String account) throws UsernameNotFoundException {
        SysUser user=userService.findByAccount(account);
        Objects.requireNonNull(user,"用户不存在");

        UserDetails userDetails=new UserDetailsBean();
        BeanUtils.copyProperties(user,userDetails);
        return userDetails;
    }
}
