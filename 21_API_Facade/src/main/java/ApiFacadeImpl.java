import java.io.IOException;
import org.json.simple.parser.ParseException;

public class ApiFacadeImpl implements ApiFacade {

    private HttpRequestHandler httpHandler;
    private JsonParser jsonParser;

    public ApiFacadeImpl() {
        this.httpHandler = new HttpRequestHandler();
        this.jsonParser = new JsonParser();
    }

    @Override
    public String getAttributeValueFromJson(String urlString, String attributeName)
            throws IllegalArgumentException, IOException, ParseException {
        String json = httpHandler.sendGetRequest(urlString);
        return jsonParser.extractAttribute(json, attributeName);
    }
}