package com.qinqiufeng.javafx.controller;

import com.qinqiufeng.javafx.switchStage.SwitchStage;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import org.springframework.stereotype.Component;


@Component
public class IndexController {

    public Button returnButton;
    public AnchorPane indexPane;

    public void returnStage(ActionEvent actionEvent){
        SwitchStage.goStage("login", indexPane.getScene().getWindow());
    }
}
