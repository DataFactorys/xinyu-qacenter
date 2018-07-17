package com.xinyi.xinyu.controller;

import com.alibaba.dubbo.common.utils.StringUtils;
import com.alibaba.fastjson.JSON;
import com.xinyi.xinyu.result.Result;
import com.xinyi.xinyu.result.ResultCode;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import poggyio.daily.api.DailyService;
import poggyio.daily.api.req.ContentDetailRequest;
import poggyio.daily.api.req.DailySaveRequest;
import poggyio.daily.api.req.RecipientRequest;
import poggyio.daily.api.result.DailyRecord;
import poggyio.daily.mybatis.model.Daily;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 10067610 on 2018/7/16.
 */

@Controller
@RequestMapping("/xinyu")
public class DailyController extends AbstractJUnit4SpringContextTests{
    ApplicationContext context = new FileSystemXmlApplicationContext("classpath:service.xml");
    public DailyService dailyService = (DailyService) context.getBean("dailyService");

    @RequestMapping(value = "/findDaily",method = RequestMethod.POST)
    @ResponseBody
    public Result findDaily(@RequestParam(value = "param0") String param0){

        if (!StringUtils.isNumeric(param0)) {
            return Result.Failure(ResultCode.PARAMS_IS_NOT_NUMERIC);
        }
        if ((param0 == null || param0.trim().length() == 0)) {
            return Result.Failure(ResultCode.PARAMS_IS_ERROR);
        }
        Long dailyId = Long.valueOf(param0);
        Daily daily = dailyService.findDailyByDailyId(dailyId);
        System.out.println(JSON.toJSONString(daily));
        return Result.Success(daily);
    }

    @RequestMapping(value = "/saveDaily",method = RequestMethod.POST)
    @ResponseBody
    public Result saveDaily(@RequestParam(value = "param0") String param0, @RequestParam(value = "param1") String param1, @RequestParam(value = "param2") String param2, @RequestParam(value = "param3") String param3){
        if (!StringUtils.isNumeric(param1)) {
            return Result.Failure(ResultCode.PARAMS_IS_NOT_NUMERIC);
        }
        if ((param0 == null || param0.trim().length() == 0)||(param1 == null || param1.trim().length() == 0)||(param2 == null || param2.trim().length() == 0)||(param3 == null || param3.trim().length() == 0)) {
            return Result.Failure(ResultCode.PARAMS_IS_ERROR);
        }
        ContentDetailRequest contentDetailRequest = new ContentDetailRequest();
        contentDetailRequest.setFieldContent(param2);
        contentDetailRequest.setFieldType("STRING");
        contentDetailRequest.setFieldName("jinrigongzuo");
        contentDetailRequest.setIsRequired("0");
        contentDetailRequest.setFieldIsEdit("1");
        List<ContentDetailRequest> contentDetailList = new ArrayList<ContentDetailRequest>();
        contentDetailList.add(contentDetailRequest);

        RecipientRequest recipientRequest = new RecipientRequest();
        recipientRequest.setDomainId("alog");
        recipientRequest.setOrgCode("59225de3-ef2b-4c04-ac75-8653c132db6c");
        recipientRequest.setSendUserId(param0);
        recipientRequest.setRecipientUserId(param3);
        recipientRequest.setIsEdit("1");
        recipientRequest.setSendUserId(param0);
        recipientRequest.setRecipientUserId(param3);
        List<RecipientRequest> recipientRequestsList = new ArrayList<RecipientRequest>();
        recipientRequestsList.add(recipientRequest);

        DailySaveRequest dailySaveRequest = new DailySaveRequest();
        dailySaveRequest.setCreateUserId(param0);
        dailySaveRequest.setTemplateId(Long.valueOf(param1));
        dailySaveRequest.setRecipientList(recipientRequestsList);
        dailySaveRequest.setContentDetailList(contentDetailList);
        dailySaveRequest.setOrgCode("59225de3-ef2b-4c04-ac75-8653c132db6c");
        dailySaveRequest.setCreateUserName("wanghua");
        dailySaveRequest.setDomainId("alog");
        dailySaveRequest.setVersion(1);
        dailySaveRequest.setTemplateName("ribao");
        dailySaveRequest.setIsDraft("0");
        dailySaveRequest.setIsUpdate("0");
        dailySaveRequest.setUpdateUserId(param0);
        dailySaveRequest.setRemarks("ceshi");
        dailySaveRequest.setLatitude("30.269228");
        dailySaveRequest.setLongitude("120.111541");
        dailySaveRequest.setLocationName("xinyu");
        System.out.println(JSON.toJSONString(dailySaveRequest));
        DailyRecord dailyRecord = dailyService.saveDailyAndOthers(dailySaveRequest);
        System.out.println(JSON.toJSONString(dailyRecord));
        return Result.Success(dailyRecord);
    }
}
