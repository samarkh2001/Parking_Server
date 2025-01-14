package main.request.parking;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import commons.entities.Park;
import main.MainServer;
import main.request.RequestHandler;

public class ParkRequestHandler {
	
	public static List<String> getAllCities() {
		if (MainServer.dbConnection == null) {
			RequestHandler.debug("ParkRequestHandler", "No database connection");
			return null;
		}
		try {
			Statement st = MainServer.dbConnection.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM city");
			String city;
			List<String> cities = new ArrayList<>();
			while (rs.next()) {
				city = rs.getString(1);
				cities.add(city);
			}
			return cities;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public static Map<String, List<Park>> getAllParks() {
		if (MainServer.dbConnection == null) {
			RequestHandler.debug("ParkRequestHandler", "No database connection");
			return null;
		}
		try {
			Statement st = MainServer.dbConnection.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM park");
			Park p;
			Map<String, List<Park>> parks = new HashMap<>();//key is city name
			List<Park> cityParks;
			
			while(rs.next()) {
				p = new Park(rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getDouble(5), rs.getInt(6), rs.getInt(7));
				
				if (parks.get(p.getCity()) != null) {
					cityParks = parks.get(p.getCity());
					parks.remove(p.getCity());		
				}else {
					cityParks = new ArrayList<>();
				}
				cityParks.add(p);
				parks.put(p.getCity(), cityParks);
			}
			return parks;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

}
