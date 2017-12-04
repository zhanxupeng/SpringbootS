package com.mybatis.test.model;

import java.util.Date;

/**
 * Created by 占大帅 on 2017/11/26.
 */
public class User {
    private int id;
    private String username;
    private String password;
    private boolean delete;
    private Date createDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isDelete() {
        return delete;
    }

    public void setDelete(boolean delete) {
        this.delete = delete;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String toString() {
        return String.format("[id=%s,username=%s,password=%s,delete=%s,createDate=%s]", id, username, password, delete, createDate);
    }
}
