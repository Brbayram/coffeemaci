package coffee.mapper;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import coffee.dto.InventoryDto;
import coffee.model.Inventory;

import lombok.Synchronized;

@Component
public class InventoryDtoToInventory implements Converter<InventoryDto, Inventory> {

    @Synchronized
    @Override
    public Inventory convert(InventoryDto source) {

        Inventory inventory = new Inventory();

        inventory.setId(source.getId());
        inventory.setItemName(source.getItemName());
        inventory.setUnits(source.getUnits());

        return inventory;
    }

}
