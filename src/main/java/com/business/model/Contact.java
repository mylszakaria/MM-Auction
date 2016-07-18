package com.business.model;

/**
 * Created by zakaria on 18/07/2016.
 */
public class Contact {

    private User user;
    private String address;
    private String companyName;
    private String email;
    private String cin;
    private String phoneNum;

    public Contact(User user, String address, String companyName, String email, String cin, String phoneNum) {
        this.user = user;
        this.address = address;
        this.companyName = companyName;
        this.email = email;
        this.cin = cin;
        this.phoneNum = phoneNum;
    }

    public Contact() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
