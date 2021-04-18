package model;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Getter
public class VacanciesiFello {
    private String message;
    private List<DataVacancies> data;
}
