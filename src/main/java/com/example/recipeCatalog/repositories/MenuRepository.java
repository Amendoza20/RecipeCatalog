package com.example.recipeCatalog.repositories;

import com.example.recipeCatalog.models.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Long> {
    Menu findByMenuId(Long id);

}
