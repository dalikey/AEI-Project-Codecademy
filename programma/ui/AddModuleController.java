package programma.ui;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import programma.DB.CursistRepo;
import programma.DB.ModuleRepo;
import programma.domain.Cursist;
import programma.domain.Module;
import programma.logic.Validatie;

import java.net.URL;
import java.sql.Date;
import java.text.ParseException;
import java.util.ResourceBundle;

public class AddModuleController implements Initializable {
    NavbarController navbarController = new NavbarController();
    ModuleRepo moduleRepo = new ModuleRepo();

    @FXML
    private Button btnTerug;

    @FXML
    private TextField txtTitel;

    @FXML
    private TextField txtEmail;

    @FXML
    private Button btnAdd;

    @FXML
    private TextField txtVersie;

    @FXML
    private Label txtSucces;

    @FXML
    private TextField txtNaam;

    @FXML
    private TextField txtBeschrijving;

    @FXML
    void handleAddButton(ActionEvent event) throws ParseException {
        if(!Validatie.validatieEmail(txtEmail.getText())){
            txtSucces.setText("Email is onjuist");
            txtSucces.setTextFill(Color.RED);
            return;
        }
        if (!txtEmail.getText().isEmpty() && !txtNaam.getText().isEmpty()
            && !txtBeschrijving.getText().isEmpty() && !txtTitel.getText().isEmpty() && !txtVersie.getText().isEmpty()) {
        try {
            moduleRepo.create(new Module(txtEmail.getText(), txtNaam.getText(),txtBeschrijving.getText(), txtVersie.getText(), txtTitel.getText()));
            txtSucces.setText("Module succesvol\n toegevoegd");
            txtSucces.setTextFill(Color.GREEN);
        }catch (Exception e){
            txtSucces.setText("Module\n toevoegen mislukt");
            txtSucces.setTextFill(Color.RED);
            return;
        }
            clearForm();
        }else {
            txtSucces.setText("Module toevoegen \nmislukt");
            txtSucces.setTextFill(Color.RED);
        }


    }

    void clearForm(){
        txtEmail.clear(); txtNaam.clear(); txtTitel.clear();
                txtVersie.clear(); txtBeschrijving.clear();
    }
    @FXML
    void handleTerug() throws Exception{
        NavbarController.terug = 4;
        Parent root = FXMLLoader.load(getClass().getResource("fxml/addCursus.fxml"));
        Stage window = (Stage)btnTerug.getScene().getWindow();
        window.setScene(new Scene(root, 1370,600));
        window.setResizable(false);

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }
}
