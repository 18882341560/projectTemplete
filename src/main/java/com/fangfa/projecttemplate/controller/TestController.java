package com.fangfa.projecttemplate.controller;

import com.fangfa.projecttemplate.MyException.MessageException;
import com.fangfa.projecttemplate.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther 葛林
 * @Dte 2019/1/30/030 15
 * @Remarks
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    TestService testService;

    @RequestMapping("/a")
    public Object test() throws Exception {
        testService.test();
        return "测试";
    }



}
