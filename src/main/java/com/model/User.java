package com.model;

import java.util.List;

/**
 * Created by zakaria on 18/07/2016.
 */

public class User {

    private int userId;
    private String userFirstName;
    private String userLastName;
    private String userLogin;
    private String userPassword;
    private String userAddress;
    private String userCompanyName;
    private String userRole;
    private String userEmail;
    private String userCin;
    private String userPhoneNum;
    private List<Transaction> transHistory;
    private List<Compensation> compHistory;
    private Cart cart;

    public User(int userId, String userFirstName, String userLastName, String userLogin, String userPassword, String userAddress, String userCompanyName, String userRole, String userEmail, String userCin, String userPhoneNum, List<Transaction> transHistory, List<Compensation> compHistory, Cart cart) {
        this.userId = userId;
        this.userFirstName = userFirstName;
        this.userLastName = userLastName;
        this.userLogin = userLogin;
        this.userPassword = userPassword;
        this.userAddress = userAddress;
        this.userCompanyName = userCompanyName;
        this.userRole = userRole;
        this.userEmail = userEmail;
        this.userCin = userCin;
        this.userPhoneNum = userPhoneNum;
        this.transHistory = transHistory;
        this.compHistory = compHistory;
        this.cart = cart;
    }
}
