package controller;

import db.Database3;
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
import model.Vehicletable;
import view.tm.VehicletableTM;

import java.io.IOException;

public class VehicleTableFormController {
    public TableColumn colVehicle;
    public TableColumn colType;
    public TableColumn colWeight;
    public TableColumn colPassenger;
    public TableView<VehicletableTM> tblVehicleTable;
    public AnchorPane VehicleTableContext;

    public void initialize() {
        colVehicle.setCellValueFactory(new PropertyValueFactory("vehicle"));
        colType.setCellValueFactory(new PropertyValueFactory("type"));
        colWeight.setCellValueFactory(new PropertyValueFactory("weight"));
        colPassenger.setCellValueFactory(new PropertyValueFactory("passengers"));

        loadAllVehicletable();

    }

    private void loadAllVehicletable() {
        ObservableList<VehicletableTM> obList3 = FXCollections.observableArrayList();

        for (Vehicletable p3 : Database3.vehicleTable) {
            VehicletableTM tm = new VehicletableTM(p3.getVehicle(), p3.getType(), p3.getWeight(), p3.getPassengers());
            obList3.add(tm);
        }
        tblVehicleTable.setItems(obList3);

    }

    public void btnCancelOnaction(ActionEvent actionEvent) throws IOException {
        setUi("InParkingForm");
    }

    private void setUi(String location) throws IOException {
        Stage stage = (Stage) VehicleTableContext.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/" + location + ".fxml"))));
    }
}
