package com.fangfa.projecttemplate.schedule;

import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Auther 葛林
 * @Date 2019/2/12/012 08
 * @Remarks  稍微复杂的cron可以用这个
 */
@Configuration
public class QuartzConfig {
    @Bean
    public JobDetail uploadTaskDetail() {
        return JobBuilder.newJob(MyTask.class).withIdentity("test").storeDurably().build();
    }

    @Bean
    public Trigger uploadTaskTrigger() {
        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule("0 55 23 L * ?");
        return TriggerBuilder.newTrigger().forJob(uploadTaskDetail())
                .withIdentity("test")
                .withSchedule(scheduleBuilder)
                .build();
    }
}
