package com.qinqiufeng.javafx.switchStage;

import com.qinqiufeng.javafx.JavafxApplication;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.Window;
import java.io.IOException;
import java.lang.reflect.Field;


public class SwitchStage {

    public static void goStage(String name, Window window){
        Stage stage = (Stage)window;
        Object bean = JavafxApplication.configurableApplicationContext.getBean(name+"Controller");
        try {
            Field field = bean.getClass().getField(name +"Pane");
            Pane pane = (Pane)field.get(bean);
            if (pane != null){
                stage.setScene(pane.getScene());
            }else {
                String[] split = name.split("", 2);
                stage.setScene(new Scene(JavafxApplication.loadFxml("/"+split[0].toUpperCase()+split[1]+".fxml").load()));
            }

        } catch (NoSuchFieldException | IllegalAccessException | IOException e) {
            e.printStackTrace();
        }
    }

}
