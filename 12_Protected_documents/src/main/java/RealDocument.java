import java.time.LocalDate;

public class RealDocument implements Document {
    private final int id;
    private final LocalDate date;
    private final String content;

    public RealDocument(int id, LocalDate date, String content) {
        this.id = id;
        this.date = date;
        this.content = content;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public LocalDate getDate() {
        return date;
    }

    @Override
    public String getContent(User user) {
        return content;
    }
}