package com.fangfa.projecttemplate.bean;

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
public class User implements Serializable {
    private static final long serialVersionUID = 4971633322105113453L;
    private Integer id;
    private String username;
    private String password;
}
