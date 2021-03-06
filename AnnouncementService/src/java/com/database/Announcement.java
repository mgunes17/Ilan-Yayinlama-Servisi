package com.database;

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
@Table(name="announcement")
public class Announcement {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    @Column(name="title")
    private String title;
    @Column(name="brief", nullable=false)
    private String brief;
    @Column(name="content", nullable=false)
    private String content;
    @Column(name="number_of_page_views")
    private int numberOfPageViews;
    
    @ManyToOne(cascade= CascadeType.ALL)
    @JoinColumn(name="state", referencedColumnName="id")
    private AnnouncementState state; // ilan durumu oluşturulunca pasif, şikayette beklenen, aktif vs
     
    @ManyToOne(cascade= CascadeType.ALL)
    @JoinColumn(name="owner_company", referencedColumnName="user_name")
    private Company ownerCompany; 
    
    
    @ManyToOne(cascade= CascadeType.ALL)
    @JoinColumn(name="owner_packet", referencedColumnName="packet_id")
    private AnnouncementPacket ownerPacket;
    
    
    @Column(name="announcement_type", nullable=false)
    private int announcementType; //staj, freelance, part time, full time
    
    public Announcement(){}

    public int getAnnouncementType() {
        return announcementType;
    }

    public void setAnnouncementType(int announcementType) {
        this.announcementType = announcementType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getNumberOfPageViews() {
        return numberOfPageViews;
    }

    public void setNumberOfPageViews(int numberOfPageViews) {
        this.numberOfPageViews = numberOfPageViews;
    }

    public AnnouncementState getState() {
        return state;
    }

    public void setState(AnnouncementState state) {
        this.state = state;
    }

    public Company getOwnerCompany() {
        return ownerCompany;
    }

    public void setOwnerCompany(Company ownerCompany) {
        this.ownerCompany = ownerCompany;
    }

    public AnnouncementPacket getOwnerPacket() {
        return ownerPacket;
    }

    public void setOwnerPacket(AnnouncementPacket ownerPacket) {
        this.ownerPacket = ownerPacket;
    }
}
