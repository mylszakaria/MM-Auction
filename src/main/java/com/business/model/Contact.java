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
    @Column
    private String email;
    @Column
    private String cin;
    @Column
    private String phoneNum;

    public Contact( String address, String companyName, String email, String cin, String phoneNum) {

        this.address = address;
        this.companyName = companyName;
        this.email = email;
        this.cin = cin;
        this.phoneNum = phoneNum;
    }

    public Contact() {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
