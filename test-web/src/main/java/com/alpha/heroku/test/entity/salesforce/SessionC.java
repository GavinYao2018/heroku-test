package com.alpha.heroku.test.entity.salesforce;

import lombok.Data;

import java.util.Date;
import javax.persistence.*;

@Data
@Table(name = "salesforce.session__c")
public class SessionC {
    @Id
    private Integer id;

    private Date createddate;

    private Boolean isdeleted;

    private String name;

    private Date systemmodstamp;

    @Column(name = "description__c")
    private String descriptionC;

    @Column(name = "level__c")
    private String levelC;

    @Column(name = "session_date__c")
    private Date sessionDateC;

    private String sfid;

    @Column(name = "_hc_lastop")
    private String hcLastop;

    @Column(name = "_hc_err")
    private String hcErr;

    @Column(name = "hc_extend_id__c")
    private String hcExtendIdC;
}