public class Controller implements ChatUser {
    private String username;
    private ChatMediatorInterface mediator;
    private MessageReceiver messageReceiver;

    public Controller(String username, ChatMediatorInterface mediator) {
        this.username = username;
        this.mediator = mediator;
        this.messageReceiver = null;
    }

    public void setMessageReceiver(MessageReceiver receiver) {
        this.messageReceiver = receiver;
    }

    public void sendMessage(String recipientName, String message) {
        mediator.sendMessage(username, recipientName, message);
    }

    @Override
    public String getName() {
        return username;
    }

    @Override
    public void receiveMessage(String senderName, String recipientName, String message) {
        if (messageReceiver != null) {
            messageReceiver.onMessageReceived(senderName, recipientName, message);
        }
    }

    public interface MessageReceiver {
        void onMessageReceived(String sender, String recipient, String message);
    }
}
