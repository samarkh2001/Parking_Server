package db;

import model.Inpark;
import model.Slottable;

import java.util.ArrayList;

public class Database5 {
    public static ArrayList<Slottable> slotTable = new ArrayList<Slottable>();

    static {
        slotTable.add(
                new Slottable("1","Van",true,"")
        );
        slotTable.add(
                new Slottable("2","Van",true," ")
        );
        slotTable.add(
                new Slottable("3","Van",true,"")
        );
        slotTable.add(
                new Slottable("4","Van",true,"")
        );
        slotTable.add(
                new Slottable("5","Cargo Lorry",true,"")
        );
        slotTable.add(
                new Slottable("6","Cargo Lorry",true,"")
        );
        slotTable.add(
                new Slottable("7","Cargo Lorry",true,"")
        );
        slotTable.add(
                new Slottable("8","Cargo Lorry",true,"")
        );
        slotTable.add(
                new Slottable("9","Cargo Lorry",true,"")
        );

        slotTable.add(
                new Slottable("10","Cargo Lorry",true,"")
        );
        slotTable.add(
                new Slottable("11","Cargo Lorry",true,"")
        );
        slotTable.add(
                new Slottable("12","Van",true," ")
        );
        slotTable.add(
                new Slottable("13","Van",true,"")
        );
        slotTable.add(
                new Slottable("14","Bus",true,"")
        );


    }
}
