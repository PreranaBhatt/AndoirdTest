package Utils;


import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.annotate.JsonSerialize;

public class RequestHelper {


    public static String getJSONString(Object o)
    {
        ObjectMapper objectMapper=new ObjectMapper();//ObjectMAppper is a class in Jackson Library
        //provides functionality for reading and writing JSON, either to and from basic POJOs (Plain Old Java Objects),
        // or to and from a general-purpose JSON Tree Model (JsonNode)


        objectMapper.getSerializationConfig().setSerializationInclusion(JsonSerialize.Inclusion.NON_NULL);
        //field of objectmapper :Configuration object that defines basic global settings for the serialization process.

        try{
            return  objectMapper.writeValueAsString(o);
        }
        catch(Exception e)
        {
            e.printStackTrace();

        }

        return  "";
    }
}
