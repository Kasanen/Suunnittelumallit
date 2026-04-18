import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        RecommendationManager manager = RecommendationManager.getInstance();

        // Pre-load some data
        Recommendation teenFantasy = new Recommendation("Teen Fantasy");
        teenFantasy.addBook(new Book("Harry Potter", "J.K. Rowling", "Fantasy", 1997));
        teenFantasy.addBook(new Book("Percy Jackson", "Rick Riordan", "Fantasy", 2005));
        manager.addRecommendation(teenFantasy);

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n1. View all recommendations");
            System.out.println("2. Clone a recommendation");
            System.out.println("3. Add book to a recommendation");
            System.out.println("4. Save cloned recommendation");
            System.out.println("5. Exit");
            System.out.print("> ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    manager.listAll();
                    break;

                case "2":
                    System.out.print("Enter audience to clone: ");
                    String audience = scanner.nextLine();
                    Recommendation cloned = manager.cloneRecommendation(audience);
                    if (cloned != null) {
                        System.out.print("Enter new audience name: ");
                        String newAudience = scanner.nextLine();
                        cloned.setTargetAudience(newAudience);
                        manager.addRecommendation(cloned);
                        System.out.println("Cloned and saved as: " + newAudience);
                    }
                    break;

                case "3":
                    System.out.print("Enter audience to add book to: ");
                    String target = scanner.nextLine();
                    Recommendation rec = manager.getRecommendation(target);
                    if (rec != null) {
                        System.out.print("Title: ");
                        String title = scanner.nextLine();
                        System.out.print("Author: ");
                        String author = scanner.nextLine();
                        System.out.print("Genre: ");
                        String genre = scanner.nextLine();
                        System.out.print("Year: ");
                        int year = Integer.parseInt(scanner.nextLine());
                        rec.addBook(new Book(title, author, genre, year));
                        System.out.println("Book added!");
                    } else {
                        System.out.println("Recommendation not found.");
                    }
                    break;

                case "5":
                    running = false;
                    break;

                default:
                    System.out.println("Invalid choice, try again.");
            }
        }
        scanner.close();
    }
}