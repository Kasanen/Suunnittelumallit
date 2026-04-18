public class Book implements Cloneable {
    private String author;
    private String title;
    private String genre;
    private int publicationYear;

    public Book(String author, String title, String genre, int publicationYear) {
        this.author = author;
        this.title = title;
        this.genre = genre;
        this.publicationYear = publicationYear;
    }

    public Book clone() {
        try {
            return (Book) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("This should not happen since we implement Cloneable", e);
        }
    }

    @Override
    public String toString() {
        return author + " - " + title + " - " + genre + " (" + publicationYear + ")";
    }
}
