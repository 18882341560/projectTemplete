package com.fangfa.projecttemplate.bean.log;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Auther 葛林
 * @Date 2019/2/1/001 14
 * @Remarks  操作日志
 */
@Data
@NoArgsConstructor
public class OperateionLog implements Serializable {
    private static final long serialVersionUID = -8407593245727210782L;

    private Integer id;
    private Integer operateUserId; //操作人的id
    private String operateMethod; //操作的方法
    private String operateUrl;    //操作的方法
    private String parameter;     //传入的参数
    private String operateDateTime; //操作的时间
    private String operateExplain;  //操作说明
}
