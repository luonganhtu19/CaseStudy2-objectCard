package model;

import java.util.ArrayList;
import java.util.List;

public class Account {
    private int idAccount;
    private String userName;
    private String password;
    private String state;

    public Account(){}
    public Account(int idAccount, String userName,String password,String state){
        this.idAccount=idAccount;
        this.userName=userName;
        this.password=password;
        this.state=state;
    };
    public Account(String userName,String password){
        this.userName=userName;
        this.password=password;
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(int idAccount) {
        this.idAccount = idAccount;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return  ""+idAccount + "," + userName + "," + password + ","+ state ;
    }
}
