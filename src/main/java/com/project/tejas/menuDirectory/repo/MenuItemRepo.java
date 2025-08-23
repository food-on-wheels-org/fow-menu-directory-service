package com.project.tejas.menuDirectory.repo;

import com.project.tejas.menuDirectory.dto.MenuItemDTO;
import com.project.tejas.menuDirectory.entity.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuItemRepo extends JpaRepository<MenuItem, Integer> {
    List<MenuItem> findByRestaurantId(Integer restaurantId);
}
