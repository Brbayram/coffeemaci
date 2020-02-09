package coffee.bootstrap;

import coffee.model.Drink;
import coffee.model.Inventory;
import coffee.repository.DrinkRepository;
import coffee.repository.InventoryRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import coffee.model.Drink;
import coffee.model.Inventory;
import coffee.repository.DrinkRepository;
import coffee.repository.InventoryRepository;

@Component
public class DataBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private InventoryRepository inventoryRepo;
    private DrinkRepository drinkRepo;

    public DataBootstrap( InventoryRepository inventoryRepo, DrinkRepository drinkRepo) {
        super();
        this.inventoryRepo = inventoryRepo;
        this.drinkRepo = drinkRepo;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

        createInventory();
        drink();
    }
    private void createInventory() {

        Inventory sugar = new Inventory();
        sugar.setItemName("sugar");
        sugar.setUnits(50);

        Inventory  cream = new Inventory ();
        cream.setItemName("cream");
        cream.setUnits(50);

        Inventory coffee = new Inventory();
        coffee.setItemName("coffee");
        coffee.setUnits(50);

        Inventory water = new Inventory();
        water.setItemName("water");
        water.setUnits(50);

        inventoryRepo.save(sugar);
        inventoryRepo.save(cream);
        inventoryRepo.save(coffee);
        inventoryRepo.save(water);

    }

    private void drink() {


        Drink coffee = new Drink();
        coffee.setCost(2.75);
        coffee.setName("coffee");
        coffee.getIngredients().put("coffee", 2);
        coffee.getIngredients().put("cream", 2);
        coffee.getIngredients().put("water", 2);

        Drink cappuccino = new Drink();
        cappuccino.setCost(2.90);
        cappuccino.setName("cappuccino");
        cappuccino.getIngredients().put("coffee", 2);
        cappuccino.getIngredients().put("cream", 2);
        cappuccino.getIngredients().put("sugar", 2);
        cappuccino.getIngredients().put("water", 2);


        Drink caffeMocha = new Drink();
        caffeMocha.setCost(3.90);
        caffeMocha.setName("caffe mocha");
        caffeMocha.getIngredients().put("coffee", 2);
        caffeMocha.getIngredients().put("sugar", 1);
        caffeMocha.getIngredients().put("cream", 2);
        caffeMocha.getIngredients().put("water", 2);

        drinkRepo.save(coffee);
        drinkRepo.save(cappuccino);
        drinkRepo.save(caffeMocha);
    }
}
