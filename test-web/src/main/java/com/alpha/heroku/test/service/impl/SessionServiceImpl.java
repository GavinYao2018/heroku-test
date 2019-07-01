package com.alpha.heroku.test.service.impl;

import com.alpha.heroku.test.bo.PageBO;
import com.alpha.heroku.test.bo.PageParamBO;
import com.alpha.heroku.test.entity.SessionC;
import com.alpha.heroku.test.mapper.SessionCMapper;
import com.alpha.heroku.test.service.SessionService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author huiyan.yao
 * @Date 2019/7/1 11:29
 */
@Service
@Slf4j
public class SessionServiceImpl implements SessionService {
    @Autowired
    private SessionCMapper mapper;

    @Override
    public PageBO<SessionC> getAll(PageParamBO pageParamBO) {
        PageHelper.startPage(pageParamBO.getPageIndex(), pageParamBO.getPageSize());
        Page page = (Page) mapper.selectByExample(null);
        return new PageBO<>(page, SessionC.class);
    }

    @Override
    public void add(SessionC session) {
        mapper.insertSelective(session);
        log.info("对象插入完毕：{}", session);
    }
}
