package com.example.recipeCatalog.services;

import com.example.recipeCatalog.models.Menu;
import com.example.recipeCatalog.models.Recipe;
import com.example.recipeCatalog.repositories.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuService {

    @Autowired
    public MenuRepository repository;

    public Menu findMenuById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public boolean delete(Long id){
        repository.deleteById(id);
        return true;
    }

    public Menu update(Long id, Menu menu){
        Menu ogMenu = repository.findById(id).orElse(null);
        if(ogMenu == null) {
            return null;
        }
        ogMenu.setRecipes(menu.getRecipes());

        return repository.save(menu);

    }

    public Menu createMenuFromRecipes(List<Recipe> recipes){
        if(recipes.size() != 7){
            return null;
        }
        return new Menu(recipes);
    }

}
