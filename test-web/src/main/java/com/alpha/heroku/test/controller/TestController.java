package com.alpha.heroku.test.controller;

import com.alpha.heroku.test.bo.PageBO;
import com.alpha.heroku.test.bo.PageParamBO;
import com.alpha.heroku.test.bo.ResponseBO;
import com.alpha.heroku.test.entity.salesforce.SessionC;
import com.alpha.heroku.test.service.SessionService;
import com.alpha.heroku.test.utils.uuid.UUIDUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * @Author huiyan.yao
 * @Date 2019/6/26 15:08
 */
@Controller
@Slf4j
public class TestController {

    @Autowired
    private SessionService sessionService;

    @GetMapping("/test")
    @ResponseBody
    public String test() {
        return String.valueOf(System.currentTimeMillis());
    }

    @GetMapping("/list")
    @ResponseBody
    public ResponseBO<PageBO<SessionC>> list(PageParamBO pageParamBO) {
        PageBO<SessionC> pageBO = sessionService.getAll(pageParamBO);
        return new ResponseBO<>(pageBO);
    }

    @GetMapping("/add")
    @ResponseBody
    public ResponseBO<Void> add() {
        sessionService.add();
        return new ResponseBO<>();
    }
}
