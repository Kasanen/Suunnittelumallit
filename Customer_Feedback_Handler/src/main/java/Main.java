public class Main {

    public static void main(String[] args) {

        Handling primaryHandler;

        Handling compensationClaims = new CompensationClaims();
        Handling contactRequests = new ContactRequests();
        Handling develompentSuggetions = new DevelopmentSuggestions();
        Handling generalFeedback = new GeneralFeedbacks();

        compensationClaims.setNextHandler(contactRequests);
        contactRequests.setNextHandler(develompentSuggetions);
        develompentSuggetions.setNextHandler(generalFeedback);

        primaryHandler = compensationClaims;

        // Development suggestion from customer
        Message message = new Message(Message.MessageType.SUGGESTIONS, "Hey, I've got an idea!", "sender@mail.com");
        primaryHandler.process(message);
    }
}
