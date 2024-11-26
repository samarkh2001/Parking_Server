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
        URL resource = getClass().getResource("/view/DashBoardForm.fxml");
        if (resource == null) {
        	System.out.println("resource is null");
        	return;
        }
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
