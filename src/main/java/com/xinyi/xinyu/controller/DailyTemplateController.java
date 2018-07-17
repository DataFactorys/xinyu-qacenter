package com.xinyi.xinyu.controller;

import com.xinyi.xinyu.result.Result;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import poggyio.daily.api.TemplateService;
import poggyio.daily.api.result.TemplateRecord;

import java.util.LinkedHashMap;
import java.util.List;

/**
 * Created by 10067610 on 2018/7/17.
 */
@Controller
@RequestMapping("/xinyu")
public class DailyTemplateController extends AbstractJUnit4SpringContextTests {
    ApplicationContext context = new FileSystemXmlApplicationContext("classpath:service.xml");
    public TemplateService templateService = (TemplateService) context.getBean("templateService");

    @RequestMapping(value = "/getDailyTemplate",method = RequestMethod.POST)
    @ResponseBody
    public Result getDailyTemplate(){
        String userId = "0b613362b82f44448fa9851ec53a4740";
        String domainId = "alog";
        String orgCode = "59225de3-ef2b-4c04-ac75-8653c132db6c";
        Integer apiVersion = 1;
        List<TemplateRecord> templateRecordList = templateService.findAllTemplateRecordByUserId(userId, domainId, orgCode, apiVersion);
        LinkedHashMap<Long,String> map = new LinkedHashMap<Long, String>();
        for(TemplateRecord templateRecord : templateRecordList){
            map.put(templateRecord.getTemplateId(), templateRecord.getTemplateName());
        }
        return Result.Success(map);
    }
}
