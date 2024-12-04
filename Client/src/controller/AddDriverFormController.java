package controller;

import db.Database4;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Drivertable;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AddDriverFormController {
    public TextField txtDriver;
    public TextField txtNic;
    public TextField txtLicense;
    public TextField txtAddress;
    public TextField txtContact;
    public AnchorPane AddDriverContext;
    public Label licenseLbl;
    public Label lblLicense;

    public void btnAddDriverOnAction(ActionEvent actionEvent) {
        Drivertable p1 = new Drivertable(
                txtDriver.getText(),
                txtNic.getText(),
                txtLicense.getText(),
                txtAddress.getText(),
                txtContact.getText()
        );
        Database4.driverTable.add(p1);
        new Alert(Alert.AlertType.CONFIRMATION, "Driver is Successfully Added!").show();
    }

    public void btnShowOnAction(ActionEvent actionEvent) throws IOException {
        setUi("DriverTableForm");
    }

    public void btnCancelOnAction(ActionEvent actionEvent) throws IOException {
        setUi("InParkingForm");

    }

    private void setUi(String location) throws IOException {
        Stage stage = (Stage) AddDriverContext.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/" + location + ".fxml"))));

    }

    public void checkLicenseOnAction(ActionEvent actionEvent) {
        String value = "^([A-Z]{1,10}.([0-9]{7}))$";
        Pattern pattern = Pattern.compile(value);
        Matcher match = pattern.matcher(txtLicense.getText());
        if (!match.matches()) {
            txtLicense.setText("Invalid");
        } else {
            txtLicense.setText("");
        }
    }

    public void checkLicense(javafx.scene.input.KeyEvent keyEvent) {
        String value = "^([A-Z]{1,10}.([0-9]{7}))$";
        Pattern pattern = Pattern.compile(value);
        Matcher match = pattern.matcher(txtLicense.getText());
        if (!match.matches()) {
            licenseLbl.setText("Invalid");
        } else {
            licenseLbl.setText("");
        }
    }
}


