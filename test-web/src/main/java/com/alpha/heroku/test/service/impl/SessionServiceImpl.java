package com.alpha.heroku.test.service.impl;

import com.alpha.heroku.test.bo.PageBO;
import com.alpha.heroku.test.bo.PageParamBO;
import com.alpha.heroku.test.entity.salesforce.SessionC;
import com.alpha.heroku.test.entity.salesforce.SessionSpeakerC;
import com.alpha.heroku.test.entity.salesforce.SpeakerC;
import com.alpha.heroku.test.mapper.SessionCMapper;
import com.alpha.heroku.test.mapper.SessionSpeakerCMapper;
import com.alpha.heroku.test.mapper.SpeakerCMapper;
import com.alpha.heroku.test.service.SessionService;
import com.alpha.heroku.test.utils.uuid.UUIDUtils;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @Author huiyan.yao
 * @Date 2019/7/1 11:29
 */
@Service
@Slf4j
public class SessionServiceImpl implements SessionService {
    @Autowired
    private SessionCMapper sessionCMapper;
    @Autowired
    private SpeakerCMapper speakerCMapper;
    @Autowired
    private SessionSpeakerCMapper sessionSpeakerCMapper;

    @Override
    public PageBO<SessionC> getAll(PageParamBO pageParamBO) {
        PageHelper.startPage(pageParamBO.getPageIndex(), pageParamBO.getPageSize());
        Page page = (Page) sessionCMapper.selectByExample(null);
        return new PageBO<>(page, SessionC.class);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void add() {
        String sessionReferId = UUIDUtils.uuid();
        SessionC session = new SessionC();
        session.setName("马修" + String.valueOf(System.currentTimeMillis()));
        session.setLevelC("Advanced");
        session.setDescriptionC("马修要好好学！" + String.valueOf(System.currentTimeMillis()));
        session.setHcExtendIdC(sessionReferId);
        session.setIsdeleted(Boolean.FALSE);
        session.setCreateddate(new Date());
        session.setSessionDateC(new Date());
        sessionCMapper.insertSelective(session);
        log.info("对象Session插入完毕：{}", session);

        String speakerReferId = UUIDUtils.uuid();
        SpeakerC speaker = new SpeakerC();
        //speaker.setName("name");
        speaker.setFirstNameC("Gavin" + String.valueOf(System.currentTimeMillis()));
        speaker.setLastNameC("uncle" + String.valueOf(System.currentTimeMillis()));
        speaker.setEmailC("253181316@qq.com");
        speaker.setBioC("remark");
        speaker.setIsdeleted(Boolean.FALSE);
        speaker.setHcExtendIdC(speakerReferId);
        speaker.setCreateddate(new Date());
        speakerCMapper.insertSelective(speaker);
        log.info("对象Speaker插入完毕：{}", session);

        SessionSpeakerC sessionSpeakerC = new SessionSpeakerC();
        //sessionSpeakerC.setName("what???");
        sessionSpeakerC.setSessionRHcExtendIdC(sessionReferId);
        sessionSpeakerC.setSpeakerRHcExtendIdC(speakerReferId);
        sessionSpeakerC.setCreateddate(new Date());
        sessionSpeakerCMapper.insertSelective(sessionSpeakerC);

        log.info("对象插入完毕：{}", session);
    }
}
