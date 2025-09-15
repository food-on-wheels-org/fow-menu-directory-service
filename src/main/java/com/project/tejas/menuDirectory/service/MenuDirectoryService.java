package com.project.tejas.menuDirectory.service;

import com.project.tejas.menuDirectory.dto.MenuDirectoryPage;
import com.project.tejas.menuDirectory.dto.MenuItemDTO;
import com.project.tejas.menuDirectory.dto.RestaurantListing;
import com.project.tejas.menuDirectory.entity.MenuItem;
import com.project.tejas.menuDirectory.mapper.MenuItemMapper;
import com.project.tejas.menuDirectory.repo.MenuItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class MenuDirectoryService {
    @Autowired
    MenuItemRepo menuItemRepo;

    @Autowired
    RestTemplate restTemplate;

    public MenuDirectoryPage fetchMenuDirectoryPageDetails(Integer restaurantId){
        List<MenuItem> menuItemList = fetchMenuItemsList(restaurantId);
        RestaurantListing restaurantListing = fetchDetailsFromRestaurantListingService(restaurantId);
        return createMenuDirectory(menuItemList, restaurantListing);
    }

    private MenuDirectoryPage createMenuDirectory(List<MenuItem> menuItemList, RestaurantListing restaurantListing) {
        MenuDirectoryPage menuDirectoryPage = new MenuDirectoryPage();
        menuDirectoryPage.setMenuItemList(menuItemList);
        menuDirectoryPage.setRestaurantListing(restaurantListing);
        return menuDirectoryPage;
    }

    private RestaurantListing fetchDetailsFromRestaurantListingService(Integer restaurantId) {
        return restTemplate.getForObject("http://RESTAURANT-SERVICE/restaurant/fetchRestaurantById/" + restaurantId, RestaurantListing.class);
    }

    private List<MenuItem> fetchMenuItemsList(Integer restaurantId) {
        return menuItemRepo.findByRestaurantId(restaurantId);
    }

    public MenuItemDTO addMenuItemToDb(MenuItemDTO menuItemDTO){
        MenuItem addedItem = menuItemRepo.save(MenuItemMapper.INSTANCE.mapMenuDirectoryDTOtoMenuDirectory(menuItemDTO));
        return MenuItemMapper.INSTANCE.mapMenuDirectoryToMenuDirectoryDTO(addedItem);
    }
}
