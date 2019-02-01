package com.fangfa.projecttemplate.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Auther 葛林
 * @Date 2019/2/1/001 15
 * @Remarks
 */
@Data
@NoArgsConstructor
@ApiModel(value = "user",description = "用户对象111")
public class User implements Serializable {
    private static final long serialVersionUID = 4971633322105113453L;
    private Integer id;
    @ApiModelProperty(value = "用户名")
    private String username;
    @ApiModelProperty(value = "密码")
    private String password;
}
