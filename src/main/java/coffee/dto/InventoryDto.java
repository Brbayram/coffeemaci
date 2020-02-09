package coffee.dto;

import lombok.Data;

@Data
public class InventoryDto {

    private Long id;
    private String itemName;
    private int units;
    public InventoryDto(String itemName, int units) {
        super();
        this.itemName = itemName;
        this.units = units;
    }
    public InventoryDto() {
        super();
    }


}
