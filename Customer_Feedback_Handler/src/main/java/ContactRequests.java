public class ContactRequests extends Handling {
    private static final String CONTACT_HANDLING_TYPE = "REQUESTS";

    @Override
    public void process(Message message) {
        if (message.getType().toString() == CONTACT_HANDLING_TYPE) {
            System.out.println("Contact request is being forwarded to the appropriate department!");
            System.out.println("Message: " + message.getContent());
            System.out.println("From: " + message.getSender());
        } else {
            System.out.println("Type did not match to: " + CONTACT_HANDLING_TYPE);
            super.process(message);
        }
    }
}
