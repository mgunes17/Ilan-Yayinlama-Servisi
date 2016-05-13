
package com.database;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@PrimaryKeyJoinColumn(name="user_name")
@Table(name="dau_user")
public class DauUser extends Users {

    @ManyToOne(cascade= CascadeType.ALL)
    @JoinColumn(name="unit_id", referencedColumnName="id")
    private DonationAcceptUnit unit;

    public DonationAcceptUnit getUnit() {
        return unit;
    }

    public void setUnit(DonationAcceptUnit unit) {
        this.unit = unit;
    }
 
}
