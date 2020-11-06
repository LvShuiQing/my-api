package com.shuiqing.controller;

import com.alibaba.druid.util.StringUtils;
import com.shuiqing.entity.SmsVO;
import com.shuiqing.service.SmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.UUID;

@RequestMapping("/sms/")
@RestController
public class SmsController {

    @Autowired
    private SmsService smsService;

    @RequestMapping("queryToToken")
    public String queryToToken(String token,String type){
        if(StringUtils.isEmpty(token)||StringUtils.isEmpty(type)){
            return "error";
        }
        try {
            return smsService.querySms(token,type);
        } catch (Exception e) {
            return "error";
        }
    }
}
