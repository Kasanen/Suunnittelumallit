public class GeneralFeedbacks extends Handling {
    private static final String GENERAL_HANDLING_TYPE = "FEEDBACKS";

    @Override
    public void process(Message message) {
        if (message.getType().toString() == GENERAL_HANDLING_TYPE) {
            System.out.println("Feedback is being analyzed and responded!");
            System.out.println("Message: " + message.getContent());
            System.out.println("From: " + message.getSender());
        } else {
            System.out.println("Type did not match to: " + GENERAL_HANDLING_TYPE);
            super.process(message);
        }
    }
}
