package com.xinyi.xinyu.controller;

import com.xinyi.xinyu.result.Result;
import com.xinyi.xinyu.constants.enums.UserIdEnum;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.LinkedHashMap;

/**
 * Created by 10067610 on 2018/7/17.
 */
@Controller
@RequestMapping("/xinyu")
public class UserController {
    @RequestMapping(value = "/getUserId",method = RequestMethod.POST)
    @ResponseBody
    public Result getUserId(){
        Result result = new Result();
        LinkedHashMap<String, Long> map = new LinkedHashMap<String, Long>();
        for(UserIdEnum userIdEnumEnum : UserIdEnum.values()){
            map.put(userIdEnumEnum.getVal(),userIdEnumEnum.getNote());
        }
        return result.Success(map);
    }
}
