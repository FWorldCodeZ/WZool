package com.fworldcodez.wzool.service;

import com.fworldcodez.wzool.common.JsonResult;
import com.fworldcodez.wzool.dto.UserDto;
import com.fworldcodez.wzool.pojo.User;

public interface UserService {
    /**
     * 登陆
     * */
    User login(UserDto userDto);
    /**
     * 注册*/
    JsonResult register(User user);
}
