package com.business.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Created by zakaria on 18/07/2016.
 */

@Embeddable
public class Contact {

    @Column
    private String address;
    @Column
    private String companyName;
    @Column(unique = true , nullable = false)
    private String cin;
    @Column
    private String phoneNum;

    public Contact() {
        super();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }
}
