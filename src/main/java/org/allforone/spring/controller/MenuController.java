package org.allforone.spring.controller;

import org.allforone.spring.domain.Menu;
import org.allforone.spring.service.MenuService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;


@Controller
public class MenuController {
    private MenuService menuService;

    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    @RequestMapping(value = "/menu", method = RequestMethod.GET)
    public String main(Model model){
        List<Menu> menus = menuService.getMenu();
        model.addAttribute("menus", menus);
        return "menu";
    }
}