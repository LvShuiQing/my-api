package com.shuiqing.service;

import com.shuiqing.entity.SmsVO;

public interface SmsService {

    String querySms(String token,String type) throws Exception;

    int updateSmsById(SmsVO entity) throws Exception;
}
