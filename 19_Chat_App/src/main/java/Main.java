import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {
    
    private static final List<String> DEFAULT_USERS = List.of("Alice", "Bob", "Charlie");
    private static final DateTimeFormatter TIME_FORMAT = DateTimeFormatter.ofPattern("HH:mm:ss");

    private final ChatMediatorInterface mediator = new Mediator();
    private final Map<String, Controller> controllers = new LinkedHashMap<>();
    private final Map<String, ClientWindow> clientsByUsername = new LinkedHashMap<>();

    @Override
    public void start(Stage primaryStage) {
        // Create controllers for each user and register with mediator
        for (String username : DEFAULT_USERS) {
            Controller controller = new Controller(username, mediator);
            controllers.put(username, controller);
            mediator.registerUser(controller);
        }

        // Create UI windows for each user
        for (int i = 0; i < DEFAULT_USERS.size(); i++) {
            String username = DEFAULT_USERS.get(i);
            Stage stage = (i == 0) ? primaryStage : new Stage();
            Controller controller = controllers.get(username);
            ClientWindow clientWindow = buildClientWindow(stage, username, controller);
            clientsByUsername.put(username, clientWindow);
        }

        clientsByUsername.values().forEach(ClientWindow::show);
    }

    private ClientWindow buildClientWindow(Stage stage, String username, Controller controller) {
        TextArea chatArea = new TextArea();
        chatArea.setEditable(false);
        chatArea.setWrapText(true);

        ComboBox<String> recipientSelector = new ComboBox<>();
        List<String> recipients = new ArrayList<>(DEFAULT_USERS);
        recipients.remove(username);
        recipientSelector.getItems().addAll(recipients);
        recipientSelector.setPromptText("Select recipient");

        TextField messageField = new TextField();
        messageField.setPromptText("Type a message...");
        HBox.setHgrow(messageField, Priority.ALWAYS);

        Button sendButton = new Button("Send");
        sendButton.setDefaultButton(true);
        sendButton.setOnAction(event -> sendMessage(controller, username, recipientSelector, messageField));
        messageField.setOnAction(event -> sendMessage(controller, username, recipientSelector, messageField));

        HBox infoRow = new HBox(8,
                new Label("You are:"), new Label(username),
                new Label("Recipient:"), recipientSelector);
        HBox messageRow = new HBox(8, messageField, sendButton);

        VBox root = new VBox(10, chatArea, infoRow, messageRow);
        root.setPadding(new Insets(12));
        VBox.setVgrow(chatArea, Priority.ALWAYS);

        stage.setTitle("Chat - " + username);
        stage.setScene(new Scene(root, 700, 450));

        ClientWindow clientWindow = new ClientWindow(username, stage, chatArea);
        
        // Connect controller to UI
        controller.setMessageReceiver((sender, recipient, message) -> {
            String timestamp = LocalTime.now().format(TIME_FORMAT);
            if (sender == null) {
                // System message
                chatArea.appendText("[" + timestamp + "] System: " + message + System.lineSeparator());
            } else {
                chatArea.appendText("[" + timestamp + "] " + sender + " -> " + recipient + ": " + message + System.lineSeparator());
            }
        });

        return clientWindow;
    }

    private void sendMessage(Controller controller, String sender, ComboBox<String> recipientSelector, TextField messageField) {
        String recipient = recipientSelector.getValue();
        String message = normalizedText(messageField.getText(), "");

        if (recipient == null || recipient.isBlank()) {
            ClientWindow window = clientsByUsername.get(sender);
            if (window != null) {
                String timestamp = LocalTime.now().format(TIME_FORMAT);
                window.chatArea.appendText("[" + timestamp + "] System: Please select a recipient." + System.lineSeparator());
            }
            return;
        }

        if (message.isBlank()) {
            return;
        }

        // Send through mediator
        controller.sendMessage(recipient, message);
        messageField.clear();
    }

    private String normalizedText(String value, String fallback) {
        if (value == null || value.isBlank()) {
            return fallback;
        }
        return value.trim();
    }

    private static class ClientWindow {
        private final String username;
        private final Stage stage;
        private final TextArea chatArea;

        private ClientWindow(String username, Stage stage, TextArea chatArea) {
            this.username = username;
            this.stage = stage;
            this.chatArea = chatArea;
        }

        private void show() {
            stage.show();
            String timestamp = LocalTime.now().format(TIME_FORMAT);
            chatArea.appendText("[" + timestamp + "] System: Connected as " + username + System.lineSeparator());
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}