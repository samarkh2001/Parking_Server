package controller;

import db.Database2;
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
import model.Ondelivery;
import view.tm.OndeliveryTM;

import java.io.IOException;

public class OnDeliveryFormController {
    public TableView<OndeliveryTM> tblOnDelivery;
    public TableColumn colVehicle;
    public TableColumn colType;
    public TableColumn colDriver;
    public TableColumn colTime;
    public AnchorPane OnDeliveryContext;
    public TableColumn colSlot;

    public void initialize() {
        colVehicle.setCellValueFactory(new PropertyValueFactory("vehicle"));
        colType.setCellValueFactory(new PropertyValueFactory("type"));
        colDriver.setCellValueFactory(new PropertyValueFactory("driver"));
        colTime.setCellValueFactory(new PropertyValueFactory("time"));
        //  colSlot.setCellValueFactory(new PropertyValueFactory("slot") );

        loadAllOndelivery();

    }

    private void loadAllOndelivery() {
        ObservableList<OndeliveryTM> obList2 = FXCollections.observableArrayList();

        for (Ondelivery p2 : Database2.deliveryTable) {
            OndeliveryTM tm = new OndeliveryTM(p2.getVehicle(), p2.getType(), p2.getDriver(), p2.getSlot(), p2.getTime());
            obList2.add(tm);
        }
        tblOnDelivery.setItems(obList2);
    }

    public void btnInParking(ActionEvent actionEvent) throws IOException {
        setUi("InParkingForm");
    }

    private void setUi(String location) throws IOException {
        Stage stage = (Stage) OnDeliveryContext.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/" + location + ".fxml"))));
    }

    public void btnAddVehicleOnAction(ActionEvent actionEvent) throws IOException {
        setUi("AddVehicleForm");
    }

    public void btnAddDriverOnAction(ActionEvent actionEvent) throws IOException {
        setUi("AddDriverForm");
    }
}
