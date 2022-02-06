package org.allforone.spring.repository;

import org.allforone.spring.domain.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuRepository extends JpaRepository<Menu, String> {

}
