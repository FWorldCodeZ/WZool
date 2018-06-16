package com.fworldcodez.wzool.controller;

import com.fworldcodez.wzool.common.JsonResult;
import com.fworldcodez.wzool.config.MyConfig;
import com.fworldcodez.wzool.dto.UserDto;
import com.fworldcodez.wzool.pojo.User;
import com.fworldcodez.wzool.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@RequestMapping("/user")
@Controller
public class UserController {
    private JsonResult jsonResult;
    @Autowired
    UserService userService;
    @Autowired
    private MyConfig myConfig;

    /**
     * @param
     * @Author FWorldCodeZ
     * @Description 登陆判断是否为空
     */
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult login(@RequestParam(value = "userName", required = false) String userName,
                            @RequestParam(value = "userPassword", required = false) String userPassword
            , HttpSession session
            , HttpServletResponse response) {
        jsonResult = new JsonResult();
        //判断是否为空
        if (userName != null && !userName.equals("")) {
            if (userPassword == null || userPassword.equals("")) {
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
        userDto.setUserPassword(userPassword);
        //调用service层
        try {
            User user = userService.login(userDto);
            if (user != null) {
                UsernamePasswordToken token = new UsernamePasswordToken(userDto.getUserName(), userDto.getUserPassword());
//                //把当前用户放入session
//                Session session = subject.getSession();
//                User tUser = permissionService.findByUserEmail(email);
//                session.setAttribute("currentUser",tUser);
                session.setAttribute(myConfig.sessionInfo, user);
                //在调用了login方法后,SecurityManager会收到AuthenticationToken,并将其发送给已配置的Realm执行必须的认证检查
                //每个Realm都能在必要时对提交的AuthenticationTokens作出反应
                //所以这一步在调用login(token)方法时,它会走到MyRealm.doGetAuthenticationInfo()方法中,具体验证方式详见此方法
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
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult register(User user
            , HttpServletRequest request) {
        jsonResult = new JsonResult();
        //判断是否为空
        if (user.getUserName() != null && !user.getUserName().equals("")) {
            if (user.getUserPassword() == null || user.getUserPassword().equals("")) {
                jsonResult.setMsg("密码不能为空!");
                jsonResult.setStatus("400");
                return jsonResult;
            }
        } else {
            jsonResult.setMsg("用户名不能为空!");
            jsonResult.setStatus("400");
            return jsonResult;
        }
        try {
            jsonResult=userService.register(user);
        }catch (Exception e){
            e.printStackTrace();
            jsonResult.setMsg("注册异常！");
            return jsonResult;
        }

        return jsonResult;
    }
}
