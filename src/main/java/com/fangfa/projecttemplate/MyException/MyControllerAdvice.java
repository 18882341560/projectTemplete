package com.fangfa.projecttemplate.MyException;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @Auther 葛林
 * @Date 2019/1/30/030 15
 * @Remarks
 */
@ControllerAdvice
public class MyControllerAdvice{


    @ResponseBody
    @ExceptionHandler(value = MessageException.class)
    public Object myExceptionHandler(MessageException m,HttpServletRequest request){
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("code",m.getCode());
        map.put("message",m.getMessage());
        map.put("requestMethod",request.getRequestURI());
        map.put("descinfo",m.getDescInfo());
        return map;
    }


    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public Object unKnowExceptionHandler(Exception m,HttpServletRequest request){
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("code","500");
        map.put("message",m.getMessage());
        map.put("requestMethod",request.getRequestURI());
        map.put("descinfo","服务未知异常!");
        return map;
    }



}
