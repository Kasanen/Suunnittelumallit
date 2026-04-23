import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

class JsonParser {
    String extractAttribute(String json, String attributeName) throws IllegalArgumentException, ParseException {
        JSONParser parser = new JSONParser();
        JSONObject jsonObject = (JSONObject) parser.parse(json);

        return (String) jsonObject.get(attributeName);
    }
}
