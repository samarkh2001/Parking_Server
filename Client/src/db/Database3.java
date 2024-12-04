package db;

import model.Vehicletable;

import java.util.ArrayList;

public class Database3 {
    public static ArrayList<Vehicletable> vehicleTable = new ArrayList<Vehicletable>();

    static {
        vehicleTable.add(
                new Vehicletable("NA-3434", "Bus", 3500, 60)
        );
        vehicleTable.add(
                new Vehicletable("KA-4563", "Van", 1000, 7)
        );
        vehicleTable.add(
                new Vehicletable("58-3567", "Van", 1500, 4)
        );
        vehicleTable.add(
                new Vehicletable("GF-4358", "Van", 800, 4)
        );
        vehicleTable.add(
                new Vehicletable("CCB-3568", "Van", 3500, 8)
        );
        vehicleTable.add(
                new Vehicletable("LM-6679 ", "Van", 1500, 4)
        );
        vehicleTable.add(
                new Vehicletable("QA-3369", "Van", 1800, 6)
        );
        vehicleTable.add(
                new Vehicletable("KB-3668", "Cargo Lorry", 2500, 2)
        );
        vehicleTable.add(
                new Vehicletable("JJ-9878", "Cargo Lorry", 3000, 2)
        );
        vehicleTable.add(
                new Vehicletable("GH-5772", "Cargo Lorry", 4000, 3)
        );
        vehicleTable.add(
                new Vehicletable("XY-4456", "Cargo Lorry", 3500, 2)
        );
        vehicleTable.add(
                new Vehicletable("YQ-3536", "Cargo Lorry", 2000, 2)
        );
        vehicleTable.add(
                new Vehicletable("CBB-3566", "Cargo Lorry", 2500, 2)
        );
        vehicleTable.add(
                new Vehicletable("QH-3444", "Cargo Lorry", 5000, 4)
        );
    }
}
