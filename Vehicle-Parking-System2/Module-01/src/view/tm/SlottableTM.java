package view.tm;

public class SlottableTM {
     private String slot;
      private String type;
      private boolean available;
      private String vehicle;

    public SlottableTM() {
    }

    public SlottableTM(String slot, String type, boolean available, String vehicle) {
        this.slot = slot;
        this.type = type;
        this.available = available;
        this.vehicle = vehicle;
    }

    public String getSlot() {
        return slot;
    }

    public void setSlot(String slot) {
        this.slot = slot;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean getAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String getVehicle() {
        return vehicle;
    }

    public void setVehicle(String vehicle) {
        this.vehicle = vehicle;
    }

    @Override
    public String toString() {
        return "SlottableTM{" +
                "slot='" + slot + '\'' +
                ", type='" + type + '\'' +
                ", available=" + available +
                ", vehicle='" + vehicle + '\'' +
                '}';
    }
}
