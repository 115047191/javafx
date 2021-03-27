package com.qinqiufeng.javafx.controller;

import com.qinqiufeng.javafx.service.LoginService;
import com.qinqiufeng.javafx.switchStage.SwitchStage;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.IOException;

@Component
public class LoginController {
    @Resource
    public LoginService loginService;

    public GridPane loginPane;

    public TextField username;

    public PasswordField password;

    public Button login;

    public Label errorLabe;



    public void loginButton(ActionEvent actionEvent){
        if (loginService.startLogin(username.getText(),password.getText())){
            mainStag();
        }else {
            errorStag();
        }
    }

    private void mainStag() {
        SwitchStage.goStage("index", loginPane.getScene().getWindow());

    }

    private void errorStag() {
        errorLabe.setText("用户名或密码错误");
    }
}
