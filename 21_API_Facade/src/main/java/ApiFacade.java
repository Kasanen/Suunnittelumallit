import java.io.IOException;
import org.json.simple.parser.ParseException;

public interface ApiFacade {
    String getAttributeValueFromJson(String urlString, String attributeName)
            throws IllegalArgumentException, IOException, ParseException;
}