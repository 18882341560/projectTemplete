package com.fangfa.projecttemplate.controller;

import com.fangfa.projecttemplate.annotation.Operateion;
import com.fangfa.projecttemplate.bean.User;
import com.fangfa.projecttemplate.redis.RedisService;
import com.fangfa.projecttemplate.service.TestService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther 葛林
 * @Dte 2019/1/30/030 15
 * @Remarks
 */
@RestController
@RequestMapping("/test")
@Api(value="测试controller")
public class TestController {

    @Autowired
    TestService testService;
    @Autowired
    RedisService redisService;

    @GetMapping("/a")
    @Operateion("测试操作1")
    @ApiOperation(value = "测试swagger",notes = "根据url的id来获取用户详细信息") //方法说明
    @ApiImplicitParam(name = "id",value = "用户id",required = true,dataType = "Integer")
    public Object test(Integer id) throws Exception {
//        testService.test();
        return "测试";
    }



    @PostMapping("/b")
    @ApiOperation(value = "保存用户",notes = "啦啦啦啦啦")
    @ApiImplicitParam(name = "user",value = "用户对象",required = true,dataType = "user")
    public User getUser(User user){
        return null;
    }




    @RequestMapping("/c")
    public void saveUser(){
       User user = User.builder()
                       .username("geLin")
                       .password("123456")
                       .build();
       redisService.set("user-1",user);
    }


    @RequestMapping("/d")
    public User get(){
        return (User) redisService.get("user-1");
    }



}
