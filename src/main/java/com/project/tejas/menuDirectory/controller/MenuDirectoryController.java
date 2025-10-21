package com.project.tejas.menuDirectory.controller;

import com.project.tejas.menuDirectory.dto.MenuDirectoryPage;
import com.project.tejas.menuDirectory.dto.MenuItemDTO;
import com.project.tejas.menuDirectory.service.MenuDirectoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/menuDirectory")
@CrossOrigin
@Tag(name = "Menu Directory Controller", description = "Endpoints for managing menu of any restaurant")
public class MenuDirectoryController {
    @Autowired
    MenuDirectoryService menuDirectoryService;

    @Operation(summary = "Fetch restaurant and it's menu by ID", description = "Retrieves restaurant and corresponding menu details using restaurant ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved restaurant details",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = MenuDirectoryPage.class))),
            @ApiResponse(responseCode = "404", description = "Restaurant not found", content = @Content)
    })
    @GetMapping("/fetchRestaurantAndMenuById/{restaurantId}")
    public ResponseEntity<MenuDirectoryPage> fetchRestaurantDetailsWithMenu(@PathVariable Integer restaurantId){
        MenuDirectoryPage menuDirectoryPage = menuDirectoryService.fetchMenuDirectoryPageDetails(restaurantId);
        return new ResponseEntity<>(menuDirectoryPage, HttpStatus.OK);
    }

    @Operation(summary = "Add a new menu item", description = "Adds a new menu item to the database for a restaurant")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Menu item created successfully",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = MenuItemDTO.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input provided", content = @Content)
    })
    @PostMapping("/addMenuItem")
    public ResponseEntity<MenuItemDTO> addItemToMenu(@RequestBody MenuItemDTO menuItemDTO){
        MenuItemDTO newItem = menuDirectoryService.addMenuItemToDb(menuItemDTO);
        return new ResponseEntity<>(newItem, HttpStatus.CREATED);
    }
}
