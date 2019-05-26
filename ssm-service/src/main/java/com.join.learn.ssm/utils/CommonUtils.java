package com.join.learn.ssm.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * 工具类
 * @author join
 */
public class CommonUtils {

    /**
     * 返回列表中第一个元素
     * @param list
     * @param <T>
     * @return
     */
    public static  <T> T getFirstElement(List<T> list){
        if(CollectionUtils.isEmpty(list)){
            return null;
        }
        return list.get(0);
    }

    public static void main(String[] args) {
        System.out.println(new BCryptPasswordEncoder().encode("123456"));
    }
}
