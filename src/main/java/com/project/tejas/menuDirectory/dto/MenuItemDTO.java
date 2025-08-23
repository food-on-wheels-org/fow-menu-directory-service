package com.project.tejas.menuDirectory.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MenuItemDTO {
    private int id;
    private String dishName;
    private String dishDescription;
    private boolean isVeg;
    private Long price;
    private Integer restaurantId;
    private Integer quantity;
}
