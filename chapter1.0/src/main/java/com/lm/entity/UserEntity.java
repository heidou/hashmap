package com.lm.entity;

/**
 * Created by Administrator on 2016/5/6.
 */
public class UserEntity {
      private String userId;
      private String userName;
    private String password;
    private String sex;

    public String getUserId(){
          return userId;
    }
    public void setUserId(String userId){
        this.userId = userId;
    }
    public String getUserName(){
        return userName;
    }
    public void setUserName(String userName){
        this.userName = userName;
    }
    public String getPassword(){
        return password;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public String getSex(){
        return sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString(){
        return "UserEntity [userId="+ userId + " , userName=" + userName + " , password=" +password + " , sex=" + sex +"]";

    }

}