package com.fangfa.projecttemplate.dao;

import com.fangfa.projecttemplate.bean.log.ExceptionLog;
import com.fangfa.projecttemplate.bean.log.OperateionLog;
import org.springframework.stereotype.Repository;

/**
 * @Auther 葛林
 * @Date 2019/2/1/001 11
 * @Remarks
 */
@Repository
public interface LogMapper {
    int insertExceptionLog(ExceptionLog exceptionLog);
    int insertOperationLog(OperateionLog operateionLog);
}
