package com.shuiqing.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class SmsVO implements Serializable {

    private Integer id;
    //秘钥
    private String token;
    //用户名
    private String  userName;
    //状态（0：删除，1：正常 ）
    private Integer rdState;
    //创建时间
    private Date createTime;
    //标识（0：未使用，1：已使用）
    private Integer type;
}
