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
import programma.DB.InschrijvingRepo;
import programma.DB.WebcastRepo;
import programma.domain.Inschrijving;
import programma.domain.Webcast;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class InschrijvingController implements Initializable {
    InschrijvingRepo inschrijvingRepo = new InschrijvingRepo();
    Stage stage;


    @FXML
    private TableView<Inschrijving> inschrijvingTableView;

    @FXML
    private TableColumn<Inschrijving, Integer> IDcolumn;

    @FXML
    private TableColumn<Inschrijving, String> emailColumn;

    @FXML
    private TableColumn<Inschrijving, String> cursusColumn;

    @FXML
    private TableColumn<Inschrijving, String> registratieColumn;

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnDelete;



    ObservableList<Inschrijving> inschrijvingsObservableList = FXCollections.observableArrayList();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        inschrijvingsObservableList.addAll(inschrijvingRepo.get());
        IDcolumn.setCellValueFactory(new PropertyValueFactory<>("inschrijvingID"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("cursusNaam"));
        cursusColumn.setCellValueFactory(new PropertyValueFactory<>("cursistEmail"));
        registratieColumn.setCellValueFactory(new PropertyValueFactory<>("registratieDatum"));

        inschrijvingTableView.setItems(inschrijvingsObservableList);
    }
    public void handleAddBtn() throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("fxml/addInschrijving.fxml"));
        Stage window = (Stage)btnAdd.getScene().getWindow();
        window.setScene(new Scene(root, 1080,600));
        window.setResizable(false);
    }

     @FXML
    void handleDeleteBtn() {
      int selectedID = inschrijvingTableView.getSelectionModel().getSelectedIndex();

            if(selectedID > -1) {
                Alert alert = new Alert(Alert.AlertType.WARNING, "Are you sure you want to delete this?", ButtonType.YES, ButtonType.CANCEL);

                alert.showAndWait();

                if (alert.getResult() == ButtonType.YES) {
                    inschrijvingRepo.delete(IDcolumn.getCellData(selectedID));
                    inschrijvingTableView.getItems().remove(selectedID);
                }
            }else {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Failed to delete, there is no data to delete \nPlease make sure your selected a row to delete"  , ButtonType.CLOSE);

                alert.showAndWait();
            }

    }
    @FXML
    void handleUpdateBtn() throws IOException {
       /*int selectedID = webcastTableView.getSelectionModel().getSelectedIndex();

        if(selectedID > -1) {
            Alert alert = new Alert(Alert.AlertType.WARNING, "Are you sure you want to update this?", ButtonType.YES, ButtonType.CANCEL);

            alert.showAndWait();

            if (alert.getResult() == ButtonType.YES) {
                UpdateWebcastsController.indexCursist = IDcolumn.getCellData(selectedID);
                System.out.println(IDcolumn.getCellData(selectedID));
                Parent root = FXMLLoader.load(getClass().getResource("fxml/updateWebcast.fxml"));
                Stage window = (Stage)btnUpdate.getScene().getWindow();
                window.setScene(new Scene(root, 1080,600));
                window.setResizable(false);
            }
        }else {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Failed to load update page, there is no data to update \nPlease make sure your selected a row to update"  , ButtonType.CLOSE);

            alert.showAndWait();
        }
*/
    }
}
