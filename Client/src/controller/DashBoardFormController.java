package controller;


import db.*;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.*;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DashBoardFormController extends VehicleTableFormController {
    public AnchorPane dashBoardContext;

    public ComboBox<String> cmbVehicle;
    public ComboBox<String> cmbType;
    public ComboBox<String> cmbDriver;
    public Label time;
    public Label lblNumber;
    @FXML
    public TextField txtVehicle;
    @FXML
    public TextField txtType;
    public Label lblVehicle;
    public Label lblType;
    public Label lblDriver;
    @FXML
    public Button parkVehicleBtn;
    @FXML
    public Button onDeliveryBtn;
    public Label lblTime;
    public Label date;
    @FXML
    public Button onDeliveryShiftBtn;
    public Label lblText;
    private volatile boolean stop = false;


    public void initialize() {
        parkVehicleBtn.setDisable(false);
        onDeliveryShiftBtn.setDisable(false);

        for (Inpark m : Database.parkTable) {
            if (m.getNumber().equals(cmbVehicle)) {
                parkVehicleBtn.setDisable(true);
            }


        }
        if (!parkVehicleBtn.isDisable()) {
            onDeliveryShiftBtn.setDisable(false);
        }


        ObservableList<String> obList4 = FXCollections.observableArrayList();

        for (Vehicletable t : Database3.vehicleTable) {
            obList4.add(t.getVehicle());

        }
        cmbVehicle.setItems(obList4);
        ObservableList<String> obList5 = FXCollections.observableArrayList();
        for (Drivertable d : Database4.driverTable) {
            obList5.add(d.getName());

        }
        cmbDriver.setItems(obList5);


        //ObservableList<String> obList = FXCollections.observableArrayList();
        //obList.add(VehicletableTM);
        //cmbVehicle.setItems(VehicletableTM);

        //cmbVehicle.setItems(obList);
        // cmbVehicle.setItems(obList3);

        // tblVehicleTable.setItems(obList3);

      /*  ObservableList<String> obList = FXCollections.observableArrayList();
        obList.add("NA-3434");
        obList.add("KA-4563");
        obList.add("58-3567");
        obList.add("GF-4358");
        obList.add("CCB-3568");
        obList.add("LM-6679");
        obList.add("QA-3369");
        obList.add("KB-3668");
        obList.add("JJ-9878");
        obList.add("GH-5772");
        obList.add("XY-4456");
        obList.add("YQ-3536");
        obList.add("CBB-3566");
        obList.add("QH-3444");
        cmbVehicle.setItems(obList);

        ObservableList<String> obList2 = FXCollections.observableArrayList();
        obList2.add("Bus");
        obList2.add("Van");
        obList2.add("Cargo Lorry");
        cmbType.setItems(obList2);

        ObservableList<String> obList3 = FXCollections.observableArrayList();
        obList3.add("Sumith Kumara");
        obList3.add("Amila Pathirana");
        obList3.add("Jithmal Perera");
        cmbDriver.setItems(obList3);*/


        Timenow();
        SimpleDateFormat realDateTimePickerVar = new SimpleDateFormat("dd/MM/YYYY");
        Date dateTime = new Date();
        date.setText(realDateTimePickerVar.format(dateTime));

    }
   /* public void DisableAndEnableButtonOption(){
        parkVehicleBtn.setDisable(false);
        onDeliveryShiftBtn.setDisable(false);

for(Inpark m:Database.parkTable){
    if(m.getNumber().equals(cmbVehicle)){
        parkVehicleBtn.setDisable(true);
    }

}
        if(!parkVehicleBtn.isDisable()){
            onDeliveryShiftBtn.setDisable(true);
        }


    }*/


    public void openManagementFormOnAction(ActionEvent actionEvent) throws IOException {
        setUi("ManagementLoginForm");
    }

    private void setUi(String location) throws IOException {
        Stage stage = (Stage) dashBoardContext.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/" + location + ".fxml"))));
    }

    public void Timenow() {
        Thread thread = new Thread(() -> {
            SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss a");
            while (!stop) {
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    System.out.println(e);

                }
                final String timenow = sdf.format(new Date());
                Platform.runLater(() -> {
                    time.setText(timenow);
                });
            }
        });
        thread.start();
    }

    public void btnParkOnAction(ActionEvent actionEvent) {
        lblVehicle.setText(cmbVehicle.getValue());
        lblType.setText(cmbType.getValue());
        lblDriver.setText(cmbDriver.getValue());
        //lblNumber.setText(lblNumber.getText());

       /* Inpark p1 = new Inpark(
                lblVehicle.getText(),
                lblType.getText(),
                lblNumber.getText()
        );
        Database.parkTable.add(p1);*/

        for (Slottable r : Database5.slotTable) {
            if (lblType.getText().equals(r.getType())) {

                if (lblVehicle.getText().equals(r.getVehicle())) {
                    parkVehicleBtn.setDisable(true);
                    new Alert(Alert.AlertType.WARNING, "This Vehicle is Already Parked...,Please Check Again!").showAndWait();
                    // parkVehicleBtn.setDisable(true);
                    break;
                }

                if (r.getAvailable() == true) {
                    r.setVehicle(lblVehicle.getText());
                    lblNumber.setText(r.getSlot());
                    r.setAvailable(false);
                    parkVehicleBtn.setDisable(true);
                    break;


                } else {

                    // new Alert(Alert.AlertType.WARNING, "This Slot has Already Parked a Vehicle,Please Check Again!").show();
                    //Node btnParkOnAction=null;

                    //Tab btnParkOnAction=null;
                    // btnParkOnAction.setDisable(true);
                }




              /*  if(lblNumber.getText().equals(r.getSlot())){
                    r.setAvailable(false);

                }*/
            }


        }
      /* for(Inpark x:Database.parkTable){
            if(lblVehicle.getText().equals(x.getVehicle())){
                //parkVehicleBtn.setDisable(true);
                 new Alert(Alert.AlertType.WARNING, "This Slot has Already Parked a Vehicle,Please Check Again!").show();
                 break;
            }


        }*/


        try {

            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy - HH:mm a");
            Inpark p1 = new Inpark(
                    lblVehicle.getText(),
                    lblType.getText(),
                    lblNumber.getText(),
                    LocalDateTime.now().format(dateTimeFormatter)
            );
            parkVehicleBtn.setDisable(true);

            Database.parkTable.add(p1);

        } catch (NullPointerException e) {
            e.printStackTrace();
        }

    }


    public void btnDeliveryOnAction(ActionEvent actionEvent) {
        lblVehicle.setText(cmbVehicle.getValue());
        lblType.setText(cmbType.getValue());
        lblDriver.setText((String) cmbDriver.getValue());

        //System.out.println(formatter.format(date));
      /* Ondelivery p2=new Ondelivery(
                lblVehicle.getText(),
                lblType.getText(),
                lblDriver.getText()
        );
        //Database2.deliveryTable.add(p2);*/
      /*  try {
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy - HH:mm a");
            Ondelivery p2 = new Ondelivery(
                    lblVehicle.getText(),
                    lblType.getText(),
                    lblDriver.getText(),
                    lblNumber.getText(),
                    java.time.LocalDateTime.now().format(dateTimeFormatter)
            );


            Database2.deliveryTable.add(p2);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }*/
        for (Slottable r : Database5.slotTable) {


            for (Inpark i : Database.parkTable) {

                if (lblVehicle.getText().equals(i.getVehicle())) {
                    lblNumber.setText(i.getNumber());
                    if (lblNumber.getText().equals(r.getSlot())) {
                        if (r.getAvailable() == false) {
                            //lblNumber.setText(r.getSlot());
                            r.setAvailable(true);
                            r.setVehicle("");

                            onDeliveryShiftBtn.setDisable(true);
                            // lblText.setText("Thank You !");
                            break;
                            //r.setAvailable(true);

                            //lblNumber.setText(r.getSlot());
                        }
                    }

                 /* if (lblNumber.getText().equals(r.getSlot())) {
                      r.setAvailable(true);
                      break;
                  }*/

                }
            }

        }
        try {
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy - HH:mm a");
            Ondelivery p2 = new Ondelivery(
                    lblVehicle.getText(),
                    lblType.getText(),
                    lblDriver.getText(),
                    lblNumber.getText(),
                    java.time.LocalDateTime.now().format(dateTimeFormatter)
            );


            Database2.deliveryTable.add(p2);

        } catch (NullPointerException e) {
            e.printStackTrace();
        }
       /* Ondelivery p2=new Ondelivery(
                lblVehicle.getText(),
                lblType.getText(),
                lblDriver.getText()

        );

        Database2.deliveryTable.add(p2);*/



       /* lblVehicle.setText(cmbVehicle.getValue());
        lblType.setText(cmbType.getValue());
        lblDriver.setText((String) cmbDriver.getValue());*/
    }


    public void btnShowOnAction(ActionEvent actionEvent) throws IOException {
        setUi("SlotForm");
    }

    public void vehicleSelectOnAction(ActionEvent actionEvent) {
        for (Vehicletable v : Database3.vehicleTable) {
            if (cmbVehicle.getValue().equals(v.getVehicle())) {
                cmbType.setValue(v.getType());
                parkVehicleBtn.setDisable(false);
                onDeliveryShiftBtn.setDisable(false);
            }
        }
        for (Inpark x : Database.parkTable) {
            if (cmbVehicle.getValue().equals(x.getVehicle())) {
                parkVehicleBtn.setDisable(true);
            }


        }
        for (Ondelivery e : Database2.deliveryTable) {
            if (cmbVehicle.getValue().equals(e.getVehicle())) {
                onDeliveryShiftBtn.setDisable(true);
                parkVehicleBtn.setDisable(false);
            }


        }

    }


}
