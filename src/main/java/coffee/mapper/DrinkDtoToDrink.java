package coffee.mapper;

import coffee.dto.DrinkDto;
import coffee.model.Drink;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import lombok.Synchronized;

@Component
public class DrinkDtoToDrink implements Converter<DrinkDto, Drink> {

    @Synchronized
    @Override
    public Drink convert(DrinkDto source) {

        final Drink drink = new Drink();

        drink.setId(source.getId());
        drink.setCost(source.getCost());
        drink.setFilePath(source.getFilePath());
        drink.setName(source.getName());
        drink.setIngredients(source.getIngredients());

        return drink;
    }


}
