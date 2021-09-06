package validation.spec;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.ResponseSpecification;

import static org.apache.http.HttpStatus.SC_BAD_REQUEST;
import static org.apache.http.HttpStatus.SC_CREATED;
import static org.apache.http.HttpStatus.SC_NO_CONTENT;
import static org.apache.http.HttpStatus.SC_OK;

public class ResponseSpec {

    public static ResponseSpecification expect200StatusCode = new ResponseSpecBuilder()
            .expectStatusCode(SC_OK)
            .expectContentType(ContentType.JSON)
            .log(LogDetail.ALL)
            .build();

    public static ResponseSpecification expect201StatusCode = new ResponseSpecBuilder()
            .expectStatusCode(SC_CREATED)
            .expectContentType(ContentType.JSON)
            .log(LogDetail.ALL)
            .build();

    public static ResponseSpecification expect204StatusCode = new ResponseSpecBuilder()
            .expectStatusCode(SC_NO_CONTENT)
            .log(LogDetail.ALL)
            .build();

    public static ResponseSpecification expect400StatusCode = new ResponseSpecBuilder()
            .expectStatusCode(SC_BAD_REQUEST)
            .expectContentType(ContentType.JSON)
            .log(LogDetail.ALL)
            .build();
}
