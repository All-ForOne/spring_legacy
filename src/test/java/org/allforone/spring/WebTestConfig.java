package org.allforone.spring;

import org.allforone.config.AppConfig;
import org.allforone.config.web.MvcConfig;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@SpringJUnitWebConfig(classes = {AppConfig.class, MvcConfig.class})
@ActiveProfiles("test")
public @interface WebTestConfig {
}
