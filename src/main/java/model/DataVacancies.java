package model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import java.util.List;

@NoArgsConstructor
@Getter
public class DataVacancies {
    private List<ItemsVacancies> items;
    private String total;
}
