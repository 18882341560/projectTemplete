package com.fangfa.projecttemplate.service;

import com.fangfa.projecttemplate.bean.log.ExceptionLog;
import com.fangfa.projecttemplate.bean.log.OperateionLog;

/**
 * @Auther 葛林
 * @Date 2019/2/1/001 11
 * @Remarks
 */
public interface LogService {
    void saveExceptionLog(ExceptionLog exceptionLog);
    void saveOperationLog(OperateionLog operateionLog);
}
