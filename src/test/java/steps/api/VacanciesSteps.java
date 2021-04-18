package steps.api;

import io.qameta.allure.Step;
import io.restassured.path.json.JsonPath;
import model.DataVacancies;
import model.ItemsVacancies;
import model.VacanciesiFello;
import org.assertj.core.api.SoftAssertions;

import java.util.ArrayList;
import java.util.List;

import static helper.Helper.*;
import static io.restassured.RestAssured.given;
import static spec.Spec.getVacanciesiFelloRequestSpecification;
import static steps.api.JsonMappingStep.vacanciesiFelloFromJson;

public class VacanciesSteps {

    @Step("Получение списка городов из ответа запроса")
    public static List<String> getListCityResponseStep(String city) {
        List<String> listCity;
        List<String> list = new ArrayList<>();
        int n = 0;
        do {
            List<VacanciesiFello> response = requestGetVacanciesiFello(n, city);
            listCity = getCityFromResponseList(response);
            list.addAll(listCity);
            n++;
        }
        while (listCity.size() != 0);
        return list;
    }

    @Step("Проверка, что в ответе метода есть город, по которому указан фильтр")
    public static void assertionFilterCityGetVacanciesStep(List<String> list, String city) {
        SoftAssertions softy = new SoftAssertions();
        for (String l : list) {
            softy.assertThat(l).as("В ответе метода должен быть только город <%s>", city).isEqualTo(city);
        }
        softy.assertAll();
    }

    private static List<VacanciesiFello> requestGetVacanciesiFello(int page, String city) {
        JsonPath extract = new JsonPath(given()
                .spec(getVacanciesiFelloRequestSpecification())
                .when()
                .get(getParams(page, city).toString())
                .then()
                //.log().all()
                .statusCode(200)
                .extract().asString());
        return vacanciesiFelloFromJson(extract);
    }

    private static StringBuilder getParams(int page, String city) {
        StringBuilder stringBuilder = new StringBuilder()
                .append("?page=" + page)
                .append("&filter[city]=" + city)
                .append("&sort[name]=" + SORT)
                .append("&limit=" + LIMIT);
        return stringBuilder;
    }


    private static List<String> getCityFromResponseList(List<VacanciesiFello> response) {
        List<String> list = new ArrayList<>();
        for (VacanciesiFello r : response) {
            for (DataVacancies d : r.getData()) {
                try {
                    for (ItemsVacancies it : d.getItems()) {
                        list.add(it.getCity());
                    }
                } catch (NullPointerException e) {
                    e.getCause();
                }
            }
        }
        return list;
    }

}
