package programma.ui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import programma.DB.*;
import programma.domain.Certificaat;
import programma.domain.Cursus;
import programma.domain.Inschrijving;
import programma.domain.Module;

import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.util.ResourceBundle;

public class AddInschrijvingController implements Initializable {
    long millis=System.currentTimeMillis();
    java.sql.Date date=new java.sql.Date(millis);
    NavbarController navbarController = new NavbarController();
    CursusRepo cursusRepo = new CursusRepo();
    InschrijvingRepo  inschrijvingRepo = new InschrijvingRepo();
    CursistRepo cursistRepo = new CursistRepo();
    CertificaatRepo certificaatRepo = new CertificaatRepo();

    @FXML
    private Button btnTerug;

    @FXML
    private TextField txtEmail;

    @FXML
    private Button btnAdd;

    @FXML
    private Label txtSucces;

    @FXML
    private ChoiceBox<String> cbCursus;

    @FXML
    void handleAddButton(ActionEvent event) throws ParseException {
        if(cursistRepo.getByEmailValidation(txtEmail.getText())){
            Alert alert = new Alert(Alert.AlertType.ERROR, "Er bestaat geen cursist met deze email!", ButtonType.OK);

            alert.showAndWait();

            return;
        }
        if(cbCursus.getValue() == null){
            txtSucces.setText("Inschrijving toevoegen mislukt, gelieve een cursus te kiezen");
            txtSucces.setTextFill(Color.RED);
            return;
        }
        try {
            inschrijvingRepo.create(new Inschrijving(cbCursus.getValue(),txtEmail.getText(),date));
            certificaatRepo.create(new Certificaat(0,"-",txtEmail.getText(),cbCursus.getValue(),cursistRepo.getCursistGeslacht(txtEmail.getText())));
            txtSucces.setText("Inschrijving succesvol toegevoegd");
            txtSucces.setTextFill(Color.GREEN);
        } catch (Exception e) {
            txtSucces.setText("Inschrijving toevoegen mislukt");
            txtSucces.setTextFill(Color.RED);
            return;
        }
        clearForm();

    }

    void clearForm(){
        txtEmail.clear();
    }
    @FXML
    void handleTerug() throws Exception{
        NavbarController.terug = 5;
        Parent root = FXMLLoader.load(getClass().getResource("fxml/navbar.fxml"));
        Stage window = (Stage)btnTerug.getScene().getWindow();
        window.setScene(new Scene(root, 1370,600));
        window.setResizable(false);

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //set checkboxes
        cbCursus.setItems(FXCollections.observableArrayList(cursusRepo.getTitels()));

    }
}
