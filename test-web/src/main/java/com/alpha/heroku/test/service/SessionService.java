package com.alpha.heroku.test.service;

import com.alpha.heroku.test.bo.PageBO;
import com.alpha.heroku.test.bo.PageParamBO;
import com.alpha.heroku.test.entity.salesforce.SessionC;

/**
 * @Author huiyan.yao
 * @Date 2019/7/1 11:28
 */
public interface SessionService {

    PageBO<SessionC> getAll(PageParamBO pageParamBO);

    void add();
}
