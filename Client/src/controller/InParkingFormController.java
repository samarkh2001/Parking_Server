package controller;

import db.Database;
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
import model.Inpark;
import view.tm.InparkTM;

import java.io.IOException;

public class InParkingFormController {
    public TableView<InparkTM> tblInParking;
    public TableColumn colVehicle;
    public TableColumn colType;
    public TableColumn colNumber;
    public TableColumn colTime;
    public AnchorPane InParkingContext;

    public void initialize() {
        colVehicle.setCellValueFactory(new PropertyValueFactory("vehicle"));
        colType.setCellValueFactory(new PropertyValueFactory("type"));

        colNumber.setCellValueFactory(new PropertyValueFactory("number"));
        colTime.setCellValueFactory(new PropertyValueFactory("time"));
        loadAllInpark();

    }

    private void loadAllInpark() {
        ObservableList<InparkTM> obList = FXCollections.observableArrayList();

        for (Inpark p : Database.parkTable) {
            InparkTM tm = new InparkTM(p.getVehicle(), p.getType(), p.getNumber(), p.getTime());
            obList.add(tm);
        }
        tblInParking.setItems(obList);

    }


    public void btnOnDeliveryOnAction(ActionEvent actionEvent) throws IOException {
        setUi("OnDeliveryForm");
    }

    private void setUi(String location) throws IOException {
        Stage stage = (Stage) InParkingContext.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/" + location + ".fxml"))));
    }

    public void btnLogoutOnAction(ActionEvent actionEvent) throws IOException {
        setUi("DashBoardForm");
    }

    public void btnAddVehicleOnAction(ActionEvent actionEvent) throws IOException {
        setUi("AddVehicleForm");
    }

    public void btnAddDriverOnAction(ActionEvent actionEvent) throws IOException {
        setUi("AddDriverForm");
    }
}
