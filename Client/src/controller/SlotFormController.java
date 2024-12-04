package controller;

import db.Database5;
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
import model.Slottable;
import view.tm.SlottableTM;

import java.io.IOException;

public class SlotFormController {
    public TableView tblSlotTable;
    public TableColumn colSlot;
    public TableColumn colVehicle;
    public TableColumn colType;
    public TableColumn colAvailable;
    public AnchorPane slotTableContext;

    public void initialize() {
        colSlot.setCellValueFactory(new PropertyValueFactory("slot"));
        colType.setCellValueFactory(new PropertyValueFactory("type"));
        colAvailable.setCellValueFactory(new PropertyValueFactory("available"));
        colVehicle.setCellValueFactory(new PropertyValueFactory("vehicle"));

        loadAllSlottable();

    }

    private void loadAllSlottable() {
        ObservableList<SlottableTM> obList3 = FXCollections.observableArrayList();

        for (Slottable p3 : Database5.slotTable) {
            SlottableTM tm = new SlottableTM(p3.getSlot(), p3.getType(), p3.getAvailable(), p3.getVehicle());
            obList3.add(tm);
        }
        tblSlotTable.setItems(obList3);

    }


    public void btnBackOnAction(ActionEvent actionEvent) throws IOException {
        setUi("DashBoardForm");
    }

    private void setUi(String location) throws IOException {
        Stage stage = (Stage) slotTableContext.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/" + location + ".fxml"))));
    }
}
