import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        User user1 = new User("alice");
        User user2 = new User("bob");

        Document protectedDoc = new RealDocument(1, LocalDate.now(), "secret text");
        Document doc1 = new DocumentProxy(protectedDoc);

        Document publicDoc = new RealDocument(2, LocalDate.now(), "public info");

        System.out.println("Alice tries protected: " + doc1.getContent(user1));
        System.out.println("Bob tries protected: " + doc1.getContent(user2));

        AccessControlService.getInstance().grantAccess("alice", 1);

        System.out.println("Alice tries protected after grant: " + doc1.getContent(user1));
        System.out.println("Bob tries protected after grant: " + doc1.getContent(user2));

        System.out.println("Alice reads public: " + publicDoc.getContent(user1));
        System.out.println("Bob reads public: " + publicDoc.getContent(user2));

    }
}