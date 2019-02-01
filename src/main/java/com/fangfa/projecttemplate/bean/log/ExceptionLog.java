package com.fangfa.projecttemplate.bean.log;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Auther 葛林
 * @Date 2019/2/1/001 10
 * @Remarks 错误异常日志表
 */
@Data
@NoArgsConstructor
public class ExceptionLog implements Serializable {
    private static final long serialVersionUID = -2453591374536421543L;
    private Integer id;
    private String message; //错误信息
    private String requestUrl; //请求url
    private String descInfo; //错误描述
    private String parameter; //参数
    private String dateTime;  //发生时间
}
