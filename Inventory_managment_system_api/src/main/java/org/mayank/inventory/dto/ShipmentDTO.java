package org.mayank.inventory.dto;

import org.mayank.inventory.entity.Product;
import org.mayank.inventory.entity.Warehouse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShipmentDTO {

    private Long shipmentid;
    private String status;
    private String tracking_number;
    private Set<Product> products;
    private Set<Warehouse> warehouses;
}
