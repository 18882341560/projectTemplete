package com.fangfa.projecttemplate;

import com.alibaba.druid.pool.DruidDataSource;
import com.fangfa.projecttemplate.conf.CustomProperties;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.servlet.MultipartConfigElement;
import javax.sql.DataSource;
import java.io.File;
import java.sql.SQLException;

@SpringBootApplication
//启动时不加载数据库
//@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
@EnableTransactionManagement
@MapperScan("com.fangfa.projecttemplate.dao")
@EnableSwagger2
public class ProjectTemplateApplication {

    @Autowired
    private CustomProperties customProperties;

    /**
     * 创建文件保存的路径
     */
    @Bean
    MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        File tmpFile = new File(customProperties.getSaveFilesFolder());
        if (!tmpFile.exists()) {
            tmpFile.mkdirs();
        }
        factory.setLocation(customProperties.getSaveFilesFolder());
        return factory.createMultipartConfig();
    }


    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource() throws SQLException {
        DruidDataSource druidDataSource=new DruidDataSource();
        druidDataSource.setDbType("com.alibaba.druid.pool.DruidDataSource");
        druidDataSource.setInitialSize(10);
        druidDataSource.setMinIdle(10);
        druidDataSource.setMaxActive(200);
        druidDataSource.setMaxWait(60000);
        druidDataSource.setTimeBetweenEvictionRunsMillis(60000);
        druidDataSource.setMinEvictableIdleTimeMillis(300000);
        String database = customProperties.getDatabase();
        if(database.equals("oracle")){
            druidDataSource.setValidationQuery("SELECT 1 FROM DUAL");
        }else {
            druidDataSource.setValidationQuery("SELECT 1");
        }
        druidDataSource.setTestOnReturn(false);
        druidDataSource.setTestOnBorrow(false);
        druidDataSource.setTestWhileIdle(true);
        druidDataSource.setPoolPreparedStatements(true);
        druidDataSource.setMaxPoolPreparedStatementPerConnectionSize(20);
        druidDataSource.setFilters("stat");
        druidDataSource.setConnectionProperties("druid.stat.mergeSql=true;druid.stat.slowSqlMillis=5000");
        return druidDataSource;
    }

    public static void main(String[] args) {
        SpringApplication.run(ProjectTemplateApplication.class, args);
    }

}

