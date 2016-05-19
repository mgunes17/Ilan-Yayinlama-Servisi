package com.database;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="announcement_packet")
public class AnnouncementPacket implements Serializable {
    @Id
    @Column(name="packet_id")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int packetId;
    @Column(name="title")
    private String title;
    @Column(name="announcement_count", nullable=false)
    private int announcementCount;
    @Column(name="price", nullable=false)
    private int price;
    @Column(name="last_date_used", nullable=false)
    private Timestamp lastDateUsed;
    @Column(name="active_time", nullable=false)
    private int activeTime;
    @Column(name="condition", nullable=false)
    private String condition;
    
    @ManyToOne(cascade= CascadeType.ALL)
    @JoinColumn(name="currency", referencedColumnName="id")
    private Currency currency;
    
    @ManyToOne(cascade= CascadeType.ALL)
    @JoinColumn(name="donate_accept_unit", referencedColumnName="id")
    private DonationAcceptUnit donateAcceptUnit;

    public AnnouncementPacket(){
        
    }
    
    public int getPacketId() {
        return packetId;
    }

    public void setPacketId(int packetId) {
        this.packetId = packetId;
    }

    public int getAnnouncementCount() {
        return announcementCount;
    }

    public void setAnnouncementCount(int announcementCount) {
        this.announcementCount = announcementCount;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Timestamp getLastDateUsed() {
        return lastDateUsed;
    }

    public void setLastDateUsed(Timestamp lastDateUsed) {
        this.lastDateUsed = lastDateUsed;
    }

    public int getActiveTime() {
        return activeTime;
    }

    public void setActiveTime(int activeTime) {
        this.activeTime = activeTime;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public DonationAcceptUnit getDonateAcceptUnit() {
        return donateAcceptUnit;
    }

    public void setDonateAcceptUnit(DonationAcceptUnit donateAcceptUnit) {
        this.donateAcceptUnit = donateAcceptUnit;
    }
    
    public String getTitle() {
        return condition;
    }

    public void setTitle(String condition) {
        this.condition = condition;
    }
}
