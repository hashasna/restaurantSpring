package com.example.restaurant.services;

import com.example.restaurant.dto.MenuDto;
import com.example.restaurant.model.Menu;
import com.example.restaurant.repository.MenuRepository;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MenuService {

    private MenuRepository menuRepository;

    public List<MenuDto> getMenuDto(){
        List<Menu> menus = menuRepository.findAll();
        ModelMapper mp = new ModelMapper();
        return menus.stream().map(x -> mp.map(x, MenuDto.class)).collect(Collectors.toList());
    }
}
