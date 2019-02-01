package com.fangfa.projecttemplate.MyException;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Auther 葛林
 * @Date 2019/1/30/030 15
 * @Remarks
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MessageException extends RuntimeException {
    private String code; //错误码
    private String message; //错误消息
    private String descInfo; //错误描述
}
