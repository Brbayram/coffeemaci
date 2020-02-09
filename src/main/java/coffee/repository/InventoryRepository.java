package coffee.repository;

import java.util.List;

import coffee.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Long> {

    Inventory findByitemName(String itemName);

    @Query(value="select n.itemName from Inventory n")
    List<String> getAllItems();

}
