package org.mayank.inventory.service;

import org.mayank.inventory.dto.WarehouseDTO;

public interface WarehouseService {
    WarehouseDTO rewriteWarehouse(WarehouseDTO warehouseDTO); //put

    WarehouseDTO createWarehouse(WarehouseDTO warehouseDTO);

    WarehouseDTO updateWarehouse(WarehouseDTO warehouseDTO, Long id);

    WarehouseDTO getWarehouseById(Long id);

    void deleteWarehouse(Long warehouseId);
}
