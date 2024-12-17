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
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import org.w3c.dom.ls.LSOutput;
import programma.DB.CursistRepo;
import programma.DB.WebcastRepo;
import programma.domain.Cursist;
import programma.domain.Webcast;
import programma.logic.Validatie;

import java.net.URL;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.ResourceBundle;

public class AddWebcastController implements Initializable {
    long millis=System.currentTimeMillis();
    java.sql.Date date=new java.sql.Date(millis);
    NavbarController navbarController = new NavbarController();
    WebcastRepo webcastRepo = new WebcastRepo();

    @FXML
    private Button btnTerug;

    @FXML
    private TextField txtTitel;

    @FXML
    private TextField txtTijdsduur;

    @FXML
    private Button btnAdd;

    @FXML
    private TextField txtSpreker;

    @FXML
    private TextField txtUrl;

    @FXML
    private Label txtSucces;

    @FXML
    private TextField txtOrganisatie;
    @FXML
    private TextArea txtBeschrijving;



    @FXML
    void handleAddButton(ActionEvent event) throws ParseException {int beoordeling;
        int tijdsduur;
        try {
            tijdsduur = Integer.parseInt(txtTijdsduur.getText());
        }catch (Exception e){
            txtSucces.setText("Tijdsduur is geen getal!");
            txtSucces.setTextFill(Color.RED);
            return;
        }

        if(!Validatie.validatieUrl(txtUrl.getText())){
            txtSucces.setText("Url onjuist");
            txtSucces.setTextFill(Color.RED);
            return;
        }
        if (txtOrganisatie.getText() != null && txtSpreker.getText() != null && txtTitel.getText() != null && txtTijdsduur.getText() !=null
            && txtUrl.getText() != null) {
            try {
                webcastRepo.create(new Webcast(txtSpreker.getText(),txtOrganisatie.getText(),tijdsduur, date,txtUrl.getText(),txtTitel.getText(),txtBeschrijving.getText()));

            }catch (Exception e){
                txtSucces.setText("Webcast toevoegen mislukt");
                txtSucces.setTextFill(Color.RED);
                return;
            }
            clearForm();
        }
        txtSucces.setText("Webcast succesvol toegevoegd");
        txtSucces.setTextFill(Color.GREEN);

    }

    void clearForm(){
        txtBeschrijving.clear(); txtTitel.clear();
                txtTijdsduur.clear(); txtOrganisatie.clear(); txtUrl.clear();
                txtSpreker.cancelEdit();
    }
    @FXML
    void handleTerug() throws Exception{
        NavbarController.terug = 2;
        Parent root = FXMLLoader.load(getClass().getResource("fxml/navbar.fxml"));
        Stage window = (Stage)btnTerug.getScene().getWindow();
        window.setScene(new Scene(root, 1370,600));
        window.setResizable(false);

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }
}
