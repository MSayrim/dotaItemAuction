package com.example.dotaitemauction.Models;

public class LoginPojo {
    private Object id;
    private Object userName;


    public Object getId() {
        return id;
    }

    public void setUserName(Object userName) {
        this.userName = userName;
    }

    public Object getUserName() {
        return userName;
    }

    @Override
    public String toString() {
        return
                "LoginPojo{" +
                        "id = '" + id + '\'' +
                        ",userName = '" + userName + '\'' +
                        "}";
    }
}
