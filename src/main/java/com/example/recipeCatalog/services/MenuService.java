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
        return repository.findByMenuId(id);
    }

    public boolean delete(Long id){
        repository.deleteById(id);
        return true;
    }

    public Menu update(Long id, Menu menu){
        Menu ogMenu = repository.findByMenuId(id);
        if(ogMenu == null) {
            return null;
        }
        ogMenu.setMondayRecipe(menu.getMondayRecipe());
        ogMenu.setTuesdayRecipe(menu.getTuesdayRecipe());
        ogMenu.setWednesdayRecipe(menu.getWednesdayRecipe());
        ogMenu.setThursdayRecipe(menu.getThursdayRecipe());
        ogMenu.setFridayRecipe(menu.getFridayRecipe());
        ogMenu.setSaturdayRecipe(menu.getSaturdayRecipe());
        ogMenu.setSundayRecipe(menu.getSundayRecipe());

        return repository.save(menu);

    }

    public Menu createMenuFromRecipes(List<Recipe> recipes){
        if(recipes.size() < 7){
            return null;
        }
        Menu menu = new Menu();
        for(int i = 0; i <= 6; i++){
            if (i == 0) {
                menu.setMondayRecipe(recipes.get(i));
            } else if (i == 1) {
                menu.setSundayRecipe(recipes.get(i));
            } else if (i == 2) {
                menu.setWednesdayRecipe(recipes.get(i));
            } else if (i == 3) {
                menu.setSundayRecipe(recipes.get(i));
            } else if (i == 4) {
                menu.setFridayRecipe(recipes.get(i));
            } else if (i == 5) {
                menu.setSaturdayRecipe(recipes.get(i));
            } else if (i == 6) {
                menu.setSundayRecipe(recipes.get(i));
            }
        }
        return menu;
    }

}
