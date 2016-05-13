package com.database;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user_type")
public class UserType {
    @Id
    private int type_no;
    @Column
    private String type_name;
    @Column
    private String main_page;

    public int getType_no() {
        return type_no;
    }

    public void setType_no(int type_no) {
        this.type_no = type_no;
    }

    public String getType_name() {
        return type_name;
    }

    public void setType_name(String type_name) {
        this.type_name = type_name;
    }

    public String getMain_page() {
        return main_page;
    }

    public void setMain_page(String main_page) {
        this.main_page = main_page;
    }
}
