package model;

public class Ondelivery {
      private String vehicle;
     private String type;
      private String driver;
     private String time;
     private String slot;

    public Ondelivery() {
    }

    public Ondelivery(String vehicle, String type, String driver, String time, String slot) {
        this.vehicle = vehicle;
        this.type = type;
        this.driver = driver;
        this.time = time;
        this.slot = slot;
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

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getSlot() {
        return slot;
    }

    public void setSlot(String slot) {
        this.slot = slot;
    }

    @Override
    public String toString() {
        return "Ondelivery{" +
                "vehicle='" + vehicle + '\'' +
                ", type='" + type + '\'' +
                ", driver='" + driver + '\'' +
                ", time='" + time + '\'' +
                ", slot='" + slot + '\'' +
                '}';
    }
}
