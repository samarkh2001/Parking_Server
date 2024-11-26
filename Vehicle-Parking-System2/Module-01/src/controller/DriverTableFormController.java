package controller;

import db.Database4;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Drivertable;
import view.tm.DrivertableTM;

import java.io.IOException;

public class DriverTableFormController {
    public TableView tblDriverTable;
    public TableColumn colName;
    public TableColumn colNic;
    public TableColumn colLicense;
    public TableColumn colAddress;
    public TableColumn colContact;
    public AnchorPane DriverTableContext;


    public void initialize() {
        colName.setCellValueFactory(new PropertyValueFactory("name"));
        colNic.setCellValueFactory(new PropertyValueFactory("nic"));
        colLicense.setCellValueFactory(new PropertyValueFactory("license"));
        colAddress.setCellValueFactory(new PropertyValueFactory("address"));
        colContact.setCellValueFactory(new PropertyValueFactory("contact"));

        loadAllDrivertable();

    }

    private void loadAllDrivertable() {
        ObservableList<DrivertableTM> obList3 = FXCollections.observableArrayList();

        for (Drivertable p3 : Database4.driverTable) {
            DrivertableTM tm = new DrivertableTM(p3.getName(), p3.getNic(), p3.getLicense(), p3.getAddress(), p3.getContact());
            obList3.add(tm);
        }
        tblDriverTable.setItems(obList3);

    }

    public void btnCancelOnaction(ActionEvent actionEvent) throws IOException {
        setUi("InParkingForm");
    }

    private void setUi(String location) throws IOException {
        Stage stage = (Stage) DriverTableContext.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/" + location + ".fxml"))));
    }
}
