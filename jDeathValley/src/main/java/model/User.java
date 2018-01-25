package model;

import java.util.ArrayList;

/**
 * The model of user.
 *since there is no realtions between two tables in our DB (the picture of tables doesn't have arrows)
 *this relation will be created in User-model, through common variable: userId
 *
 *most of getters and setters unused
 *
 * */
public class User {
    private int userId;
    private String name;
    private String sureName;
    private int accountId;
    private int accountSum;
    ArrayList<Integer> accountList = new ArrayList<Integer>();

    public User(int id, String name, String sureName, ArrayList<Integer> arrayOfAccounts, int accountSum){ //
        this.userId = id;
        this.name = name;
        this.sureName = sureName;
        this.accountList = arrayOfAccounts;
        this.accountSum = accountSum;
    }

    public ArrayList<Integer> getAccountList() {
        return accountList;
    }

    public void setAccountList(ArrayList<Integer> accountList) {
        this.accountList = accountList;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSureName() {
        return sureName;
    }

    public void setSureName(String sureName) {
        this.sureName = sureName;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public int getAccountSum() {
        return accountSum;
    }

    public void setAccountSum(int account) {
        this.accountSum = account;
    }
}
