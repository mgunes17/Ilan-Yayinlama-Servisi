package com.database;

import java.io.Serializable;
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
@Table(name="bank_account_info")
public class BankAccountInfo implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id")
    private int id;
    
    @Column(name="bank_name", nullable=false)
    private String bankName;
    
    @Column(name="branch_bank_name", nullable=false)
    private String branchBankName;
    
    @Column(name="bank_account_number", nullable=false)
    private String bankAccountNumber;
    
    @Column(name="iban", unique=true)
    private String iban;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="currency", referencedColumnName="id")
    private Currency currency;

    @ManyToOne(cascade= CascadeType.ALL)
    @JoinColumn(name="unit_id", referencedColumnName="id")
    private DonationAcceptUnit unit;

    public DonationAcceptUnit getUnit() {
        return unit;
    }

    public void setUnit(DonationAcceptUnit unit) {
        this.unit = unit;
    }
    
    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBranchBankName() {
        return branchBankName;
    }

    public void setBranchBankName(String branchBankName) {
        this.branchBankName = branchBankName;
    }

    public String getBankAccountNumber() {
        return bankAccountNumber;
    }

    public void setBankAccountNumber(String bankAccountNumber) {
        this.bankAccountNumber = bankAccountNumber;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }
    
}
