package tests.api;

import io.qameta.allure.Description;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;
import static steps.api.VacanciesSteps.assertionFilterCityGetVacanciesStep;
import static steps.api.VacanciesSteps.getListCityResponseStep;

public class ApiTests {

    public static Stream<Object> dataProvider() {
        return Stream.of(
                arguments(
                        "Москва"
                ),
                arguments(
                        "Санкт-Петербург"
                ),
                arguments(
                        "Екатеринбург"
                ),
                arguments(
                        "Новосибирск"
                ),
                arguments(
                        "Омск"
                ),
                arguments(
                        "Пенза"
                ),
                arguments(
                        "Самара"
                ),
                arguments(
                        "Саратов"
                ),
                arguments(
                        "Томск"
                )
        );
    }

    @ParameterizedTest()
    @MethodSource("dataProvider")
    @Description(value = "Проверка, что response /api/vacancies/ присутсвует только один город, переданный в request")
    public void requestGetVacanciesiFelloTest(String city) {
        List<String> listCityResponse = getListCityResponseStep(city);
        assertionFilterCityGetVacanciesStep(listCityResponse, city);
    }
}
