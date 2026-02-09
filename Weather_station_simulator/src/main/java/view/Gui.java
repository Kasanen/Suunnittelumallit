
package view;

import java.util.concurrent.TimeUnit;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.UserData;

import java.util.Random;

public class Gui extends Application {

    private UserData userData = new UserData();

    @Override
    public void start(Stage primaryStage) {
        // Open windows simultaneously
        openStation("Weather Station");
        openObserver("Weather Observer 1");
        openObserver("Weather Observer 2");
    }

    // Station Window
    private void openStation(String windowName) {
        Random rand = new Random();

        Stage stage = new Stage();
        stage.setTitle(windowName);

        Label label = new ObservingLabel("Temperature: ", userData);

        VBox root = new VBox(label);
        Scene scene = new Scene(root, 300, 100);

        stage.setScene(scene);
        stage.show();

        new Thread(() -> { // In thread so program is loaded correctly
            // Temp tweak
            int min = -5;
            int max = 5;
            int tempValue = 0;

            // Loop
            while (true) {
                // Temperature
                tempValue += rand.nextBoolean() ? 1 : -1; // AI made;
                // clamp to min/max
                if (tempValue < min)
                    tempValue = min;
                if (tempValue > max)
                    tempValue = max;

                userData.setTemperature(tempValue);

                // Timer
                long randNumb = rand.nextInt(1, 6);
                try {
                    TimeUnit.SECONDS.sleep(randNumb);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.out.println("Sleep interrupted: " + e.getMessage());
                    break;
                }
            }
        }).start();
    }

    // Observer Window
    private void openObserver(String windowName) {
        Stage stage = new Stage();
        stage.setTitle(windowName);

        Label label = new ObservingLabel("Temperature: ", userData);

        VBox root = new VBox(label);
        Scene scene = new Scene(root, 300, 100);

        stage.setScene(scene);
        stage.show();
    }
}
