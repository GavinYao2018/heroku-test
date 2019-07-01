package com.alpha.heroku.test.entity;

import lombok.Data;

import java.util.Date;
import javax.persistence.*;

@Data
@Table(name = "session_speaker__c", schema = "salesforce")
public class SessionSpeakerC {
    @Id
    private Integer id;

    private Date createddate;

    private Boolean isdeleted;

    private String name;

    private Date systemmodstamp;

    @Column(name = "session__c")
    private String sessionC;

    @Column(name = "speaker__c")
    private String speakerC;

    private String sfid;

    @Column(name = "_hc_lastop")
    private String hcLastop;

    @Column(name = "_hc_err")
    private String hcErr;
}