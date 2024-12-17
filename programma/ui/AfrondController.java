package programma.ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import programma.DB.CertificaatRepo;
import programma.DB.WebcastRepo;
import programma.domain.Certificaat;
import programma.domain.Webcast;
import programma.logic.Validatie;

import java.net.URL;
import java.sql.Date;
import java.text.ParseException;
import java.util.ResourceBundle;

public class AfrondController implements Initializable {
    NavbarController navbarController = new NavbarController();
    CertificaatRepo certificaatRepo = new CertificaatRepo();
    Validatie validatie = new Validatie();

    static int indexCertificaat = 0;
    long millis=System.currentTimeMillis();

    @FXML
    private Button btnTerug;
    @FXML
    private Label lblAfrond;

    @FXML
    private TextField txtBeoordeling;



    @FXML
    private TextField txtOndertekenaar;

    @FXML
    private Label txtSucces;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
    @FXML
    void handleAddButton(ActionEvent event) throws ParseException {
        int beoordeling;
        try {
             beoordeling = Integer.parseInt(txtBeoordeling.getText());
        }catch (Exception e){
            txtSucces.setText("Beoordeling is geen getal!");
            txtSucces.setTextFill(Color.RED);
            return;
        }
        if (!validatie.gradeValidator(beoordeling)){
            txtSucces.setText("Beoordeling is tussen 1 - 10!");
            txtSucces.setTextFill(Color.RED);
            return;
        }

        if (txtBeoordeling.getText() != null && txtOndertekenaar.getText() != null) {
            try {
                certificaatRepo.update(indexCertificaat, new Certificaat(beoordeling,txtOndertekenaar.getText()));

            }catch (Exception e){
                txtSucces.setText("Afronden mislukt");
                txtSucces.setTextFill(Color.RED);
                return;
            }
        }
        txtSucces.setText("Succesvol afgerond");
        txtSucces.setTextFill(Color.GREEN);

    }

    @FXML
    void handleTerug() throws Exception{
        NavbarController.terug = 4;
        Parent root = FXMLLoader.load(getClass().getResource("fxml/navbar.fxml"));
        Stage window = (Stage)btnTerug.getScene().getWindow();
        window.setScene(new Scene(root, 1370,600));
        window.setResizable(false);

    }

}
