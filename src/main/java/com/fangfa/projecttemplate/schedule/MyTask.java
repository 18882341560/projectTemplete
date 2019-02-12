package com.fangfa.projecttemplate.schedule;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * @author green
 * @date 2018/12/13/013
 */
public class MyTask extends QuartzJobBean {

    private final Logger logger = LoggerFactory.getLogger(QuartzJobBean.class);


    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        logger.debug("测试quartz");
    }
}
