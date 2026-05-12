package com.wipro.controller;


import java.util.List;

public interface UserDAO {

    void saveUser(UserModel user);

    List getUser();
}