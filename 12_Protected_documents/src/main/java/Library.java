import java.util.HashMap;
import java.util.Map;

public class Library {
    private final Map<Integer, Document> documents = new HashMap<>();

    public void addUnprotectedDocument(int documentId, Document realDocument) {
        documents.put(documentId, realDocument);
    }

    public void addProtectedDocument(int documentId, Document realDocument) {
        Document proxy = new DocumentProxy(realDocument);
        documents.put(documentId, proxy);
    }

    public Document getDocument(int documentId) {
        return documents.get(documentId);
    }
}
