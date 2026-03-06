public class DevelopmentSuggestions extends Handling {
    private static final String DEVELOPMENT_HANDLING_TYPE = "SUGGESTIONS";

    @Override
    public void process(Message message) {
        if (message.getType().toString() == DEVELOPMENT_HANDLING_TYPE) {
            System.out.println("Development suggestions are being logged and prioritized!");
            System.out.println("Message: " + message.getContent());
            System.out.println("From: " + message.getSender());
        } else {
            System.out.println("Type did not match to: " + DEVELOPMENT_HANDLING_TYPE);
            super.process(message);
        }
    }
}
