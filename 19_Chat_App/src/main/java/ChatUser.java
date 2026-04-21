public interface ChatUser {
    String getName();

    void receiveMessage(String sender, String recipient, String message);
}
