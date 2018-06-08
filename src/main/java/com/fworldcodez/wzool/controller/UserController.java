package com.fworldcodez.wzool.controller;

import com.fworldcodez.wzool.common.JsonResult;
import com.fworldcodez.wzool.dto.UserDto;
import com.fworldcodez.wzool.pojo.User;
import com.fworldcodez.wzool.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@RequestMapping("/user")
@Controller
public class UserController {
    private JsonResult jsonResult;
    @Autowired
    UserService userService;

    /**
     * @param
     * @Author FWorldCodeZ
     * @Description 登陆判断是否为空
     */
    @RequestMapping("/login")
    @ResponseBody
    public JsonResult login(@RequestParam(value = "userName", required = false) String userName,
                            @RequestParam(value = "userPassWord", required = false) String userPassWord,
                            HttpServletRequest request) {
        jsonResult = new JsonResult();
        //判断是否为空
        if (userName != null && !userName.equals("")) {
            if (userPassWord == null || userPassWord.equals("")) {
                jsonResult.setMsg("密码不能为空!");
                jsonResult.setStatus("400");
                return jsonResult;
            }
        } else {
            jsonResult.setMsg("用户名不能为空!");
            jsonResult.setStatus("400");
            return jsonResult;
        }
        Subject subject = SecurityUtils.getSubject();
        //如果已登录，无需重新登录
        if (subject.isAuthenticated()) {
            jsonResult.setStatus(HttpStatus.OK.toString());
            jsonResult.setMsg("登录成功！");
            return jsonResult;
        }
        //注入
        UserDto userDto = new UserDto();
        userDto.setUserName(userName);
        userDto.setUserPassWord(userPassWord);
        //调用service层
        try {
            User user = userService.login(userDto);
            if (user != null) {
                UsernamePasswordToken token = new UsernamePasswordToken(userDto.getUserName(), userDto.getUserPassWord());
                subject.login(token);
                jsonResult.setStatus("200");
                jsonResult.setMsg("登陆成功！");
            } else {
                jsonResult.setStatus("400");
                jsonResult.setMsg("密码或者用户不存在！");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return jsonResult;
        }
        return jsonResult;
    }

    /**
     * @param
     * @Author FWorldCodeZ
     * @Description 注册判断是否为空
     */
    @RequestMapping("/register")
    @ResponseBody
    public JsonResult register(@RequestBody UserDto userDto
            , HttpServletRequest request) {
        jsonResult=new JsonResult();
        return null;
    }
}
