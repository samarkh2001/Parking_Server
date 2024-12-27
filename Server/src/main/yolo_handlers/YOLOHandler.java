package main.yolo_handlers;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import main.Configs;

public class YOLOHandler {

	private static boolean debug = false;
	
	public static String processImage(String park) {
		try {

            // Paths for weights and source image
            String weightsPath = new File(Configs.DATA_PATH, "yolov9-e.pt").getAbsolutePath();
            String sourceImagePath = new File(Configs.PARK_IMAGES_PATH, park).getAbsolutePath();

            // Path to the Python project (yolov9 is at the same level as Server_Demo)
            File pythonProjectDir = new File(Configs.ROOT_PATH, "yolov9");

            String userName = System.getenv("USERNAME"); // Retrieves the current user's name
            String pythonCommand = String.format(
                "\"C:\\Users\\%s\\anaconda3\\python.exe\" detect.py --weights %s --conf 0.1 --source %s",
                userName, weightsPath, sourceImagePath
            );

            // Split command for ProcessBuilder
            ProcessBuilder processBuilder = new ProcessBuilder("cmd.exe", "/c", pythonCommand);

            // Set working directory to the Python project directory
            processBuilder.directory(pythonProjectDir);

            // Start the process
            Process process = processBuilder.start();

            // Capture and print output
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            
            StringBuilder sb = new StringBuilder();
            while ((line = reader.readLine()) != null) {
            	if (debug)
            		System.out.println(line);
                sb.append(line); // creating the result string -> instead of result += line;
            }

            // Capture and print error output
            BufferedReader errorReader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
            while ((line = errorReader.readLine()) != null) {
            	if (debug)
            		System.err.println(line);
                sb.append(line);
            }

            // Wait for the process to complete
            int exitCode = process.waitFor();
            if (exitCode == 0)
            	return sb.toString();
            else{
            	System.out.println("[YOLOHandler] - Process exited with code: " + exitCode);
            	return null;
            }

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
	}
	
	public static int getNumOfVehicles(String park) {
	    // Process the image to get the YOLO output
	    String result = processImage(park);
	    if (result == null) {
	        return -1; // If processing failed
	    }

	    // Define a regex pattern to capture vehicle counts (cars, trucks, etc.)
	    String vehiclePattern = "(\\d+)\\s+(cars?|trucks?|car?|truck?)"; // Matches: 17 cars, 1 truck, etc.

	    int totalVehicles = 0;

	    // Use regex to find all matches in the result string
	    Pattern pattern = Pattern.compile(vehiclePattern);
	    Matcher matcher = pattern.matcher(result);

	    // Add up all vehicle counts
	    while (matcher.find()) {
	        totalVehicles += Integer.parseInt(matcher.group(1)); // First group is the number
	    }

	    return totalVehicles;
	}

	
	public static void main(String[] args) {
		System.out.println(getNumOfVehicles("park3.jpg"));
	}
	
}
