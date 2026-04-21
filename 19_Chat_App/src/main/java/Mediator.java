import java.util.HashMap;
import java.util.Map;

public class Mediator implements ChatMediatorInterface {
    private Map<String, ChatUser> registeredUsers;

    public Mediator() {
        this.registeredUsers = new HashMap<>();
    }

    @Override
    public void registerUser(ChatUser user) {
        registeredUsers.put(user.getName(), user);
        notifyAllUsers(null, user.getName() + " has joined the chat.");
    }

    @Override
    public void unregisterUser(String username) {
        registeredUsers.remove(username);
        notifyAllUsers(null, username + " has left the chat.");
    }

    @Override
    public void sendMessage(String senderName, String recipientName, String message) {
        ChatUser sender = registeredUsers.get(senderName);
        ChatUser recipient = registeredUsers.get(recipientName);

        if (sender == null) {
            System.err.println("Sender " + senderName + " not found.");
            return;
        }

        if (recipient == null) {
            sender.receiveMessage(senderName, null, "Recipient " + recipientName + " is not available.");
            return;
        }

        recipient.receiveMessage(senderName, recipientName, message);
        sender.receiveMessage(senderName, recipientName, message);
    }

    private void notifyAllUsers(String senderName, String systemMessage) {
        for (ChatUser user : registeredUsers.values()) {
            user.receiveMessage(null, user.getName(), systemMessage);
        }
    }
}
