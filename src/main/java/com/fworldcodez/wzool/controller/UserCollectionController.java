package com.fworldcodez.wzool.controller;

import com.fworldcodez.wzool.common.JsonResult;
import com.fworldcodez.wzool.config.MyConfig;
import com.fworldcodez.wzool.pojo.User;
import com.fworldcodez.wzool.pojo.UserCollection;
import com.fworldcodez.wzool.service.UserCollectionService;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.apache.shiro.session.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @Author FWordCodeZ
 * @Description 收藏
 * @Date 20:49 2018-06-16
 */
@Controller
@RequestMapping("/collection")
public class UserCollectionController {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserCollectionController.class);
    @Autowired
    private UserCollectionService userCollectionService;
    @Autowired
    private MyConfig myConfig;

    @RequestMapping(value = "/addCollection", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult addCollection(@RequestBody UserCollection userCollection, HttpSession httpSession, HttpServletRequest request) {
        JsonResult jsonResult = new JsonResult();
        LOGGER.info("myConfig---" + myConfig.sessionInfo);
       // LOGGER.info("userId---" + WebUtils.getSessionAttribute(request, myConfig.sessionInfo));
      //  User session = (User) WebUtils.getSessionAttribute(request, myConfig.sessionInfo);
        User session = (User)httpSession.getAttribute(myConfig.sessionInfo);
        if (session == null || session.getId()==null) {
            jsonResult.setStatus("500");
            jsonResult.setMsg("您还未登陆！不能进行收藏!");
            return jsonResult;
        }
        Integer userId = session.getId();
        LOGGER.info("role-"+session.getRoleList().size());
        LOGGER.info("session----" + userId+"----"+userCollection.getOtherId());
        userCollection.setUserId(userId);
        try {
            jsonResult = userCollectionService.addCollection(userCollection);
            return jsonResult;
        } catch (Exception e) {
            e.printStackTrace();
            return jsonResult;
        }
    }

    @ResponseBody
    @RequestMapping(value = "/selectList")
    public JsonResult selectList(@RequestBody Map map, HttpServletRequest request) {
        JsonResult jsonResult = new JsonResult();
        Session session = (Session) request.getSession();
        User user = (User) session.getAttribute(myConfig.sessionInfo);
        Integer userId = user.getId();
        LOGGER.info("userId---" + userId);
        if (user.getId() == null) {
            jsonResult.setStatus("500");
            jsonResult.setMsg("您还未登陆！不能进行收藏!");
            return jsonResult;
        }
        map.put("userId", userId);
        try {
            jsonResult = userCollectionService.selectCollections(map);
        } catch (Exception e) {
            e.printStackTrace();
            return jsonResult;
        }
        return jsonResult;
    }
}
