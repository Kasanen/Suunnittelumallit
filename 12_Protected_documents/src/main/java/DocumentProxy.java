import java.time.LocalDate;

public class DocumentProxy implements Document {
    private final Document realDocument;

    public DocumentProxy(Document realDocument) {
        this.realDocument = realDocument;
    }

    @Override
    public int getId() {
        return realDocument.getId();
    }

    @Override
    public LocalDate getDate() {
        return realDocument.getDate();
    }

    @Override
    public String getContent(User user) {
        if (AccessControlService.getInstance().isAllowed(user.getUsername(), realDocument.getId())) {
            return realDocument.getContent(user);
        } else {
            return "Access denied";
        }
    }
}