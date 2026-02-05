package org.mayank.inventory.dto;

import org.mayank.inventory.entity.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {

    private Long productid;
    private String name;
    private String description;
    private double price;
    private int quantity;
    private Category category;
    private Set<String> shipmentIds;
    private Set<String> warehouseIds;
}
