package view;

import javafx.scene.control.Label;
import model.UserData;

public class ObservingLabel extends Label implements Observer {

    private UserData observable;

    public ObservingLabel(String text, UserData observable) {
        super(text);
        this.observable = observable;
        observable.addObserver(this);
    }

    @Override
    public void update() {
        javafx.application.Platform.runLater(() -> {
            System.out.println("Observers received an update.");
            this.setText("Temperature: " + String.valueOf(observable.temperature()));
        });
    }
}
