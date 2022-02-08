package org.allforone.spring.controller;

import org.allforone.config.AppConfig;
import org.allforone.spring.service.MenuService;
import org.allforone.config.web.MvcConfig;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.AnnotationConfigWebContextLoader;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {AppConfig.class, MvcConfig.class}, loader = AnnotationConfigWebContextLoader.class)
@WebAppConfiguration
@ActiveProfiles("test")
public class MenuControllerTest {

    @Autowired
    MenuService menuService;

    @Test
    void getMenu() {
        assertNotNull(menuService.getMenu());
    }
}
