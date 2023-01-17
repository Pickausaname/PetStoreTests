package Resources;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class Specifications {

    public static RequestSpecification requestSpecification;
    public static RequestSpecification requestSpecificationForWriteOperations;
    static PrintStream printStream;

    public static RequestSpecification getBasicRequestSpecification() throws FileNotFoundException {
        if (requestSpecification == null) {
            printStream = new PrintStream(new FileOutputStream("MyLogs.txt"));
            requestSpecification = new RequestSpecBuilder().setBaseUri("https://petstore.swagger.io/v2")
                    .addHeader("Accept", "application/json")
                    .addFilter(RequestLoggingFilter.logRequestTo(printStream))
                    .addFilter(ResponseLoggingFilter.logResponseTo(printStream))
                    .build();
        }
        return requestSpecification;
    }

    public static RequestSpecification getRequestSpecificationForWriteOperations() throws FileNotFoundException {
        requestSpecificationForWriteOperations = new RequestSpecBuilder().addRequestSpecification(getBasicRequestSpecification())
                .addHeader("Content-Type", "application/json").build();
        return requestSpecificationForWriteOperations;
    }
}
