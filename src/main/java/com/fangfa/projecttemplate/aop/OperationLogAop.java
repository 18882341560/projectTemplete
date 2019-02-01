package com.fangfa.projecttemplate.aop;

import com.alibaba.fastjson.JSONObject;
import com.fangfa.projecttemplate.annotation.Operateion;
import com.fangfa.projecttemplate.bean.User;
import com.fangfa.projecttemplate.bean.log.OperateionLog;
import com.fangfa.projecttemplate.service.LogService;
import com.fangfa.projecttemplate.util.DateUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

/**
 * @Auther 葛林
 * @Date 2019/2/1/001 11
 * @Remarks  操作日志记录
 */
@Aspect
@Component
public class OperationLogAop {

    @Autowired
    private LogService logService;
    @Autowired
    private HttpServletRequest request;

    //使用该注解的就记录
    @Pointcut(value = "@annotation(operateion)")
    public void section(Operateion operateion){
    }

    @Before("section(operateion)")
    public void doBefore(JoinPoint joinPoint,Operateion operateion){
        String className = joinPoint.getTarget().getClass().getSimpleName();
        String methodName = joinPoint.getSignature().getName();
        User user = (User) request.getSession().getAttribute("user");
        Integer id;
        if(user == null){ //测试用用
             id = 1;
        }else {
            id = user.getId();
        }
        JSONObject jsonObject = new JSONObject();
        Enumeration enu=request.getParameterNames();
        while(enu.hasMoreElements()){
            String paraName=(String)enu.nextElement();
            jsonObject.put(paraName,request.getParameter(paraName));
        }
        OperateionLog operateionLog = new OperateionLog();
        operateionLog.setOperateDateTime(DateUtils.getLocalDateTimeByYYYYMMDDHHmmss());
        operateionLog.setOperateUrl(request.getRequestURI());
        operateionLog.setParameter(jsonObject.toJSONString());
        operateionLog.setOperateUserId(id);
        operateionLog.setOperateExplain(operateion.value());
        operateionLog.setOperateMethod(className+"."+methodName);
        logService.saveOperationLog(operateionLog);
    }


}
