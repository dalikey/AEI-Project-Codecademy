package programma.ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class MainMenuController {

    @FXML
    private Button btnMainCertificaten;

    @FXML
    private Button btnMainWebcasts;

    @FXML
    private Button btnMainCursussen;

    @FXML
    private Button btnMainCursisten;
    @FXML
    private Button btnMainInschrijvingen;

    @FXML
    void btnCertificaten() throws IOException {
        NavbarController.terug = 4;
        Parent root = FXMLLoader.load(getClass().getResource("fxml/navbar.fxml"));
        Stage window = (Stage)btnMainCertificaten.getScene().getWindow();
        window.setScene(new Scene(root, 1370,600));
        window.setResizable(false);
    }
    @FXML
    void btnInschrijvingen() throws IOException {
        NavbarController.terug = 5;
        Parent root = FXMLLoader.load(getClass().getResource("fxml/navbar.fxml"));
        Stage window = (Stage)btnMainInschrijvingen.getScene().getWindow();
        window.setScene(new Scene(root, 1370,600));
        window.setResizable(false);
    }
    @FXML
    void btnCursisten(ActionEvent event) throws IOException {
        NavbarController.terug = 1;
        Parent root = FXMLLoader.load(getClass().getResource("fxml/navbar.fxml"));
        Stage window = (Stage)btnMainCursisten.getScene().getWindow();
        window.setScene(new Scene(root, 1370,600));
        window.setResizable(false);
    }

    @FXML
    void btnCursussen(ActionEvent event) throws IOException{
        NavbarController.terug = 3;
        Parent root = FXMLLoader.load(getClass().getResource("fxml/navbar.fxml"));
        Stage window = (Stage)btnMainCursussen.getScene().getWindow();
        window.setScene(new Scene(root, 1370,600));
        window.setResizable(false);
    }

    @FXML
    void btnWebcasts(ActionEvent event) throws IOException {
        NavbarController.terug = 2;
        Parent root = FXMLLoader.load(getClass().getResource("fxml/navbar.fxml"));
        Stage window = (Stage)btnMainWebcasts.getScene().getWindow();
        window.setScene(new Scene(root, 1370,600));
        window.setResizable(false);
    }
}
