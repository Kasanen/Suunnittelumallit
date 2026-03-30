import java.time.LocalDate;

public interface Document {
    int getId();
    LocalDate getDate();
    String getContent(User user);
}