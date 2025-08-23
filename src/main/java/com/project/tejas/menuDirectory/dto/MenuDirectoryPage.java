package com.project.tejas.menuDirectory.dto;

import com.project.tejas.menuDirectory.entity.MenuItem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MenuDirectoryPage {
    private List<MenuItem> menuItemList;
    private RestaurantListing restaurantListing;
}
