package com.fangfa.projecttemplate.service.impl;

import com.fangfa.projecttemplate.bean.log.ExceptionLog;
import com.fangfa.projecttemplate.bean.log.OperateionLog;
import com.fangfa.projecttemplate.dao.LogMapper;
import com.fangfa.projecttemplate.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Auther 葛林
 * @Date 2019/2/1/001 11
 * @Remarks
 */
@Transactional
@Service
public class LogServiceImpl implements LogService {

    @Autowired
    private LogMapper logMapper;

    @Override
    public void saveExceptionLog(ExceptionLog exceptionLog) {
        logMapper.insertExceptionLog(exceptionLog);
    }

    @Override
    public void saveOperationLog(OperateionLog operateionLog) {
       logMapper.insertOperationLog(operateionLog);
    }
}
