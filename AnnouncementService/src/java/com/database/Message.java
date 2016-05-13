package com.database;

import java.io.Serializable;
import java.sql.Date;
import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="message")
public class Message implements Serializable {
    @Id
    @Column(name="message_no")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int messageNo;
    
    @Column(name="message_title", nullable=false)
    private String messageTitle;
    
    @Column(name="message_body", nullable=false)
    private String messageBody;
    
    @Column(name="sender_email_address", nullable=false)
    private String mailAddress;
    
    @Column(name="sender_ip_address", nullable=false)
    private String IPAddress;
    
    @Column(name="is_read", nullable=false)
    private boolean isRead;
    
    @Column(name="date_time", nullable=false)
    private Calendar dateTime;

    public Calendar getDateTime() {
        return dateTime;
    }

    public void setDateTime(Calendar dateTime) {
        this.dateTime = dateTime;
    }

    public boolean isIsRead() {
        return isRead;
    }

    public void setIsRead(boolean isRead) {
        this.isRead = isRead;
    }

    public int getMessageNo() {
        return messageNo;
    }

    public void setMessageNo(int messageNo) {
        this.messageNo = messageNo;
    }

    public String getMessageTitle() {
        return messageTitle;
    }

    public void setMessageTitle(String messageTitle) {
        this.messageTitle = messageTitle;
    }

    public String getMessageBody() {
        return messageBody;
    }

    public void setMessageBody(String messageBody) {
        this.messageBody = messageBody;
    }

    public String getMailAddress() {
        return mailAddress;
    }

    public void setMailAddress(String emailAddress) {
        this.mailAddress = emailAddress;
    }

    public String getIPAddress() {
        return IPAddress;
    }

    public void setIPAddress(String IPAddress) {
        this.IPAddress = IPAddress;
    }
}
