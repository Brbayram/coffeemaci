package coffee.dto;

import java.util.HashMap;
import java.util.Map;

import lombok.Data;

@Data
public class DrinkDto {

    private Long id;

    private String name;

    private Double cost;

    private Map<String, Integer> ingredients = new HashMap<>();

    private String filePath;

    public DrinkDto(String name, Double cost, Map<String, Integer> ingredients, String filePath) {
        super();
        this.name = name;
        this.cost = cost;
        this.ingredients = ingredients;
        this.filePath = filePath;
    }

    public DrinkDto() {
        super();
    }




}
