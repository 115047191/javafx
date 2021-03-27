package com.qinqiufeng.javafx.service.impl;

import com.qinqiufeng.javafx.service.LoginService;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {


    @Override
    public boolean startLogin(String username, String passwoerd){
        if (username.equals("") && passwoerd.equals("")){
            return true;
        }
        try {
            if ("admin".equals(username) &&"admin".equals(passwoerd)){
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return false;
    }
}
