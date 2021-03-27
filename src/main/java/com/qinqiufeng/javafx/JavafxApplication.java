package com.qinqiufeng.javafx;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class JavafxApplication extends Application {
    public static ApplicationContext configurableApplicationContext;

    public static FXMLLoader loadFxml(String fxmlPath){
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(JavafxApplication.class.getResource(fxmlPath));
        fxmlLoader.setControllerFactory(configurableApplicationContext::getBean);
        return fxmlLoader;
    }

    public static void main(String[] args) {
        configurableApplicationContext = SpringApplication.run(JavafxApplication.class, args);
        Application.launch(JavafxApplication.class, args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
       primaryStage.setScene(new Scene(loadFxml("/Login.fxml").load()));
        primaryStage.setResizable(false);
        primaryStage.show();

    }


}
