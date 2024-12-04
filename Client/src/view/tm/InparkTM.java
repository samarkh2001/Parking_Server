package view.tm;

import javafx.scene.control.ComboBox;

import java.awt.*;

public class InparkTM {
       private String vehicle;
       private String type;
       private String number;
       private String time;

    public InparkTM() {
    }

    public InparkTM(String vehicle, String type, String number, String time) {
        this.vehicle = vehicle;
        this.type = type;
        this.number = number;
        this.time = time;
    }

    public String getVehicle() {
        return vehicle;
    }

    public void setVehicle(String vehicle) {
        this.vehicle = vehicle;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "InparkTM{" +
                "vehicle='" + vehicle + '\'' +
                ", type='" + type + '\'' +
                ", number='" + number + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}
