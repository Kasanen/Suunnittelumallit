public class CompensationClaims extends Handling {
    private static final String COMPENSATION_HANDLING_TYPE = "CLAIMS";

    @Override
    public void process(Message message) {
        if (message.getType().toString() == COMPENSATION_HANDLING_TYPE) {
            System.out.println("Compensation claim is being reviewed!");
            System.out.println("Message: " + message.getContent());
            System.out.println("From: " + message.getSender());
        } else {
            System.out.println("Type did not match to: " + COMPENSATION_HANDLING_TYPE);
            super.process(message);
        }
    }
}
