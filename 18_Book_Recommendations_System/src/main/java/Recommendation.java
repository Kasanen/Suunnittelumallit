import java.util.ArrayList;
import java.util.List;

public class Recommendation implements Cloneable {
    private String targetAudience;
    private List<Book> books;

    public Recommendation(String targetAudience) {
        this.targetAudience = targetAudience;
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBook(Book title) {
        for (Book book : books) {
            if (book.equals(title)) {
                books.remove(book);
                break;
            }
        }
    }

    public void setTargetAudience(String targetAudience) {
        this.targetAudience = targetAudience;
    }

    public String getTargetAudience() {
        return targetAudience;
    }

    public List<Book> getBooks() {
        return books;
    }

    @Override
    public Recommendation clone() {
        try {
            Recommendation clonedRecommendation = (Recommendation) super.clone();
            clonedRecommendation.books = new ArrayList<>();
            // deep copy
            for (Book book : this.books) {
                clonedRecommendation.addBook(book.clone());
            }
            return clonedRecommendation;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Audience: ").append(targetAudience).append("\n");
        for (Book b : books) {
            sb.append("  - ").append(b).append("\n");
        }
        return sb.toString();
    }
}
