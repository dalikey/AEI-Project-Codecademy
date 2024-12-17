package programma.ui;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import programma.DB.CursistRepo;
import programma.domain.Cursist;

import java.net.URL;
import java.sql.Date;
import java.text.ParseException;
import java.util.ResourceBundle;

public class UpdateCursistenController implements Initializable {
    NavbarController navbarController = new NavbarController();
    CursistRepo cursistRepo = new CursistRepo();
    static int indexCursist = 0;
    static Cursist cursistToUpdate = new Cursist(null,null,null,null,null,null,null,null);

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
    private Button btnAdd;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        comboGeslacht.setItems(FXCollections.observableArrayList("Man","Vrouw"));
        txtNaam.setText(cursistRepo.getCursist(indexCursist).getNaam());
        txtAdres.setText(cursistRepo.getCursist(indexCursist).getAdres());
        txtEmail.setText(cursistRepo.getCursist(indexCursist).getEmail());
        dtGeboortedatum.setValue(cursistRepo.getCursist(indexCursist).getGeboorteDatum().toLocalDate());
        txtStad.setText(cursistRepo.getCursist(indexCursist).getStad());
        txtLand.setText(cursistRepo.getCursist(indexCursist).getLand());
        txtPostcode.setText(cursistRepo.getCursist(indexCursist).getPostcode());
        comboGeslacht.setValue(cursistRepo.getCursist(indexCursist).getGeslacht());




    }
    @FXML
    void handleAddButton(ActionEvent event) throws ParseException {
        if (txtEmail.getText() != null && txtNaam.getText() != null && dtGeboortedatum.getValue() != null && comboGeslacht.getValue() !=null
            && txtAdres.getText() != null && txtStad.getText()!= null && txtLand.getText() != null && txtPostcode.getText() != null) {
            cursistRepo.update(indexCursist,new Cursist(txtEmail.getText(), txtNaam.getText(), Date.valueOf(dtGeboortedatum.getValue()), comboGeslacht.getValue(),
                    txtAdres.getText(), txtStad.getText(), txtLand.getText(), txtPostcode.getText()));
        }
        txtSucces.setText("Cursist succesvol\nupdated!");
    }

    @FXML
    void handleTerug() throws Exception{
        NavbarController.terug = 1;
        Parent root = FXMLLoader.load(getClass().getResource("fxml/navbar.fxml"));
        Stage window = (Stage)btnTerug.getScene().getWindow();
        window.setScene(new Scene(root, 1370,600));
        window.setResizable(false);

    }

}
