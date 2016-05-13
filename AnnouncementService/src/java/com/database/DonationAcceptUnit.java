package com.database;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="donation_accept_unit")
@PrimaryKeyJoinColumn(name="user_name")

public class DonationAcceptUnit extends Users{
    @Column(name="unit_name", nullable=false)
    private String unitName;
    @Column(name="balance")
    private int balance;

    public DonationAcceptUnit(){
        
    }
    
    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}
