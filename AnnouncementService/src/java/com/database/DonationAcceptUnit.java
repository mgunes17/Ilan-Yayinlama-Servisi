package com.database;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="donation_accept_unit")

public class DonationAcceptUnit implements Serializable{
    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    
    @Column(name="unit_name", nullable=false, unique=true)
    private String unitName;
    
    @Column(name="balance", nullable=false, unique=false)
    private int balance;

    /*@OneToMany(fetch=FetchType.EAGER)
    @JoinColumn(name="id")
    private List<DauUser> users = new ArrayList<>();*/
    
    @OneToMany(fetch=FetchType.EAGER)
    @JoinColumn(name="id")
    private List<BankAccountInfo> bankAccount = new ArrayList<>();

    public List<BankAccountInfo> getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(List<BankAccountInfo> bankAccount) {
        this.bankAccount = bankAccount;
    }

   /* public List<DauUser> getUsers() {
        return users;
    }

    public void setUsers(List<DauUser> users) {
        this.users = users;
    }*/
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
