package model;

public class Inpark {
    private String vehicle;
    private String type;
    private String number;
    private String time;

    public Inpark() {
    }

    public Inpark(String vehicle, String type, String number, String time) {
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
        return "Inpark{" +
                "vehicle='" + vehicle + '\'' +
                ", type='" + type + '\'' +
                ", number='" + number + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}

