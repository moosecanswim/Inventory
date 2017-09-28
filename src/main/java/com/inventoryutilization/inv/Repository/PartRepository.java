package com.inventoryutilization.inv.Repository;

import com.inventoryutilization.inv.Model.Part;
import org.springframework.data.repository.CrudRepository;

public interface PartRepository extends CrudRepository<Part,Long> {
}
