package controller;

import db.Database3;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Vehicletable;

import java.io.IOException;

public class AddVehicleFormController {
    public AnchorPane AddVehicleContext;
    public TextField txtVehicle;
    public TextField txtType;
    public TextField txtWeight;
    public TextField txtPassenger;

    public void btnCancelOnAction(ActionEvent actionEvent) throws IOException {
        setUi("InParkingForm");
    }

    private void setUi(String location) throws IOException {
        Stage stage = (Stage) AddVehicleContext.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/" + location + ".fxml"))));

    }

    public void btnAddVehicleOnAction(ActionEvent actionEvent) {

        Vehicletable p1 = new Vehicletable(
                txtVehicle.getText(),
                txtType.getText(),
                Double.parseDouble(txtWeight.getText()),
                Integer.parseInt(txtPassenger.getText())
        );
        Database3.vehicleTable.add(p1);
        new Alert(Alert.AlertType.CONFIRMATION, "Vehicle is Successfully Added!").show();

    }

    public void btnShowOnAction(ActionEvent actionEvent) throws IOException {
        setUi("VehicleTableForm");
    }
}
