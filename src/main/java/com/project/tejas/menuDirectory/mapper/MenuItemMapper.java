package com.project.tejas.menuDirectory.mapper;

import com.project.tejas.menuDirectory.dto.MenuItemDTO;
import com.project.tejas.menuDirectory.entity.MenuItem;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MenuItemMapper {
    MenuItemMapper INSTANCE = Mappers.getMapper(MenuItemMapper.class);
    MenuItem mapMenuDirectoryDTOtoMenuDirectory(MenuItemDTO menuItemDTO);
    MenuItemDTO mapMenuDirectoryToMenuDirectoryDTO(MenuItem menuItem);
}
