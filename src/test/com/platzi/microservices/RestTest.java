package test.com.platzi.microservices;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import main.com.platzi.simple.UserPojo;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

public class RestTest {
    private Thread thread = null;
    private Runnable task = () -> {
        System.out.println(this.thread.getName());
        this.shouldGetUserPojo();
    };
    private RequestSpecification spec = this.initSpec();
    private UserPojo mockUser = new UserPojo(1, 0, "Pepe", "Lopera", "pepe@gmail", "taurus", "1972-12-15");

    private UserPojo getUserRequest(String path, int status) {
        return given()
                .spec(spec)
                .when()
                .get(path)
                .then()
                .statusCode(status)
                .extract().as(UserPojo.class);
    }

    private RequestSpecification initSpec() {
        return new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setBaseUri("http://localhost:8080/")
                .addFilter(new ResponseLoggingFilter()) //debugging: log response
                .addFilter(new RequestLoggingFilter()) //debugging: log request
                .build();
    }

    public void runTask() {
        thread = new Thread(this.task, "Thread-microservice-rest");
        thread.start();
    }

    @Test
    private void shouldGetUserPojo() {
        UserPojo requestUser = getUserRequest("/user", 200);

        assertThat(requestUser.getName()).isEqualTo(mockUser.getName());
        assertThat(requestUser.getSurname()).isEqualTo(mockUser.getSurname());
        assertThat(requestUser.getEmail()).isEqualTo(mockUser.getEmail());
    }
}
