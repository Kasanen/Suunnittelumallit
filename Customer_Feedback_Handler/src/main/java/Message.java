public class Message {
    public enum MessageType {
        CLAIMS, REQUESTS, SUGGESTIONS, FEEDBACKS
    }
    private MessageType messageType;
    private String content;
    private String senderEmail;

    public Message(MessageType messageType, String content, String senderEmail) {
        this.messageType = messageType;
        this.content = content;
        this.senderEmail = senderEmail;
    }

    public MessageType getType() {
        return messageType;
    }

    public String getContent() {
        return content;
    }

    public String getSender() {
        return senderEmail;
    }
}
