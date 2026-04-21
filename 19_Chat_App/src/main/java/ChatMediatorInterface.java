public interface ChatMediatorInterface {
    void registerUser(ChatUser user);

    void unregisterUser(String username);

    void sendMessage(String senderName, String recipientName, String message);
}
