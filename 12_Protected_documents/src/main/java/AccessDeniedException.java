public class AccessDeniedException extends Exception {
    private static final String message = "Access denied!";

    public AccessDeniedException() {
        super(message);
    }

    public static String getDefaultMessage() {
        return message;
    }
}