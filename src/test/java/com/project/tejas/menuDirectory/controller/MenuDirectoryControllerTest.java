package com.project.tejas.menuDirectory.controller;

import com.project.tejas.menuDirectory.dto.MenuDirectoryPage;
import com.project.tejas.menuDirectory.dto.MenuItemDTO;
import com.project.tejas.menuDirectory.service.MenuDirectoryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

import static org.mockito.Mockito.*;

public class MenuDirectoryControllerTest {

    @Mock
    MenuDirectoryService menuDirectoryService;

    @InjectMocks
    MenuDirectoryController menuDirectoryController;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFetchRestaurantDetailsWithMenu(){
        Integer mockRestaurantId = 123;
        MenuDirectoryPage mockMenuDirectoryPage = new MenuDirectoryPage();
        when(menuDirectoryService.fetchMenuDirectoryPageDetails(mockRestaurantId)).thenReturn(mockMenuDirectoryPage);

        ResponseEntity<MenuDirectoryPage> response = menuDirectoryController.fetchRestaurantDetailsWithMenu(mockRestaurantId);

        assert response.getStatusCode() == HttpStatus.OK;
        assert response.getBody() == mockMenuDirectoryPage;
        verify(menuDirectoryService, times(1)).fetchMenuDirectoryPageDetails(mockRestaurantId);
    }

    @Test
    public void testAddItemToMenu(){
        MenuItemDTO mockMenuItem = new MenuItemDTO(1, "dish 1", "desc 1", true, 123L, 123, 1);
        when(menuDirectoryService.addMenuItemToDb(mockMenuItem)).thenReturn(mockMenuItem);

        ResponseEntity<MenuItemDTO> response = menuDirectoryController.addItemToMenu(mockMenuItem);
        
        assert response.getBody() == mockMenuItem;
        assert response.getStatusCode() == HttpStatus.CREATED;
        verify(menuDirectoryService, times(1)).addMenuItemToDb(mockMenuItem);
    }
}
