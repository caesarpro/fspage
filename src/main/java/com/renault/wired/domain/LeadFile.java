package com.renault.wired.domain;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "deadmessages")
public class LeadFile {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String leadFileId;

    @Version
    private Integer version;

    @Column(length = 10485760)
    private String body;

    private Date sentDate;

    private Date receiveDate;


    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLeadFileId() {
        return leadFileId;
    }

    public void setLeadFileId(String leadFileId) {
        this.leadFileId = leadFileId;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Date getSentDate() {
        return sentDate;
    }

    public void setSentDate(Date sentDate) {
        this.sentDate = sentDate;
    }

    public Date getReceiveDate() {
        return receiveDate;
    }

    public void setReceiveDate(Date receiveDate) {
        this.receiveDate = receiveDate;
    }
}
