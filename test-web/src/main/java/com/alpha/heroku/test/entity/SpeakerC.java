package com.alpha.heroku.test.entity;

import lombok.Data;

import java.util.Date;
import javax.persistence.*;

@Data
@Table(name = "speaker__c", schema = "salesforce")
public class SpeakerC {
    @Id
    private Integer id;

    @Column(name = "email__c")
    private String emailC;

    @Column(name = "first_name__c")
    private String firstNameC;

    private String name;

    @Column(name = "last_name__c")
    private String lastNameC;

    private Boolean isdeleted;

    private Date systemmodstamp;

    private Date createddate;

    @Column(name = "bio__c")
    private String bioC;

    @Column(name = "picture_path__c")
    private String picturePathC;

    private String sfid;

    @Column(name = "_hc_lastop")
    private String hcLastop;

    @Column(name = "_hc_err")
    private String hcErr;
}