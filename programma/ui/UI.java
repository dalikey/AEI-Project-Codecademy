package programma.ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * schermen:
 * cursus materiaal (je kan hier: toevoegen/veranderen)
 * cursisten (je kan hier: toevoegen/veranderen)
 * overzicht voor: cursus, webcast, cursistenaccount
 */

public class UI extends Application {
    @Override
    public void start(Stage window) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("fxml/navbar.fxml"));
        window.setTitle("Codeacademy");
        window.setScene((new Scene(root, 1370, 600)));
        window.setResizable(false);
        window.show();
    }


    public static void main(String[] args) {
        launch(UI.class);
    }
}
