package me.viharev.libraries.services.impl;

import lombok.extern.slf4j.Slf4j;
import me.viharev.libraries.models.Recipe;
import me.viharev.libraries.services.RecipeServices;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.Map;
@Slf4j
@Service
public class RecipeServicesImpl implements RecipeServices {
    public static Integer idRecipe = 0;
    private final Map<Integer, Recipe> recipeMap = new LinkedHashMap<>();

    @Override
    public Integer addRecipe(Recipe recipe) {
        recipeMap.put(idRecipe, recipe);
        idRecipe++;
        return idRecipe;
    }

    @Override
    public void getRecipe() {
        for (Recipe recipe : recipeMap.values()) {
            System.out.println(recipe.toString());
        }
    }

    @Override
    public Recipe getRecipeById(Integer idRecipe) {
        for (Integer integer : recipeMap.keySet()) {
            if (integer.equals(idRecipe)) {
                return recipeMap.get(idRecipe);
            }
        }
        return null;
    }

    @Override
    public Recipe editRecipe(Integer idRecipe, Recipe recipe) {
        for (Integer integer : recipeMap.keySet()) {
            if (integer.equals(idRecipe)) {
                recipeMap.put(idRecipe, recipe);
                return recipe;
            }
        }
        return null;
    }
    @Override
    public boolean removeRecipe(Integer idRecipe) {
        for (Integer integer : recipeMap.keySet()) {
            if (integer.equals(idRecipe)) {
                recipeMap.remove(idRecipe);
                return true;
            }
        }
        return false;
    }
}
