package com.fangfa.projecttemplate.schedule;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @Auther 葛林
 * @Date 2019/2/3 17:59
 * @describe 使用简单的corn表达式，就直接使用spring的定时器，复杂的用quartz,年后配置一个
 */
@Configurable
@EnableScheduling
@Component
public class SimpleTask {


    //项目启动就执行一次，每隔5分钟执行一次
    @Scheduled(fixedDelay = 5 * 60 * 1000)
    public void removeToken(){
        System.out.println("测试");
    }


    //项目启动后5秒钟开始执行，每隔5秒执行一次
    @Scheduled(cron = "0/5 * * * * ?")
    public void test(){
        System.out.println("测试");
    }


}
