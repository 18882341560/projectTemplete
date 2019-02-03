package com.fangfa.projecttemplate.exception;

import com.alibaba.fastjson.JSONObject;
import com.fangfa.projecttemplate.bean.log.ExceptionLog;
import com.fangfa.projecttemplate.service.LogService;
import com.fangfa.projecttemplate.util.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * @Auther 葛林
 * @Date 2019/1/30/030 15
 * @Remarks  全局异常处理
 */
@ControllerAdvice
public class MyControllerAdvice{

    @Autowired
    private LogService logService;


    @ResponseBody
    @ExceptionHandler(value = MessageException.class)
    public Object myExceptionHandler(MessageException m,HttpServletRequest request){
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("code",m.getCode());
        map.put("message",m.getMessage());
        map.put("requestUrl",request.getRequestURI());
        map.put("descInfo",m.getDescInfo());
        JSONObject jsonObject = new JSONObject();
        Enumeration enu=request.getParameterNames();
        while(enu.hasMoreElements()){
            String paraName=(String)enu.nextElement();
            jsonObject.put(paraName,request.getParameter(paraName));
        }
        map.put("parameter",jsonObject);

        //保存错误日志
        ExceptionLog exceptionLog = new ExceptionLog();
        exceptionLog.setMessage(m.getMessage());
        exceptionLog.setDescInfo(m.getDescInfo());
        exceptionLog.setRequestUrl(request.getRequestURI());
        exceptionLog.setParameter(jsonObject.toJSONString());
        exceptionLog.setDateTime(DateUtils.getLocalDateTimeByYYYYMMDDHHmmss());
        logService.saveExceptionLog(exceptionLog);
        return map;
    }


    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public Object unKnowExceptionHandler(Exception m,HttpServletRequest request){
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("code","500");
        map.put("message",m.getMessage());
        map.put("requestUrl",request.getRequestURI());
        map.put("descInfo","服务未知异常!");
        JSONObject jsonObject = new JSONObject();
        Enumeration enu=request.getParameterNames();
        while(enu.hasMoreElements()){
            String paraName=(String)enu.nextElement();
            jsonObject.put(paraName,request.getParameter(paraName));
        }
        map.put("parameter",jsonObject);

        //保存错误日志
        ExceptionLog exceptionLog = new ExceptionLog();
        exceptionLog.setMessage(m.getMessage());
        exceptionLog.setDescInfo("服务未知异常!");
        exceptionLog.setRequestUrl(request.getRequestURI());
        exceptionLog.setParameter(jsonObject.toJSONString());
        exceptionLog.setDateTime(DateUtils.getLocalDateTimeByYYYYMMDDHHmmss());
        logService.saveExceptionLog(exceptionLog);
        return map;
    }



}
