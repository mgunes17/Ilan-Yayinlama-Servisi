package com.database;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author must
 */
@Entity
@Table(name="announcement_state")
public class AnnouncementState implements Serializable {
    @Id
    @Column(name="id")
    private int id;
    
    @Column(name="title", nullable=false)
    private String title;
    
    public AnnouncementState(){}

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
}
