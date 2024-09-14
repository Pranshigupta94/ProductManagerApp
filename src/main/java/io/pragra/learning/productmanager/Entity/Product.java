package io.pragra.learning.productmanager.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class  Product {
    private Integer id;
    private String productName;
    private String description;
    private Double cost;
}
