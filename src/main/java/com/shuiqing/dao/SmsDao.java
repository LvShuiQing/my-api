package com.shuiqing.dao;

import com.shuiqing.entity.SmsVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SmsDao  {

    List<SmsVO> querySms(SmsVO entity);

    int updateSms(SmsVO entity);
}
