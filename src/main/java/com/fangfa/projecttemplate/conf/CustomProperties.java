package com.fangfa.projecttemplate.conf;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Auther 葛林
 * @Date 2019/1/31/031 09
 * @Remarks 自定义的一些属性
 */
@ConfigurationProperties(prefix = "custom.properties")
@Component
@Data
public class CustomProperties {
    //保存的文件夹路径
    private String saveFilesFolder;
    //使用的数据库
    private String database;
}
