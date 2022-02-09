package org.allforone.spring.controller;

import org.allforone.spring.WebTestConfig;
import org.allforone.spring.service.MenuService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@WebTestConfig
public class MenuControllerTest {

    @Autowired
    MenuService menuService;

    @Test
    void getMenu() {
        assertNotNull(menuService.getMenu());
    }
}
