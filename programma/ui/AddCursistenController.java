package programma.ui;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import programma.DB.CursistRepo;
import programma.domain.Cursist;
import programma.logic.Validatie;

import java.net.URL;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class AddCursistenController implements Initializable {
    NavbarController navbarController = new NavbarController();
    CursistRepo cursistRepo = new CursistRepo();

    @FXML
    private Button btnTerug;

    @FXML
    private TextField txtNaam;

    @FXML
    private TextField txtGeslacht;
    @FXML
    private ComboBox<String> comboGeslacht;
    @FXML
    private TextField txtAdres;

    @FXML
    private TextField txtLand;
    @FXML
    private TextField txtEmail;
    @FXML
    private TextField txtPostcode;
    @FXML
    private TextField txtStad;
    @FXML
    private DatePicker dtGeboortedatum;
    @FXML
    private Label txtSucces;

    @FXML
    private Button handleAddModule;

    @FXML
    void handleAddButton(ActionEvent event) throws ParseException {
        if(!Validatie.validatieEmail(txtEmail.getText())){
            txtSucces.setText("Email is onjuist");
            txtSucces.setTextFill(Color.RED);
            return;
        }
        try {
            if(!Validatie.validatieDatum(java.sql.Date.valueOf(dtGeboortedatum.getValue()))){
                txtSucces.setText("Geboortedatum is\n onjuist");
                txtSucces.setTextFill(Color.RED);
                return;
            }
        }catch (Exception e){
            txtSucces.setText("Selecteer een\n geboortedatum");
            txtSucces.setTextFill(Color.RED);
            return;
        }


        if(!Validatie.validatiePostcode(txtPostcode.getText())){
            txtSucces.setText("Postcode is onjuist");
            txtSucces.setTextFill(Color.RED);
            return;
        }

        if (txtEmail.getText() != null && txtNaam.getText() != null && dtGeboortedatum.getValue() != null && comboGeslacht.getValue() !=null
            && txtAdres.getText() != null && txtStad.getText()!= null && txtLand.getText() != null && txtPostcode.getText() != null) {
        try {
            cursistRepo.create(new Cursist(txtEmail.getText(), txtNaam.getText(), java.sql.Date.valueOf(dtGeboortedatum.getValue()), comboGeslacht.getValue(),
                    txtAdres.getText(), txtStad.getText(), txtLand.getText(), txtPostcode.getText()));
            txtSucces.setText("Cursist succesvol toegevoegd");
            txtSucces.setTextFill(Color.GREEN);
        }catch (Exception e){
            txtSucces.setText("Cursist toevoegen mislukt");
            txtSucces.setTextFill(Color.RED);
            return;
        }
            clearForm();
        }else {
            txtSucces.setText("Cursist toevoegen mislukt");
            txtSucces.setTextFill(Color.RED);
        }


    }

    void clearForm(){
        txtEmail.clear(); txtNaam.clear(); dtGeboortedatum.disarm();
                txtAdres.clear(); txtStad.clear(); txtLand.clear(); txtPostcode.clear();
                comboGeslacht.cancelEdit();
    }
    @FXML
    void handleTerug() throws Exception{
        NavbarController.terug = 1;
        Parent root = FXMLLoader.load(getClass().getResource("fxml/navbar.fxml"));
        Stage window = (Stage)btnTerug.getScene().getWindow();
        window.setScene(new Scene(root, 1370,600));
        window.setResizable(false);

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        comboGeslacht.setItems(FXCollections.observableArrayList("Man","Vrouw"));
    }
}
