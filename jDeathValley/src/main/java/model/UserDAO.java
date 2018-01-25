package model;

import java.sql.*;
import java.util.ArrayList;

/**
 * main methods:
 *
 * 1.getUserInformation
 *   get: id
 *   returns: user with name, sureName, accountId list, sum of accounts
 *
 * 2.getTheRichestUser
 *   returns: the richest user using max function
 *
 * */
public class UserDAO {
    private String jdbcURL;
    private String jdbcUsername;
    private String jdbcPassword;
    private Connection connection;

    public UserDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) {
        this.jdbcURL = jdbcURL;
        this.jdbcUsername = jdbcUsername;
        this.jdbcPassword = jdbcPassword;
    }
    public void connect() throws SQLException {
        if(connection == null || connection.isClosed()) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch(ClassNotFoundException e) {
                System.out.println("невозможно присоединиться к базе данных");
            }
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        }
    }
    public void disconnect() throws SQLException {
        if(connection != null || !connection.isClosed()) {
            connection.close();
        }
    }
    public User getUserInformation(int id) throws SQLException {
        User user = null;
        ArrayList<Integer> accountList = new ArrayList<Integer>(); //for accountIds of this.user
        int accountSum = 0; //sum of all accounts for this.user

        String sqlUser = "SELECT * FROM user WHERE userId=?";
        String sqlAccount = "SELECT * FROM account WHERE userId =?";
        connect();

        PreparedStatement userStatement = connection.prepareStatement(sqlUser);
        PreparedStatement accountStatement = connection.prepareStatement(sqlAccount);
        userStatement.setInt(1, id);
        accountStatement.setInt(1, id);
        ResultSet userResultSet = userStatement.executeQuery();
        ResultSet accountResultSet = accountStatement.executeQuery();

        while(accountResultSet.next()) { //цикл чтобы собрать все accountId в список, заодно суммируем account
            accountList.add(accountResultSet.getInt("accountId"));
            accountSum += accountResultSet.getInt("account");
        }
        if(userResultSet.next()) {
            String name = userResultSet.getString("name");
            String sureName = userResultSet.getString("sureName");
            user = new User(id, name, sureName, accountList, accountSum);
        }
        accountResultSet.close();
        accountStatement.close();
        userResultSet.close();
        userStatement.close();

        return user;
    }
    /**
     * Assuming that userId is an int number with SQL AutoIncrease (from 1 to N) (example of userId: 1, 2, 3, 4, .. N)
     * Assuming that there is only ONE user with maximum SUM of accounts, otherwise it should be a List of maxUsers
     * */
    public User getTheRichestUser() throws SQLException {
        User user = null;
        int maxId = 0; // the maximum userId in account table to know how many users we have to calculate (N)
        int maxSumAccounts = 0; // the maximum sum for i user
        int maxSumUserId = 0; // the richest user
        int buffer; // buffer for comparing with maxSumAccounts
        String sqlMaxUserIdInAccount = "SELECT * FROM account WHERE userId=(SELECT MAX(userId) FROM account)";//getting the max userId in account table
        System.out.println(sqlMaxUserIdInAccount);
        connect();

        PreparedStatement accountStatement = connection.prepareStatement(sqlMaxUserIdInAccount);
        ResultSet accountResultSet = accountStatement.executeQuery();
        if(accountResultSet.next()){
            maxId = accountResultSet.getInt("userId"); //got number of users (N)
//            System.out.println(maxId); //testdrive
        }

        String sqlAccount = "SELECT * FROM account WHERE userId=?";
        PreparedStatement accStatement = connection.prepareStatement(sqlAccount);
        for(int i = 1; i != maxId + 1; i++){ // searching through "account" table with userId from 1 to N
            buffer = 0;
            accStatement.setInt(1, i);
            ResultSet resultSet = accStatement.executeQuery();
            while(resultSet.next()) { // sum all account of user: i
                buffer += resultSet.getInt("account");
            }
            if(buffer > maxSumAccounts){ // compare of sum of account for user: i with previous maximum
                maxSumAccounts = buffer;
                maxSumUserId = i;
//                System.out.println(maxSumAccounts); //testdrive
            }
            resultSet.close();
        }
//        System.out.println("this is out user: " + maxSumUserId); //testdrive
        accountStatement.close();
        accountResultSet.close();
        accStatement.close();

        user = getUserInformation(maxSumUserId); //bingo!
        return user;
    }

    /**testdrive: */
    /*public static void main(String[] args) throws SQLException {
        String jdbcURL = "jdbc:mysql://localhost:3306/UserBankList";
        String jdbcUsername = "root";
        String jdbcPassword = "root";
        UserDAO userDAO = new UserDAO(jdbcURL, jdbcUsername, jdbcPassword);
        User user = userDAO.getTheRichestUser();
        System.out.println("get the name :" + user.getName());
    }*/



}
