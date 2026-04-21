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

public class Client extends Application {
    
    private static final List<String> DEFAULT_USERS = List.of("Alice", "Bob", "Charlie");
    private static final DateTimeFormatter TIME_FORMAT = DateTimeFormatter.ofPattern("HH:mm:ss");

    private final Map<String, ClientWindow> clientsByUsername = new LinkedHashMap<>();

    @Override
    public void start(Stage primaryStage) {
        for (int i = 0; i < DEFAULT_USERS.size(); i++) {
            String username = DEFAULT_USERS.get(i);
            Stage stage = (i == 0) ? primaryStage : new Stage();
            ClientWindow clientWindow = buildClientWindow(stage, username, DEFAULT_USERS);
            clientsByUsername.put(username, clientWindow);
        }

        clientsByUsername.values().forEach(ClientWindow::show);
    }

    private ClientWindow buildClientWindow(Stage stage, String username, List<String> allUsers) {
        TextArea chatArea = new TextArea();
        chatArea.setEditable(false);
        chatArea.setWrapText(true);

        ComboBox<String> recipientSelector = new ComboBox<>();
        List<String> recipients = new ArrayList<>(allUsers);
        recipients.remove(username);
        recipientSelector.getItems().addAll(recipients);
        recipientSelector.setPromptText("Select recipient");

        TextField messageField = new TextField();
        messageField.setPromptText("Type a message...");
        HBox.setHgrow(messageField, Priority.ALWAYS);

        Button sendButton = new Button("Send");
        sendButton.setDefaultButton(true);
        sendButton.setOnAction(event -> sendMessage(username, recipientSelector, messageField));
        messageField.setOnAction(event -> sendMessage(username, recipientSelector, messageField));

        HBox infoRow = new HBox(8,
                new Label("You are:"), new Label(username),
                new Label("Recipient:"), recipientSelector);
        HBox messageRow = new HBox(8, messageField, sendButton);

        VBox root = new VBox(10, chatArea, infoRow, messageRow);
        root.setPadding(new Insets(12));
        VBox.setVgrow(chatArea, Priority.ALWAYS);

        stage.setTitle("JavaFX Chat - " + username);
        stage.setScene(new Scene(root, 700, 450));

        return new ClientWindow(username, stage, chatArea);
    }

    private void sendMessage(String sender, ComboBox<String> recipientSelector, TextField messageField) {
        String recipient = recipientSelector.getValue();
        String message = normalizedText(messageField.getText(), "");

        if (recipient == null || recipient.isBlank()) {
            appendSystemMessage(sender, "Please select a recipient.");
            return;
        }

        if (message.isBlank()) {
            return;
        }

        appendChatMessage(sender, sender, recipient, message);

        ClientWindow recipientWindow = clientsByUsername.get(recipient);
        if (recipientWindow != null) {
            appendChatMessage(recipient, sender, recipient, message);
        } else {
            appendSystemMessage(sender, "Recipient is not available: " + recipient);
        }

        messageField.clear();
    }

    private void appendChatMessage(String viewingUser, String sender, String recipient, String message) {
        ClientWindow clientWindow = clientsByUsername.get(viewingUser);
        if (clientWindow == null) {
            return;
        }

        String timestamp = LocalTime.now().format(TIME_FORMAT);
        clientWindow.chatArea.appendText(
                "[" + timestamp + "] " + sender + " -> " + recipient + ": " + message + System.lineSeparator());
    }

    private void appendSystemMessage(String viewingUser, String message) {
        ClientWindow clientWindow = clientsByUsername.get(viewingUser);
        if (clientWindow == null) {
            return;
        }

        String timestamp = LocalTime.now().format(TIME_FORMAT);
        clientWindow.chatArea.appendText("[" + timestamp + "] System: " + message + System.lineSeparator());
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
            chatArea.appendText("Connected as " + username + System.lineSeparator());
        }
    }
}
