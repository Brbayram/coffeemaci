package coffee.mapper;

import coffee.dto.DrinkDto;
import coffee.model.Drink;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import coffee.dto.DrinkDto;
import coffee.model.Drink;

import lombok.Synchronized;

@Component
public class DrinkToDrinkDtoMapper implements Converter<Drink, DrinkDto> {

    @Synchronized
    @Override
    public DrinkDto convert(Drink source) {


        final DrinkDto dto = new DrinkDto();
        dto.setCost(source.getCost());
        dto.setFilePath(source.getFilePath());
        dto.setId(source.getId());
        dto.setIngredients(source.getIngredients());
        dto.setName(source.getName());

        return dto;
    }

}
