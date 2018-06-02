package com.fworldcodez.wzool.service.impl;

import com.fworldcodez.wzool.common.Md5Util;
import com.fworldcodez.wzool.dao.UserMapper;
import com.fworldcodez.wzool.dto.UserDto;
import com.fworldcodez.wzool.pojo.User;
import com.fworldcodez.wzool.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    /**
     * @Description 登陆
     * @
     */
    @Override
    public User login(UserDto userDto) {
        UserDto users = new UserDto();
        List<User> userList = null;
        users.setUserName(userDto.getUserName());
        userList = userMapper.login(users);
        User user = null;
        //判断是否存在用户，存在返回盐值
        if (userList.size() > 0) {
            user = userList.get(0);
        } else {
            return null;
        }
        //盐值
        String salt = user.getSalt();
        String passWord = userDto.getUserPassWord() + salt;
        String passWordMD5 = Md5Util.md5(passWord);

        //判断密码是否正确
        if (user.getUserPassWord().equals(passWordMD5)) {
            return user;
        } else {
            return null;
        }
    }
}
