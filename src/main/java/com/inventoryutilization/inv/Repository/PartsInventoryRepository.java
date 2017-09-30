package com.inventoryutilization.inv.Repository;

import com.inventoryutilization.inv.Model.Part;
import com.inventoryutilization.inv.Model.PartInventory;
import org.springframework.data.repository.CrudRepository;

public interface PartsInventoryRepository extends CrudRepository<PartInventory, Long> {
    public PartInventory findByAPart(Part aPart);
}
