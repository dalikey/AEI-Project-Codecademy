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
import programma.DB.WebcastRepo;
import programma.domain.Cursist;
import programma.domain.Webcast;

import java.net.URL;
import java.sql.Date;
import java.text.ParseException;
import java.util.ResourceBundle;

public class UpdateWebcastsController implements Initializable {
    NavbarController navbarController = new NavbarController();
    WebcastRepo webcastRepo = new WebcastRepo();
    static int indexCursist = 0;
    long millis=System.currentTimeMillis();
    java.sql.Date date=new java.sql.Date(millis);
    static Webcast cursistToUpdate = new Webcast(null,null,0,null,null,null,null);

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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        txtSpreker.setText(webcastRepo.getWebast(indexCursist).getSprekerNaam());
        txtBeschrijving.setText(webcastRepo.getWebast(indexCursist).getBeschrijving());
        txtOrganisatie.setText(webcastRepo.getWebast(indexCursist).getOrganisatieNaam());
        txtTijdsduur.setText(String.valueOf(webcastRepo.getWebast(indexCursist).getTijdsduur()));
        txtTitel.setText(webcastRepo.getWebast(indexCursist).getTitel());
        txtUrl.setText(webcastRepo.getWebast(indexCursist).getUrl());






    }
    @FXML
    void handleAddButton(ActionEvent event) throws ParseException {

        if (txtOrganisatie.getText() != null && txtSpreker.getText() != null && txtTitel.getText() != null && txtTijdsduur.getText() !=null
                && txtUrl.getText() != null) {
            try {
                webcastRepo.update(indexCursist, new Webcast(txtSpreker.getText(),txtOrganisatie.getText(),Integer.valueOf(txtTijdsduur.getText()), date,txtUrl.getText(),txtTitel.getText(),txtBeschrijving.getText()));

            }catch (Exception e){
                txtSucces.setText("Webcast update mislukt");
                txtSucces.setTextFill(Color.RED);
                return;
            }
        }
        txtSucces.setText("Webcast succesvol geupdate");
        txtSucces.setTextFill(Color.GREEN);

    }

    @FXML
    void handleTerug() throws Exception{
        NavbarController.terug = 2;
        Parent root = FXMLLoader.load(getClass().getResource("fxml/navbar.fxml"));
        Stage window = (Stage)btnTerug.getScene().getWindow();
        window.setScene(new Scene(root, 1370,600));
        window.setResizable(false);

    }

}
