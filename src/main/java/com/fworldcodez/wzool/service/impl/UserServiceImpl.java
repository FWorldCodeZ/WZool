package com.fworldcodez.wzool.service.impl;

import com.fworldcodez.wzool.common.JsonResult;
import com.fworldcodez.wzool.common.Md5Util;
import com.fworldcodez.wzool.dao.UserMapper;
import com.fworldcodez.wzool.dto.UserDto;
import com.fworldcodez.wzool.pojo.User;
import com.fworldcodez.wzool.service.RoleService;
import com.fworldcodez.wzool.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RoleService roleService;

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
        String passWord = userDto.getUserPassword() + salt;
        String passWordMD5 = Md5Util.smallmd5(passWord);

        //判断密码是否正确
        if (user.getUserPassword().equals(passWordMD5)) {
            return user;
        } else {
            return null;
        }
    }

    /**
     * @param User return json
     * @Descripation 注册
     */
    @Transactional
    @Override
    public JsonResult register(User user) {
        JsonResult jsonResult = new JsonResult();
        Integer userId=userMapper.selectByName(user.getUserName());//获取用户id
        if(userId !=null){
            jsonResult.setStatus("500");
            jsonResult.setMsg("用户已存在！请重新输入！");
            return jsonResult;
        }
        user.setState(1);//1.允许登陆 0.禁止登陆
        Long saltEnd = System.currentTimeMillis();
        String salt = Md5Util.smallmd5(user.getUserPassword() + saltEnd);//盐值
        String passWord = user.getUserPassword() + salt;//加密后的密码
        user.setUserPassword(Md5Util.smallmd5(passWord));
        user.setSalt(salt);
        user.setAccount("11111");
        user.setAddress("大营街");
        user.setOrgunitId(1111111);
        userMapper.insert(user);
        Integer id=userMapper.selectByName(user.getUserName());//获取用户id
        //获取角色
        //插入角色关系
        roleService.matchRoleForCustomer(id);
        jsonResult.setStatus("200");
        jsonResult.setMsg("注册成功！");
        return jsonResult;
    }

}
