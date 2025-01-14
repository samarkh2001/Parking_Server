package main.request.parking;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import commons.entities.Slot;
import main.MainServer;
import main.request.RequestHandler;

public class SlotRequestHandler {

	public static List<Slot> getAllParkSlots(String parkName, String cityName) {
		if (MainServer.dbConnection == null) {
			RequestHandler.debug("SlotRequestHandler", "No database connection");
			return null;
		}
		try {
			Statement st = MainServer.dbConnection.createStatement();
			ResultSet rs = st.executeQuery("SELECT  s.* FROM slot s JOIN park p "
					+ "ON s.park_id=p.park_id "
					+ "WHERE p.park_name='"+parkName+"' AND p.city_name='"+cityName+"'");
		
			List<Slot> slots = new ArrayList<>();
			Slot s;
			/*
			 * park_id, row_id, col_id, enter_date, enter_hour, enter_mins, status
			 * */
			while(rs.next()) {
				s = new Slot(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4),
						rs.getInt(5), rs.getInt(6), rs.getBoolean(7));
				slots.add(s);
			}
			return slots;
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
}
