package programma.ui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import programma.DB.CertificaatRepo;
import programma.DB.WebcastRepo;
import programma.domain.Certificaat;
import programma.domain.Inschrijving;
import programma.domain.Webcast;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CertificatenController implements Initializable {
    CertificaatRepo certificaatRepo = new CertificaatRepo();
    Stage stage;
    @FXML
    private TableView<Certificaat> certificatenTableView;

    @FXML
    private TableColumn<Certificaat, Integer> IDcolumn;

    @FXML
    private TableColumn<Certificaat, String> cursistColumn;

    @FXML
    private TableColumn<Certificaat, String> geslachtColumn;

    @FXML
    private TableColumn<Certificaat, String>cursusColumn;

    @FXML
    private TableColumn<Certificaat, Integer> beoordelingColumn;

    @FXML
    private TableColumn<Certificaat, String> ondertekenaarColumn;

    @FXML
    private Button btnUpdate;

    @FXML
    private Button btnDelete;
    @FXML
    private ProgressIndicator percentageMan;

    @FXML
    private ProgressIndicator percentageVrouw;

    ObservableList<Certificaat> certificaatObservableList = FXCollections.observableArrayList();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        double percentageManValue = (certificaatRepo.getPercentageMan()) /100.0;
        double percentageVrouwValue = (certificaatRepo.getPercentageVrouw()) /100.0;

        percentageMan.setProgress(percentageManValue);
        percentageVrouw.setProgress(percentageVrouwValue);
        certificaatObservableList.addAll(certificaatRepo.get());
        IDcolumn.setCellValueFactory(new PropertyValueFactory<>("certificaatID"));
        beoordelingColumn.setCellValueFactory(new PropertyValueFactory<>("beoordeling"));
        ondertekenaarColumn.setCellValueFactory(new PropertyValueFactory<>("ondertekenaar"));
        cursistColumn.setCellValueFactory(new PropertyValueFactory<>("cursist"));
        cursusColumn.setCellValueFactory(new PropertyValueFactory<>("cursus"));

        geslachtColumn.setCellValueFactory(new PropertyValueFactory<>("geslachtCursist"));
        //kleur zetten als de beoordeling is geslaagd
        certificatenTableView.setRowFactory(row -> new TableRow<Certificaat>() {
            @Override
            public void updateItem(Certificaat item, boolean empty) {
                super.updateItem(item, empty);
                if (item == null) {
                    setStyle("");
                } else if (item.getBeoordeling() > 5) {
                    this.setId("geslaagd");
                } else if (item.getBeoordeling() > 1 && item.getBeoordeling() < 5) {
                    this.setId("niet-geslaagd");
                } else {
                    this.setId("not-error");
                }
            }
        });
        certificatenTableView.setItems(certificaatObservableList);


    }


    @FXML
    void handleUpdateBtn() throws IOException {
       int selectedID = certificatenTableView.getSelectionModel().getSelectedIndex();

        if(selectedID > -1) {
            Alert alert = new Alert(Alert.AlertType.WARNING, "Ben je zeker dat je dit wil afronden?", ButtonType.YES, ButtonType.CANCEL);

            alert.showAndWait();

            if (alert.getResult() == ButtonType.YES) {
                AfrondController.indexCertificaat = IDcolumn.getCellData(selectedID);
                System.out.println(IDcolumn.getCellData(selectedID));
                Parent root = FXMLLoader.load(getClass().getResource("fxml/afrond.fxml"));
                Stage window = (Stage)btnUpdate.getScene().getWindow();
                window.setScene(new Scene(root, 1080,600));
                window.setResizable(false);
            }
        }else {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Er zijn geen gegevens om bij te werken,\nZorg ervoor dat je een rij hebt geselecteerd om bij te werken"  , ButtonType.CLOSE);

            alert.showAndWait();
        }

    }
}
