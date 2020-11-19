package com.shuiqing.controller;

import com.alibaba.druid.util.StringUtils;
import com.shuiqing.entity.SmsVO;
import com.shuiqing.service.SmsService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.UUID;

@Api("短信")
@RequestMapping("/sms/")
@RestController
public class SmsController {

    @Autowired
    private SmsService smsService;

    @RequestMapping(value = "queryToToken",method = RequestMethod.POST)
    @ApiOperation(value = "短信token验证接口",notes = "短信token验证接口")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query",value = "token",name = "token",required = true,dataType = "string"),
            @ApiImplicitParam(paramType = "query",value = "类型",name = "type",required = true,dataType = "string")
    })
    @ApiResponses({
            @ApiResponse(code = 201,message = "成功"),
            @ApiResponse(code = 202,message = "失败")
    })
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
