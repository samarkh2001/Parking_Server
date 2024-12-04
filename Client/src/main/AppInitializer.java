package main;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Time;

public class AppInitializer extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
    	Client.connection = new Client("127.0.0.1",5555);
    	Client.connection.sendMessageToServer("Hi");
    	if(!Client.connected)
    		return;
    	System.out.println("connected to server successfuly");
        URL resource = getClass().getResource("/view/DashBoardForm.fxml");
        try {
	        Parent load = FXMLLoader.load(resource);
	        Scene scene = new Scene(load);
	        primaryStage.setScene(scene);
	        primaryStage.show();
        }catch(Exception ex) {
        	System.out.println("Encountered an error..");
        	ex.printStackTrace();
        }
    }
}







