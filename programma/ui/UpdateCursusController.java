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
import programma.DB.CursusRepo;
import programma.DB.ModuleRepo;
import programma.DB.WebcastRepo;
import programma.domain.Cursist;
import programma.domain.Cursus;

import java.net.URL;
import java.sql.Date;
import java.text.ParseException;
import java.util.ResourceBundle;

public class UpdateCursusController implements Initializable {
    NavbarController navbarController = new NavbarController();
    CursusRepo cursusRepo = new CursusRepo();
    WebcastRepo webcastRepo = new WebcastRepo();
    ModuleRepo moduleRepo = new ModuleRepo();

    static int indexCursus = 0;

    @FXML
    private Button btnTerug;

    @FXML
    private TextField txtCursus;

    @FXML
    private Button btnAdd;

    @FXML
    private TextField txtOnderwerp;

    @FXML
    private Label txtSucces;

    @FXML
    private TextField txtIntroductie;

    @FXML
    private ChoiceBox<String> cbNiveau;

    @FXML
    private ChoiceBox<String> cbWebcast;

    @FXML
    private ChoiceBox<String> cbModule;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cbNiveau.setItems(FXCollections.observableArrayList("BEGINNER","GEVORDERD","EXPERT"));
        cbWebcast.setItems(FXCollections.observableArrayList(webcastRepo.getTitels()));
        cbModule.setItems(FXCollections.observableArrayList(moduleRepo.getTitels()));

        txtCursus.setText(cursusRepo.getCursus(indexCursus).getCursusNaam());
        txtIntroductie.setText(cursusRepo.getCursus(indexCursus).getIntroductieTekst());
        txtOnderwerp.setText(cursusRepo.getCursus(indexCursus).getOnderwerp());




    }
    @FXML
    void handleAddButton(ActionEvent event) throws ParseException {
        if (txtCursus.getText().isEmpty()){
            txtSucces.setText("Cursus veld is leeg");
            txtSucces.setTextFill(Color.RED);
            return;
        }
        if (txtOnderwerp.getText().isEmpty()){
            txtSucces.setText("Onderwerp veld is leeg");
            txtSucces.setTextFill(Color.RED);
            return;
        }
        if (txtIntroductie.getText().isEmpty()){
            txtSucces.setText("Introductie veld is leeg");
            txtSucces.setTextFill(Color.RED);
            return;
        }
        if (txtOnderwerp.getText() != null && txtCursus.getText() != null && txtIntroductie.getText() != null && cbModule.getValue() !=null
                && cbWebcast.getValue()!= null && cbNiveau.getValue() != null) {
            try {
                cursusRepo.update(indexCursus,new Cursus(txtCursus.getText(), txtOnderwerp.getText(), txtIntroductie.getText(), cbNiveau.getValue(),
                        cbModule.getValue(),cbWebcast.getValue()));
                txtSucces.setText("Cursus succesvol geupdate");
                txtSucces.setTextFill(Color.GREEN);
            }catch (Exception e){
                txtSucces.setText("Cursus update mislukt");
                txtSucces.setTextFill(Color.RED);
                return;
            }
        }else {
            txtSucces.setText("Cursus update mislukt");
            txtSucces.setTextFill(Color.RED);
        }


    }

    @FXML
    void handleTerug() throws Exception{
        NavbarController.terug = 3;
        Parent root = FXMLLoader.load(getClass().getResource("fxml/navbar.fxml"));
        Stage window = (Stage)btnTerug.getScene().getWindow();
        window.setScene(new Scene(root, 1370,600));
        window.setResizable(false);

    }

}
