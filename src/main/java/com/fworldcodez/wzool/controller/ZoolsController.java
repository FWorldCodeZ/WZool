package com.fworldcodez.wzool.controller;

import com.fworldcodez.wzool.common.JsonResult;
import com.fworldcodez.wzool.config.MyConfig;
import com.fworldcodez.wzool.pojo.User;
import com.fworldcodez.wzool.pojo.Zools;
import com.fworldcodez.wzool.service.ZoolsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;

@Controller
@RequestMapping("/zools")
public class ZoolsController {
    @Autowired
    private ZoolsService zoolsService;
    @Autowired
    private MyConfig myConfig;

    /**
     * 按条件查找
     */
    @RequestMapping(value = "/selectByCondition", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult selectByCondition(@RequestBody Zools zools, HttpSession session, HttpServletRequest request) {
        JsonResult jsonResult = new JsonResult();
        try {
            Integer userId = 0;
//        File filePath = new File(request.getServletContext().getRealPath("/") + myConfig.imagePath);
            User user = (User) session.getAttribute(myConfig.sessionInfo);
            if (user != null) {
                userId = user.getId();
            }
            jsonResult = zoolsService.selectOfCondition(zools, userId);
        } catch (Exception e) {
            e.printStackTrace();
            jsonResult.setStatus("500");
            jsonResult.setMsg("异常！");
            return jsonResult;
        }
        return jsonResult;
    }

}
