package com.project.tejas.menuDirectory.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RestaurantListing {
    private int id;
    private String name;
    private String address;
    private String city;
    private String restaurantDescription;
}
