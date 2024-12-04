package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class ManagementLoginFormController {
    public AnchorPane managementLoginFormContext;
    public Label time;
    public TextField txtName;
    public TextField pwdPassword;

    public void cancelManagementLoginFormOnAction(ActionEvent actionEvent) throws IOException {
        setUi("DashBoardForm");
    }

    private void setUi(String location) throws IOException {
        Stage stage = (Stage) managementLoginFormContext.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/" + location + ".fxml"))));
    }

    public void btnLoginOnAction(ActionEvent actionEvent) throws IOException {
        String tempName = txtName.getText();
        String tempPassword = pwdPassword.getText();
        if (tempName.equals("sumera") && tempPassword.equals("1234")) {
            setUi("InParkingForm");
        } else {
            new Alert(Alert.AlertType.WARNING, "Wrong Name or Password, Try Again!").show();

        }

    }

}
