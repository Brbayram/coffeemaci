package coffee.ServiceImpl;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import coffee.dto.DrinkDto;
import coffee.mapper.DrinkDtoToDrink;
import coffee.mapper.DrinkToDrinkDtoMapper;
import coffee.model.Drink;
import coffee.repository.DrinkRepository;

@Service
public class CoffeeService {

    private InventoryService inventoryUtil;
    private DrinkRepository drinkRepo;
    private DrinkToDrinkDtoMapper toDto;
    private DrinkDtoToDrink toDrink;

    public CoffeeService(InventoryService inventoryUtil, DrinkRepository drinkRepo, DrinkToDrinkDtoMapper toDto,
                         DrinkDtoToDrink toDrink) {
        super();
        this.inventoryUtil = inventoryUtil;
        this.drinkRepo = drinkRepo;
        this.toDto = toDto;
        this.toDrink = toDrink;
    }


    public List<DrinkDto> getMenu() {

        List<Drink> drinks = drinkRepo.findAll();

        return drinks.stream().map( d -> toDto.convert(d)).collect(Collectors.toList());

    }

    public DrinkDto makeDrink(Long drinkId) {

        Drink drink = drinkRepo.findOne(drinkId);

//		 drink.getIngredients().stream().forEach( i -> inventory.deduct(i.getName(), i.getUnits()));

        drink.getIngredients().entrySet().stream().forEach( e -> {
            inventoryUtil.deduct(e.getKey(), e.getValue());
        });

        return toDto.convert(drink);

    }

    public DrinkDto saveDrink(DrinkDto drinkDto) {
        return toDto.convert(drinkRepo.save(toDrink.convert(drinkDto)));
    }

    public DrinkDto findOne(Long drinkId) {

        Drink drink = drinkRepo.findOne(drinkId);
        if(drink != null) {
            return toDto.convert( drink );
        }else
            return toDto.convert(null);
    }
}
