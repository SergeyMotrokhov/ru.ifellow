package spec;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static helper.Helper.*;

public class Spec {

    public static RequestSpecification getVacanciesiFelloRequestSpecification() {
        return new RequestSpecBuilder()
                .setBaseUri(URL)
                .setBasePath(BASE_PATH + "vacancies/")
                .setContentType(ContentType.JSON)
                .addFilter(new AllureRestAssured())
                .build();
    }
}
