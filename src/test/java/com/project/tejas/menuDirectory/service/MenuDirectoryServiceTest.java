package com.project.tejas.menuDirectory.service;

import com.project.tejas.menuDirectory.dto.MenuDirectoryPage;
import com.project.tejas.menuDirectory.dto.MenuItemDTO;
import com.project.tejas.menuDirectory.dto.RestaurantListing;
import com.project.tejas.menuDirectory.entity.MenuItem;
import com.project.tejas.menuDirectory.mapper.MenuItemMapper;
import com.project.tejas.menuDirectory.repo.MenuItemRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

public class MenuDirectoryServiceTest {

    @Mock
    MenuItemRepo menuItemRepo;

    @Mock
    RestTemplate restTemplate;

    @InjectMocks
    MenuDirectoryService menuDirectoryService;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFetchMenuDirectoryPageDetails(){
        Integer mockRestaurantId = 123;
        List<MenuItem> mockMenuItemList = Arrays.asList(
                new MenuItem(1, "dish 1", "desc 1", true, 123L, 10, 1),
                new MenuItem(2, "dish 2", "desc 2", false, 234L, 23, 1)
        );
        RestaurantListing mockRestaurantListing = new RestaurantListing(1, "Restaurant 1", "Address 1", "city 1", "Desc 1");
        when(menuItemRepo.findByRestaurantId(mockRestaurantId)).thenReturn(mockMenuItemList);
        when(restTemplate.getForObject(anyString(), eq(RestaurantListing.class))).thenReturn(mockRestaurantListing);

        MenuDirectoryPage response = menuDirectoryService.fetchMenuDirectoryPageDetails(mockRestaurantId);

        assertEquals(mockMenuItemList, response.getMenuItemList());
        assertEquals(mockRestaurantListing, response.getRestaurantListing());
        verify(menuItemRepo, times(1)).findByRestaurantId(mockRestaurantId);
        verify(restTemplate, times(1)).getForObject(anyString(), eq(RestaurantListing.class));
    }

    @Test
    public void testAddMenuItemToDb(){
        MenuItemDTO mockMenuItemDTO = new MenuItemDTO(1, "dish 1", "Desc 1 ", true, 123L, 10, 1);
        MenuItem mockMenuItem = MenuItemMapper.INSTANCE.mapMenuDirectoryDTOtoMenuDirectory(mockMenuItemDTO);
        when(menuItemRepo.save(mockMenuItem)).thenReturn(mockMenuItem);

        MenuItemDTO resultDTO = menuDirectoryService.addMenuItemToDb(mockMenuItemDTO);

        assertEquals(mockMenuItemDTO, resultDTO);
        verify(menuItemRepo, times(1)).save(mockMenuItem);
    }
}
