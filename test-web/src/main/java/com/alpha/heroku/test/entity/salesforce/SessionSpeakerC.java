package com.alpha.heroku.test.entity.salesforce;

import lombok.Data;

import java.util.Date;
import javax.persistence.*;

@Data
@Table(name = "salesforce.session_speaker__c")
public class SessionSpeakerC {
    @Id
    private Integer id;

    @Column(name = "speaker__c")
    private String speakerC;

    @Column(name = "session__r__hc_extend_id__c")
    private String sessionRHcExtendIdC;

    private String name;

    @Column(name = "session__c")
    private String sessionC;

    private Boolean isdeleted;

    private Date systemmodstamp;

    @Column(name = "speaker__r__hc_extend_id__c")
    private String speakerRHcExtendIdC;

    private Date createddate;

    private String sfid;

    @Column(name = "_hc_lastop")
    private String hcLastop;

    @Column(name = "_hc_err")
    private String hcErr;
}