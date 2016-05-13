package com.database;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="currency")
public class Currency implements Serializable {
    @Id
    @Column(name="id", nullable=false)
    private int id;
    @Column(name="title", nullable=false)
    private String title;

    public Currency(){}
    
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
