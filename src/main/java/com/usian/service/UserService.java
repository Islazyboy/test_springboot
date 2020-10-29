package com.usian.service;

import com.usian.entity.User;
import com.usian.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.ws.Action;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public Boolean select(User user) {
        User user1 = userMapper.selectOne(user);
        if(user1!=null){
            return true;
        }else {
            return false;
        }
    }
}
