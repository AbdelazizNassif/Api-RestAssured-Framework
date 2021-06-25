package utilities;

import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.path.json.JsonPath;

import java.io.*;
import java.util.Properties;

public class Utils {

    public static RequestSpecification requestSpecification = null;

    public RequestSpecification constructRequestSpecs(String contentType ) {
        //System.out.println("Print root: " + System.getProperty("user.dir"));
        if(requestSpecification == null) {
            try {
                PrintStream requestStream = new PrintStream(new FileOutputStream("request_logging.txt"));
                PrintStream responseStream = new PrintStream(new FileOutputStream("response_logging.txt"));

                requestSpecification = new RequestSpecBuilder().setBaseUri(getGlobalProperty("baseUri"))
                        .addFilter(RequestLoggingFilter.logRequestTo(requestStream))
                        .addFilter(ResponseLoggingFilter.logResponseTo(responseStream))
                        .build();
                if(contentType == "application/json")
                {
                    requestSpecification.contentType(contentType);
                }
                else if(contentType == "")
                {
                    // And SO ON
                }
            } catch (FileNotFoundException fnfExp) {
                System.out.println("File not found exception is thrown");
            }
            return requestSpecification;
        }
        return requestSpecification;
    }

    public static String getGlobalProperty(String propKey) {
        String valueOfProperty = null;
        try {
            String propFilePath = "C:/Users/SamirA7/OneDrive - Vodafone Group/Documents/Bdd_Framewrk_For_Api/src/test/java/utilities/globalProperties.properties";
            Properties prop = new Properties();
            FileInputStream fis = new FileInputStream(propFilePath);
            prop.load(fis);
            valueOfProperty = prop.getProperty(propKey);
        } catch (FileNotFoundException fnfExp) {
            System.out.println("File not found exception is thrown");
        }
        catch (IOException ioExp) {
            System.out.println("IO exception is thrown");
        }
        return valueOfProperty;
    }

    public static String getJsonValueFromJsonResponse(Response response, String jsonKey)
    {
        JsonPath RespJs = new JsonPath(response.asString());
        return RespJs.get(jsonKey).toString();
    }
}



