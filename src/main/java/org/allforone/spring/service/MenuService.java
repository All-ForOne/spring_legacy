package org.allforone.spring.service;

import org.allforone.spring.domain.Menu;
import org.allforone.spring.repository.MenuRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuService {
    private MenuRepository menuRepository;

    public MenuService(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    public List<Menu> getMenu(){
        List<Menu> menus = menuRepository.findAll();
        return menus;
    }
}
