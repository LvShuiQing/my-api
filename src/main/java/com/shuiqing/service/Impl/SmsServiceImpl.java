package com.shuiqing.service.Impl;

import com.shuiqing.dao.SmsDao;
import com.shuiqing.entity.SmsVO;
import com.shuiqing.service.SmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SmsServiceImpl implements SmsService {
    @Autowired
    private SmsDao smsDao;

    @Override
    public String querySms(String token,String type) throws Exception {
        SmsVO sms=new SmsVO();
        sms.setToken(token);
        sms.setRdState(1);
        if("0".equals(type)) {
            sms.setType(0);
        }
        List<SmsVO> smsList = smsDao.querySms(sms);
        if("0".equals(type)){
            SmsVO entity = smsList.get(0);
            entity.setType(1);
            smsDao.updateSms(entity);
        }
        if(smsList.size()>0){
            return "success";
        }else{
            return "error";
        }
    }

    @Override
    public int updateSmsById(SmsVO entity) throws Exception {
        return 0;
    }
}
