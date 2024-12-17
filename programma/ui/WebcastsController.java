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
import programma.DB.CursistRepo;
import programma.DB.WebcastRepo;
import programma.domain.Cursist;
import programma.domain.Webcast;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class WebcastsController implements Initializable {
    WebcastRepo webcastRepo = new WebcastRepo();
    Stage stage;


    @FXML
    private TableView<Webcast> webcastTableView;

    @FXML
    private TableView<Webcast> webcastTopThreeTableView;

    @FXML
    private TableColumn<Webcast, Integer> IDcolumn;

    @FXML
    private TableColumn<Webcast, String> webcastTitelColumn;
    @FXML
    private TableColumn<Webcast, String> beschrijvingColumn;
    @FXML
    private TableColumn<Webcast, String> sprekerColumn;

    @FXML
    private TableColumn<Webcast, String> organisatieColumn;

    @FXML
    private TableColumn<Webcast, String> tijdsduurColumn;

    @FXML
    private TableColumn<Webcast, String> publicatieColumn;

    @FXML
    private TableColumn<Webcast, String> urlColumn;

    @FXML
    private TableColumn<Webcast, String > titelTopThreeColumn;

    @FXML
    private TableColumn<Webcast, String> sprekerTopThreeColumn;

    @FXML
    private TextField zoekCursist;
    @FXML
    private Button btnCursist;
    @FXML
    private Button btnDelete;
    @FXML
    private Button btnUpdate;

    ObservableList<Webcast> webcastsObservableList = FXCollections.observableArrayList();
    ObservableList<Webcast> webcastsObservableListTop3 = FXCollections.observableArrayList();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
            webcastsObservableList.addAll(webcastRepo.get());
            webcastsObservableListTop3.addAll(webcastRepo.getTop3());
        IDcolumn.setCellValueFactory(new PropertyValueFactory<>("webcastID"));
            tijdsduurColumn.setCellValueFactory(new PropertyValueFactory<>("tijdsduur"));
            urlColumn.setCellValueFactory(new PropertyValueFactory<>("url"));
            sprekerColumn.setCellValueFactory(new PropertyValueFactory<>("sprekerNaam"));
            organisatieColumn.setCellValueFactory(new PropertyValueFactory<>("organisatieNaam"));
            webcastTitelColumn.setCellValueFactory(new PropertyValueFactory<>("titel"));
            publicatieColumn.setCellValueFactory(new PropertyValueFactory<>("publicatieDatum"));
            beschrijvingColumn.setCellValueFactory(new PropertyValueFactory<>("beschrijving"));
            webcastTableView.setItems(webcastsObservableList);

            //Top 3

        titelTopThreeColumn.setCellValueFactory(new PropertyValueFactory<>("titel"));
        sprekerTopThreeColumn.setCellValueFactory(new PropertyValueFactory<>("sprekerNaam"));
        webcastTopThreeTableView.setItems(webcastsObservableListTop3);


    }
    public void handleBtn() throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("fxml/addWebcast.fxml"));
        Stage window = (Stage)btnCursist.getScene().getWindow();
        window.setScene(new Scene(root, 1080,600));
        window.setResizable(false);
    }

     @FXML
    void handleDeleteBtn() {
      int selectedID = webcastTableView.getSelectionModel().getSelectedIndex();

            if(selectedID > -1) {
                Alert alert = new Alert(Alert.AlertType.WARNING, "Are you sure you want to delete this?", ButtonType.YES, ButtonType.CANCEL);

                alert.showAndWait();

                if (alert.getResult() == ButtonType.YES) {
                    webcastRepo.delete(IDcolumn.getCellData(selectedID));
                    webcastTableView.getItems().remove(selectedID);
                }
            }else {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Failed to delete, there is no data to delete \nPlease make sure your selected a row to delete"  , ButtonType.CLOSE);

                alert.showAndWait();
            }

    }
    @FXML
    void handleUpdateBtn() throws IOException {
       int selectedID = webcastTableView.getSelectionModel().getSelectedIndex();

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

    }
}
