package view.tm;

public class VehicletableTM {
     private String vehicle;
     private String type;
     private double weight;
     private int passengers;

    public VehicletableTM() {
    }

    public VehicletableTM(String vehicle, String type, double weight, int passengers) {
        this.vehicle = vehicle;
        this.type = type;
        this.weight = weight;
        this.passengers = passengers;
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

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getPassengers() {
        return passengers;
    }

    public void setPassengers(int passengers) {
        this.passengers = passengers;
    }

    @Override
    public String toString() {
        return "AdddriverTM{" +
                "vehicle='" + vehicle + '\'' +
                ", type='" + type + '\'' +
                ", weight=" + weight +
                ", passengers=" + passengers +
                '}';
    }
}
