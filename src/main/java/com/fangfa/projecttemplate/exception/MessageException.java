package com.fangfa.projecttemplate.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Auther 葛林
 * @Date 2019/1/30/030 15
 * @Remarks 自定义运行时异常
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MessageException extends RuntimeException {
    private static final long serialVersionUID = 7372007225630254154L;
    private String code; //错误码
    private String message; //错误消息
    private String descInfo; //错误描述
}
