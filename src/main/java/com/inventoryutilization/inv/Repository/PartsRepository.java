package com.inventoryutilization.inv.Repository;

import com.inventoryutilization.inv.Model.Part;
import org.springframework.data.repository.CrudRepository;

public interface PartsRepository extends CrudRepository<Part,Long> {
    //find and count parts by status and archived
    Iterable<Part> findAllByStatusTrueAndByArchivedTrue();
    Iterable<Part> findAllByStatusFalseAndByArchivedTrue();
    Iterable<Part> findAllByStatusTrueAndByArchivedFalse();
    Iterable<Part> findAllByStatusFalseAndByArchivedFalse();
    Long countAllByStatusTrueAndByArchivedTrue();
    Long countAllByStatusFalseAndByArchivedTrue();
    Long countAllByStatusTrueAndByArchivedFalse();
    Long countAllByStatusFalseAndByArchivedFalse();
}
