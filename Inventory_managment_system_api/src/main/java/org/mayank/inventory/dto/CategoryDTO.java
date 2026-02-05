package org.mayank.inventory.dto;

import org.mayank.inventory.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDTO {
    private String categoryid;
    private String name;
    private String description;
    private Set<Product> products;
}
