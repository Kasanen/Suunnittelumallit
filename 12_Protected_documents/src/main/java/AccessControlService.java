import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class AccessControlService {
    private static final AccessControlService INSTANCE = new AccessControlService();

    private final Map<String, Set<Integer>> permissions = new HashMap<>();

    private AccessControlService() {
    }

    public static AccessControlService getInstance() {
        return INSTANCE;
    }

    public boolean isAllowed(String username, int documentId) {
        Set<Integer> allowedDocs = permissions.get(username);
        return allowedDocs != null && allowedDocs.contains(documentId);
    }

    public void grantAccess(String username, int documentId) {
        permissions.computeIfAbsent(username, key -> new HashSet<>()).add(documentId);
    }
}
