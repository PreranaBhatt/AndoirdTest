package Utils;


import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;

public class ResponseHelper {

    public static  Object getResponseAsObject(String responseString, Class responseClass) throws IOException {

        ObjectMapper objectMapper= new ObjectMapper() ;

        objectMapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return objectMapper.readValue(responseString, responseClass);
    }
}
