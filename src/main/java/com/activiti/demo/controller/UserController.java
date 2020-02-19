package com.activiti.demo.controller;

import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.omg.PortableServer.REQUEST_PROCESSING_POLICY_ID;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "用户接口", tags = {"用户接口"})
@RequestMapping("/user")
@RestController
public class UserController {
    @ApiOperation(hidden = true,value = "无权限")
    @RequestMapping("/noAuth")
    public Object noAuth(){
        JSONObject result = new JSONObject();
        result.put("msg","noAuth");
        return result;
    }
    @ApiOperation(value = "用户登录")
    @RequestMapping(value = "/login",method = {RequestMethod.POST})
    public Object Login(String username,String password){
        JSONObject result = new JSONObject();
        result.put("username",username);
        result.put("password",password);
        return result;
    }
    @ApiOperation(value = "未登录页面",hidden = true)
    @RequestMapping("/notLogin")
    public Object notLogin(){
        JSONObject result = new JSONObject();
        result.put("msg","未登录");
        return result;
    }
}
