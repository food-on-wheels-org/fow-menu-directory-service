package com.project.tejas.menuDirectory.controller;

import com.project.tejas.menuDirectory.dto.MenuDirectoryPage;
import com.project.tejas.menuDirectory.dto.MenuItemDTO;
import com.project.tejas.menuDirectory.service.MenuDirectoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/menuDirectory")
public class MenuDirectoryController {
    @Autowired
    MenuDirectoryService menuDirectoryService;

    @GetMapping("/fetchRestaurantAndMenuById/{restaurantId}")
    public ResponseEntity<MenuDirectoryPage> fetchRestaurantDetailsWithMenu(@PathVariable Integer restaurantId){
        MenuDirectoryPage menuDirectoryPage = menuDirectoryService.fetchMenuDirectoryPageDetails(restaurantId);
        return new ResponseEntity<>(menuDirectoryPage, HttpStatus.OK);
    }

    @PostMapping("/addMenuItem")
    public ResponseEntity<MenuItemDTO> addItemToMenu(@RequestBody MenuItemDTO menuItemDTO){
        MenuItemDTO newItem = menuDirectoryService.addMenuItemToDb(menuItemDTO);
        return new ResponseEntity<>(newItem, HttpStatus.CREATED);
    }
}
